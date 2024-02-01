package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedstoreLoginPage {
    public static WebDriver webDriver;

    public RedstoreLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//img[@alt='logo-brand']")
    private WebElement logoWebsite;
    @FindBy(xpath = "//a[.='Sign in']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement fieldEmail;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPassword;
    @FindBy(xpath = "//button[@class='w-full md:w-1/3 py-3 rounded-md bg-red-500 text-white ']")
    private WebElement buttonLogin;

    public boolean verifyLogoWebsite(){
        return logoWebsite.isDisplayed();
    }
    public void clickButtonSignin(){
        buttonSignIn.click();
    }
    public void inputFieldEmail(String email){
        fieldEmail.sendKeys(email);
    }
    public void inputFieldPassword(String password){
        fieldPassword.sendKeys(password);
    }
    public void clickButtonLogin(){
        buttonLogin.click();
    }

}
