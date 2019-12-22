package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
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
        try {
            enterToCabinet.click();
            logger.info("Button 'Enter to Cabinet' is clicked");
        } catch (Exception e) {
            logger.info("'Enter to Cabinet' button should be clicked");
        }
    }

    public void enterRegName(String name) {
        actionsWithElements.enterTextIntoInput(regName, name);
    }

    public void clickOnLoginButton() {
        try {
            actionsWithElements.clickOnElement(loginButton);
            logger.info("Login button is clicked");
        } catch (Exception e) {
            logger.info("Login button should be clicked");
        }
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
        try {
            actionsWithElements.clickOnElement(authorizationButton);
            logger.info("Authorization completed");
        } catch (Exception e) {
            logger.info("Authorization was not completed");
        }
    }

    @Step
    public void fillLoginFormAndSubmitIt(String phone, String password) {
        actionsWithElements.openPage("https://www.gioc.kiev.ua/");
        enterToCabinet();
        clickOnLoginButton();
        clearEmail();
        enterNumbersIntoTel(phone);
        enterPasswordIntoPassword(password);
        clickAuthorization();
    }
}