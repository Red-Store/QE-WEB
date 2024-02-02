package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.RedstoreLoginPage;
import org.example.pageObject.RedstoreProfilPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RedstoreUpdateProfileSteps {

    private final WebDriver driver = Hooks.driver;
    RedstoreProfilPage redstoreProfilPage = new RedstoreProfilPage(driver);

    @Then("User click icon profile")
    public void clickIconProfile() throws InterruptedException{
        redstoreProfilPage.clickIconProfile();
        Thread.sleep(1000);
    }
    @And("User click button profile")
    public void clickButtonProfile() throws InterruptedException{
        redstoreProfilPage.clickButtonProfile();
        Thread.sleep(1000);
    }
    @And ("User edit name with {string} and username with {string}")
    public void editNameUsername(String name, String username) throws InterruptedException{
        Assert.assertTrue(redstoreProfilPage.verifyTextProfile());
        redstoreProfilPage.clickButtonEditProfile();
        redstoreProfilPage.inputEditName(name);
        redstoreProfilPage.inputEditUsername(username);
        Thread.sleep(1000);
    }
    @And("User click button submit")
    public void clickButtonSubmit() throws InterruptedException{
        redstoreProfilPage.clickButtonSubmit();
        Thread.sleep(2000);
    }
    @Then("User see {string} as a message")
    public void verifyTextMessage(String textMessage){
        Assert.assertEquals(textMessage,redstoreProfilPage.getTextMessage());
    }
    @When("User click button logout")
    public void clickButtonLogout() throws InterruptedException{
        redstoreProfilPage.clickButtonLogout();
        Thread.sleep(1000);
    }
    @Then("User will go back to login page")
    public void verifyAlreadyLogout(){
        Assert.assertTrue(redstoreProfilPage.verifyLogoBrand());
    }

}
