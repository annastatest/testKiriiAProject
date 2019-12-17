package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;
import sun.awt.image.ImageWatched;

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
    @FindBy(tagName = "button")
    private Link button;
    @FindBy(xpath = ".//h2[contains(text(), 'Зміни збережено')]")
    private WebElement message;

    @Step
    public void selectMenuFromUsersProfile() {
        WebElement element = webDriver.findElement(By.xpath(".//div[@class = 'account-open']"));
        actionsWithElements.moveMouseOnElement(element);
        WebElement element2 = webDriver.findElement(By.xpath(".//*/div[@class = 'item settings with-border']"));
        actionsWithElements.moveMouseOnElement(element2);
        actionsWithElements.clickOnElement(selectEditSettings);
    }

    @Step
    public void enterFatherNameIntoField(String fatherName) {
        actionsWithElements.enterTextIntoInput(fatherNameField, fatherName);
    }

    @Step
    public void clickOnSaveButton() {
        actionsWithElements.clickOnElement(button);
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
