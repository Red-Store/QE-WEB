package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.RedstoreLoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RedstoreLoginSteps {
    private final WebDriver driver = Hooks.driver;
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
    public void inpuFieldEmail(String email, String password)throws InterruptedException{
        redstoreLoginPage.inputFieldEmail(email);
        redstoreLoginPage.inputFieldPassword(password);
        redstoreLoginPage.clickButtonLogin();
        Thread.sleep(3000);
    }
}
