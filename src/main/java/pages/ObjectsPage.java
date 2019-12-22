package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ObjectsPage extends ParentPage {

    public ObjectsPage(WebDriver webDriver) {
        super(webDriver, "cabinet/objects");
    }

    @FindBy(xpath = ".//div[@class = 'btn green bold big add-new']")
    private WebElement clickOnObjectButton;

    @FindBy(xpath = ".//input[@id = 'add_obj_street']")
    private WebElement streetField;

    @FindBy(xpath = ".//a[@class = 'ui-corner-all']")
    private WebElement selectStreet;

    @FindBy(xpath = ".//select[@id='add_obj_house']")
    private WebElement clickOnHouseField;

    @FindBy(xpath = ".//select[@id = 'add_obj_flat']")
    private WebElement clickOnFlatField;

    @FindBy(xpath = ".//button[@class = 'btn green bold']")
    private WebElement button;

    @FindBy(xpath = ".//input[@id = 'add_obj_auth_key']")
    private WebElement clickOnAuthField;

    @FindBy(xpath = ".//div[@class = 'title']//div[@class = 'icon']")
    private WebElement iconIsPresent;

    @FindBy(xpath = ".//a[contains(text(),'Перейти до об’єкту')]")
    private WebElement goToObjectLinkIsPresent;

    @FindBy(xpath = ".//div[@class = 'error-description']")
    private WebElement messageAboutError;

    @FindBy(xpath = ".//a[@href='https://www.gioc.kiev.ua/calc-subsidies/']")
    private WebElement selectEditSettings;

    @Step
    public void clickOnAddNewObjectButton() {
        try {
            actionsWithElements.clickOnElement(clickOnObjectButton);
            logger.info("'AddNewObject' button was clicked");
        } catch (Exception e) {
            logger.info("'AddNewObject' button was not clicked");
        }
    }

    @Step
    public void fillFieldsOfNewObjects(String street, String housenumber, String flatnumber) {
        actionsWithElements.enterTextIntoInput(streetField, street);
        actionsWithElements.clickOnElement(selectStreet);
        actionsWithElements.clickOnElement(clickOnHouseField);
        actionsWithElements.selectElementFromDropdownListByValue(clickOnHouseField, housenumber);
        actionsWithElements.clickOnElement(clickOnFlatField);
        actionsWithElements.selectElementFromDropdownListByValue(clickOnFlatField, flatnumber);
    }

    @Step
    public void clickOnAddObject() {
        actionsWithElements.clickOnElement(button);
    }

    @Step
    public void clickAndFillAuthField(String auth_key) {
        actionsWithElements.clickOnElement(clickOnAuthField);
        actionsWithElements.enterTextIntoInput(clickOnAuthField, auth_key);
    }

    @Step
    public boolean IsNewIconDisplayed() {
        return actionsWithElements.isElementDisplayed(iconIsPresent);

    }

    @Step
    public boolean IsGoToObjectLinkDisplayed() {
        return actionsWithElements.isElementDisplayed(goToObjectLinkIsPresent);
    }

    public String getCurrentStreetName() {
        return webDriver.findElement(By.xpath(".//div[@class = 'title']//span[@title]")).getText();
    }

    @Step
    public void checkStreetName(String streetName) {
        try {
            Assert.assertEquals(
                    "Wrong street name",
                    getCurrentStreetName(),
                    streetName);
            logger.info("Current streetName is " + streetName);
        } catch (Exception e) {
            logger.info("Wrong street name");
        }
    }

    @Step
    public void checkMessageAboutErrorIsDisplayed() {
        Assert.assertTrue(actionsWithElements.isElementDisplayed(messageAboutError));
    }

    @Step
    public void selectMenuFromOnLineCalc() {
        WebElement element = webDriver.findElement(By.xpath(".//div[@class='calc-btn']"));
        actionsWithElements.moveMouseOnElement(element);
        WebElement element2 = webDriver.findElement(By.xpath(".//a[@href='https://www.gioc.kiev.ua/calc-subsidies/']"));
        actionsWithElements.moveMouseOnElement(element2);
        actionsWithElements.clickOnElement(selectEditSettings);
    }
}
