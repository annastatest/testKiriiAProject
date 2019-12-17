package pages;

import io.qameta.allure.Step;
import libs.ExtraneousResources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class Calc_subsidiesPage extends ParentPage implements IsUserPresent {

    protected ExtraneousResources extraneousResources;

    @FindBy(xpath = ".//input[@id='DOHOD']")
    private WebElement dohod;

    @FindBy(tagName = "button")
    private WebElement calcButton;

    public Calc_subsidiesPage(WebDriver webDriver) {
        super(webDriver, "calc-subsidies");
    }

    @Step
    public void enterIncomeToField(String income) {
        actionsWithElements.enterTextIntoInput(dohod, income);
    }

    @Step
    public void clickOnСalculateButton() {
        actionsWithElements.clickOnElement(calcButton);
    }

    public Integer getSubsidyAmount(Integer incomeAmount, Integer peopleAmount) {
        String wageMinString = extraneousResources.getActualWageMinSize();
        Integer wageMin = Integer.parseInt(wageMinString);
        return incomeAmount / peopleAmount / wageMin / 2 * 15 / 100 * incomeAmount;
    }


    public Integer getSubsidy() {
        String subsidyString = webDriver.findElement(By.xpath("//td[contains(text(),'Обов’язкова плата за ЖКП')]//following-sibling::td")).getText();
        Integer subsidy = Integer.parseInt(subsidyString);
        return subsidy;
    }

    @Override
    public boolean IsAvatarPresent() {
        return true;
    }

    @Override
    public boolean IsUserFirstamePresent() {
        return true;
    }

    @Override
    public boolean IsUserLastnamePresent() {
        return true;
    }
}
