package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage implements IsUserPresent {
    @FindBy(id = "reg-name")
    private WebElement regName;
    @FindBy(tagName = "button")
    private WebElement authorizationButton;
    @FindBy(xpath = "//a[@class='first cabinet']")
    private WebElement enterToCabinet;
    @FindBy(xpath = ".//a[@class='btn green btn-login']")
    private WebElement loginButton;
    @FindBy(xpath = ".//input[@class='txt form-txt-input' and @name='email']")
    private WebElement email;
    @FindBy(xpath = ".//input[@id='login-phone']")
    private WebElement inputPhone;
    @FindBy(xpath = ".//input[@id='reg-password']")
    private WebElement inputPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "cabinet/login/");
    }

    public void enterToCabinet() {
        enterToCabinet.click();
        logger.info("'Enter to Cabinet' button should be clicked");
    }

    public void enterRegName(String name) {
        actionsWithElements.enterTextIntoInput(regName, name);
    }

    public void clickOnLoginButton() {
        actionsWithElements.clickOnElement(loginButton);
        logger.info("Login button should be clicked");
    }

    public void clearEmail() {
        email.clear();
    }

    public void enterNumbersIntoTel(String phone) {
        actionsWithElements.enterTextIntoInput(inputPhone, phone);
        logger.info(phone + " was inputed into Phone");
    }

    public void enterPasswordIntoPassword(String password) {
        actionsWithElements.enterTextIntoInput(inputPassword, password);
        logger.info(password + " was inputed into Password");
    }

    public void clickAuthorization() {
        actionsWithElements.clickOnElement(authorizationButton);
        logger.info("Authorization completed");
    }

    public void fillLoginFormAndSubmitIt(String phone, String password) {
        actionsWithElements.openPage("https://www.gioc.kiev.ua/");
        enterToCabinet();
        clickOnLoginButton();
        clearEmail();
        enterNumbersIntoTel(phone);
        enterPasswordIntoPassword(password);
       clickAuthorization();
    }

    @Override
    public boolean IsAvatarPresent() {
        return false;
    }

    @Override
    public boolean IsUserFirstamePresent() {
        return false;
    }

    @Override
    public boolean IsUserLastnamePresent() {
        return false;
    }
}