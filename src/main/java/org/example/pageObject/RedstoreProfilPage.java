package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedstoreProfilPage {
    public static WebDriver webDriver;

    public RedstoreProfilPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(css = ".lucide-user-round")
    private WebElement iconProfile;
    @FindBy(xpath = "//div[.='Profile']")
    private WebElement buttonProfile;
    @FindBy(xpath = "//h1[@class='text-2xl font-semibold -mt-6']")
    private WebElement textProfile;
    @FindBy(xpath = "//button[@class='px-6 py-2 text-xs font-semibold rounded-md border bg-teal-500 text-white']")
    private WebElement buttonEditProfile;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement fieldEditName;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement fieldEditUsername;
    @FindBy(xpath = "//button[@class='px-5 py-1 rounded-md border bg-sky-500 text-white ']")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//div[@class='text-sm opacity-90']")
    private WebElement textMessage;
    @FindBy(xpath = "//div[.='Logout']")
    private WebElement buttonLogout;
    @FindBy(xpath = "//img[@alt='logo-brand']")
    private WebElement logoBrand;

    public void clickIconProfile(){
        iconProfile.click();
    }
    public void clickButtonProfile(){
        buttonProfile.click();
    }
    public boolean verifyTextProfile(){
        return textProfile.isDisplayed();
    }
    public void clickButtonEditProfile(){
        buttonEditProfile.click();
    }

    public void inputEditName(String name) {
        fieldEditName.clear();
        fieldEditName.sendKeys(name);
    }
    public void inputEditUsername(String username){
        fieldEditUsername.clear();
        fieldEditUsername.sendKeys(username);
    }
    public void clickButtonSubmit(){
        buttonSubmit.click();
    }
    public String getTextMessage(){
        return textMessage.getText();
    }
    public void clickButtonLogout(){
        buttonLogout.click();
    }
    public boolean verifyLogoBrand(){
        return logoBrand.isDisplayed();
    }

}
