package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
    }

    public void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            webDriverWait_10 = new WebDriverWait(webDriver, 10);
            logger.info(text + " element was inputted");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            webDriverWait_10 = new WebDriverWait(webDriver, 10);
            logger.error("Element was clicked");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed" + state);
            return state;
        } catch (Exception e) {
            logger.info("Is element displayed -> false");
            return false;
        }
    }

    public void selectElement(WebElement webElement) {
        try {
            boolean ElementIsSelected = webElement.isSelected();
            logger.info(ElementIsSelected + " was selected");
        } catch (Exception e) {
            logger.info("Element is not selected");
        }
    }

    public void moveMouseOnElement(WebElement webElement) {
        Actions moveMouseToElement = new Actions(webDriver);
        moveMouseToElement.moveToElement(webElement).build().perform();
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
    }

    public void selectElementFromDropdownList(WebElement dropdown, String element) {
        try {
            Select select = new Select(dropdown);
            select.selectByVisibleText(element);
            logger.info(element + " element was selected");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    public void selectElementFromDropdownListByValue(WebElement dropdown, String element) {
        try {
            Select select = new Select(dropdown);
            select.selectByValue(element);
            logger.info(element + " element was selected");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }
}
