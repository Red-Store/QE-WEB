package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void openBrowser(){
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        //fungsi untuk setup chrome agar bisa terbuka
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        //inisiasi library selenium
        driver = new ChromeDriver(co);

//        String appUrl = "https://www.saucedemo.com/";
        String appUrl = "https://e-commerce-seven-coral.vercel.app/";
        driver.get(appUrl);//fungsi untuk ngebuka link html
        driver.manage().window().maximize();//fungsi untuk memaximize browser
    }

    @After(order = 0)
    public void closeBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }
}
