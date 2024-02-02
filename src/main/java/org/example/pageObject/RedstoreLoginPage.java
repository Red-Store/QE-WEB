package org.example.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedstoreLoginPage {
    public static WebDriver webDriver;


    public RedstoreLoginPage(WebDriver driver) {
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

    @FindBy(xpath = "(//div[@class=\"max-w-xl w-full border shadow-sm rounded-lg overflow-hidden group mt-7\"])[6]//h3[@class=\"font-semibold tracking-wide cursor-pointer max-w-[500px] min-h-12\"]")
    private WebElement fourthProduct;

    @FindBy(xpath = "//div[@class=\"flex flex-col space-y-8 items-center justify-center flex-1\"]/img[@class=\"max-w-[600px] h-[500px] rounded-lg\"]")
    private WebElement imageVerify;
    @FindBy(xpath = "//button[@class='bg-[#1E81B3] text-white py-3 px-8']")
    private WebElement buttonAddtoCart;
    @FindBy(xpath = "//table[@class='w-full table-cart mb-5 for-website']")
    private WebElement verifyCartPage;
    @FindBy(xpath = "(//a[contains(@href, '/cart') and .//*[contains(@class, 'lucide-shopping-cart')]])[2]")
    private WebElement buttonCart;
    @FindBy(xpath = "(//div[@class='w-8 h-8 flex justify-center items-center'])[1]")
    public WebElement valueQuantity;
    @FindBy(xpath = "//div[@class='flex items-center justify-center gap-2']/div[3]")
    private WebElement increaseQuantityButton;
    @FindBy(xpath = "//button[@class='px-4 md:py-3 md:px-8 h-10 md:h-14 border-2 border-slate-400 rounded-sm bg-red-500 text-white mx-1/5']")
    private WebElement buttonProcessOrder;
    @FindBy(xpath = "//div[contains(@class, 'flex-col') and contains(@class, 'space-y-10')]")
    private WebElement containerOrderPage;
    @FindBy(xpath = "//textarea[@placeholder=\" Alamat Penerima....\"]")
    private WebElement fieldAddress;
    @FindBy(xpath = "//button[contains(@class, 'flex flex-1 items-center justify-between py-4 font-medium transition-all') and contains(@class, '[&[data-state=open]>svg]:rotate-180 lg:text-lg rounded-lg rounded-b-none border border-b-0 pb-4 px-4 text-gray-800')]")
    private WebElement buttonPaymentMethod;
    @FindBy(xpath = "(//div[@class='flex cursor-pointer rounded-sm hover:bg-slate-100 gap-4 px-9 py-4 items-center hover:rounded-md'])[1]")
    private WebElement buttonPaymentBCA;
    @FindBy(xpath = "//button[@type='button' and @role='checkbox' and @aria-checked='false' and @data-state='unchecked' and @value='on']")
    private WebElement buttonAgreement;
    @FindBy(xpath = "//button[contains(@class, 'text-white') and contains(@class, 'w-full') and contains(@class, 'md:w-40') and contains(@class, 'py-3') and contains(@class, 'md:px-4') and contains(@class, 'rounded-md') and contains(@class, 'bg-[#1E81B3]')]")
    private WebElement buttonCheckout;
    @FindBy(xpath = "//div[@class='flex flex-col items-center space-y-8']\n")
    private WebElement orderResult;


    public boolean verifyLogoWebsite() {
        return logoWebsite.isDisplayed();
    }

    public void clickButtonSignin() {
        buttonSignIn.click();
    }

    public void inputFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }

    public void inputFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void clickButtonLogin() {
        buttonLogin.click();
    }

    public void clickProductFourth() {
        fourthProduct.click();
    }

    public boolean verifyImageProductPage() {
        return imageVerify.isDisplayed();
    }

    public void clickAddToCart() {
        buttonAddtoCart.click();
    }

    public boolean verifyCartPage() {
        return verifyCartPage.isDisplayed();
    }

    public void clickCart() {
        buttonCart.click();
    }

    public void clickIncreaseQuantity() {
        increaseQuantityButton.click();
    }

    public void clickButtonProcessOrder() {
        buttonProcessOrder.click();
    }

    public boolean verifyOrderPage() {
        return containerOrderPage.isDisplayed();
    }

    public void inputAddress(String address) {
        fieldAddress.sendKeys(address);
    }

    public void clickPaymentMethod() {
        buttonPaymentMethod.click();
    }

    public void clickPaymentBCA() {
        buttonPaymentBCA.click();
    }

    public void clickAgreement() {
        try {
            // Wait for a short period (you can adjust the sleep time as needed)
            Thread.sleep(1000);
            buttonAgreement.click();
        } catch (ElementClickInterceptedException e) {
            // If ElementClickInterceptedException occurs, try using JavaScriptExecutor to click
            clickElementWithJavaScript(buttonAgreement);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.err.println("Thread sleep interrupted: " + ex.getMessage());
        }
    }

    private void clickElementWithJavaScript(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) webDriver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception jsException) {
            // Handle any JavaScriptExecutor exception if needed
            jsException.printStackTrace();
        }
    }
    public boolean verifyOrderResult() {
        return orderResult.isDisplayed();
    }


    public void clickCheckout() {
        buttonCheckout.click();
    }







}
