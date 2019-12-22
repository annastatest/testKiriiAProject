package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

public class Calc_subsidiesPage extends ParentPage {

    @FindBy(xpath = ".//input[@id='DOHOD']")
    private WebElement dohod;

    @FindBy(id = "KL")
    private Link residentsAmount;

    @FindBy(tagName = "button")
    private WebElement calcButton;

    public Calc_subsidiesPage(WebDriver webDriver) {
        super(webDriver, "calc-subsidies");
    }

    public void openPageMinFin() {
        actionsWithElements.openPage("https://index.minfin.com.ua/labour/wagemin/");
    }

    public Integer getActualWageMinSize() {
        openPageMinFin();
        String actualMinWage = webDriver.findElement(By.xpath(".//tbody//tr[last()]//td[@align = 'right'][4]")).getText();
        Integer wageMin = Integer.parseInt(actualMinWage);
        logger.info("Min wage is equals " + wageMin + " грн.");
        return wageMin;
    }

    @Step
    public void fillFieldsAndClickButton(String income, String residents) {
        actionsWithElements.enterTextIntoInput(dohod, income);
        actionsWithElements.enterTextIntoInput(residentsAmount, residents);
        actionsWithElements.clickOnElement(calcButton);
    }

    public String getSubsidyAmount(double income, Integer residentsAmount) {
        openPageMinFin();
        Integer wageMin = getActualWageMinSize();
        double result = (income / residentsAmount / wageMin / 2 * 0.15 * 1500);
        result = new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue();
        String subsidyAmount = Double.toString(result);
        return subsidyAmount;
    }

    public String actualSubsidy() {
        String subside = webDriver.findElement(By.xpath(".//td[contains(text(),'Обов’язкова плата за ЖКП')]//following-sibling::td/b[@class='green']")).getText();
//        String res = subside.chars()
//                .filter(c -> !Character.isLetter(c))
//                .mapToObj(c -> String.valueOf((char) c))
//                .collect(Collectors.joining()).replaceAll(" ", "");
        return subside.replace(" грн", "").trim();
    }

    @Step
    public void checkSubSum(String expectedSubsidy, String actualSubsidy) {
        Assert.assertEquals("Wrong sum",
                expectedSubsidy,
                actualSubsidy);
    }
}