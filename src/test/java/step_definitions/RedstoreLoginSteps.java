package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.example.pageObject.RedstoreLoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static step_definitions.Hooks.driver;

public class RedstoreLoginSteps {
    private final WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    RedstoreLoginPage redstoreLoginPage = new RedstoreLoginPage(driver);

    @Given("User already on homepage")
    public void verifyUserName(){
        Assert.assertTrue(redstoreLoginPage.verifyLogoWebsite());
    }
    @Then("User click button sign in")
    public void clickButtonSignin() {
        redstoreLoginPage.clickButtonSignin();
    }

    @When("User input {string} as email and {string} as password")
    public void inpuFieldEmail(String email, String password)  {
        redstoreLoginPage.inputFieldEmail(email);
        redstoreLoginPage.inputFieldPassword(password);
        redstoreLoginPage.clickButtonLogin();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("User click fourth product from catalog")
    public void clickFourthProduct() {
        redstoreLoginPage.clickProductFourth();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Then ("User already on product page")
    public void verifyProductPage(){
        Assert.assertTrue(redstoreLoginPage.verifyImageProductPage());
    }
    @When("User click add to cart the product")
    public void clickAddToCartProduct()throws InterruptedException{
        driver.navigate().refresh();
        redstoreLoginPage.clickAddToCart();
        TimeUnit.SECONDS.sleep(1);

        // Setelah jeda, melanjutkan eksekusi
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }
    @When("User click the cart")
    public void clickCart()throws InterruptedException{
        redstoreLoginPage.clickCart();
        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(1);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Then ("User already on cart page")
    public void verifyCartPage()throws InterruptedException{
        driver.navigate().refresh();
        Assert.assertTrue(redstoreLoginPage.verifyCartPage());
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @When("User want increase quantity")
    public void userIncreaseQuantity() throws InterruptedException{
//        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(1);
        redstoreLoginPage.clickIncreaseQuantity();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Then("Verify total value is correct")
    public void verifyTotalValue() {
        String expectedValue = "Rp 20.000.000,00";

        // Create XPath to locate the total value
        By totalValueXPath = By.xpath("//div[@class='flex justify-between mb-6']//p[contains(text(),'Total:')]/following-sibling::p");

        // Find the WebElement using the XPath
        WebElement totalElement = driver.findElement(totalValueXPath);

        // Get the actual value from the WebElement
        String actualValue = totalElement.getText();

        // Perform the verification
        Assert.assertEquals(expectedValue, actualValue);
    }
    @When("User click process order")
    public void clickProcessOrder(){
        redstoreLoginPage.clickButtonProcessOrder();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Then("User already on order page")
    public void userAlreadyOnOrderPage() {
        Assert.assertTrue(redstoreLoginPage.verifyOrderPage());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("User input {string} as an address")
    public void userInputAddressSetThePaymentMethodConfirmAndCheckoutTheProduct(String address) throws InterruptedException {
        redstoreLoginPage.inputAddress(address);
    }
    @When("User set the payment method and confirm")
      public void userSetPaymentMethod()throws InterruptedException{
        redstoreLoginPage.clickPaymentMethod();
        TimeUnit.SECONDS.sleep(1);
        redstoreLoginPage.clickPaymentBCA();
        redstoreLoginPage.clickAgreement();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            }
    @When("User click checkout product")
            public void clickCheckoutProduct()throws InterruptedException{
        redstoreLoginPage.clickCheckout();
        TimeUnit.SECONDS.sleep(1);
    }



    @Then("User already complete the order")
    public void userAlreadyCompleteTheOrder() {
        Assert.assertTrue(redstoreLoginPage.verifyOrderResult());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
