package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class EditUserSettingsPage extends ParentPage {
    public EditUserSettingsPage(WebDriver webDriver) {
        super(webDriver, "cabinet/settings/info/");
    }

    @FindBy(xpath = ".//div[@class = 'account-open']")
    private WebElement openAccount;
    @FindBy(xpath = ".//*/div[@class = 'item settings with-border']")
    private WebElement selectEditSettings;
    @FindBy(xpath = ".//input[@id = 'reg-fathername']")
    private WebElement fatherNameField;
    @FindBy(xpath = ".//button")
    private WebElement button;
    @FindBy(xpath = ".//h2[contains(text(), 'Зміни збережено')]")
    private WebElement message;

    public void selectMenuFromUsersProfile() {
        WebElement element = webDriver.findElement(By.xpath(".//div[@class = 'account-open']"));
        actionsWithElements.moveMouseOnElement(element);
        WebElement element2 = webDriver.findElement(By.xpath(".//*/div[@class = 'item settings with-border']"));
        actionsWithElements.moveMouseOnElement(element2);
        actionsWithElements.clickOnElement(selectEditSettings);
    }

    public void enterFatherNameIntoField(String fatherName) {
        try {
            actionsWithElements.enterTextIntoInput(fatherNameField, fatherName);
            logger.info("FatherName was entered");
        } catch (Exception e) {
            logger.info("FatherName was not entered");
        }
    }

    public void clickOnSaveButton() {
        try {
            actionsWithElements.clickOnElement(button);
            logger.info("'Save button' was clicked");
        } catch (Exception e) {
            logger.info("'Save button' was not clicked");
        }
    }

    public void messageIsDisplayed() {
        actionsWithElements.isElementDisplayed(message);
    }

    public void checkMessageIsDisplayed() {
        try {
            messageIsDisplayed();
            logger.info("Message is displayed");
        } catch (Exception e) {
            logger.info("Message is not displayed");
        }
    }
}
