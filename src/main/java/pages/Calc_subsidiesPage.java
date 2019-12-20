package pages;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class Calc_subsidiesPage extends ParentPage implements IsUserPresent {

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

    public void closePageMinFin(){
        actionsWithElements.closePage();
    }

    public Integer getActualWageMinSize() {
            openPageMinFin();
            String actualMinWage = webDriver.findElement(By.xpath(".//tbody//tr[last()]//td[@align = 'right'][4]")).getText();
        Integer wageMin = Integer.parseInt(actualMinWage);
            logger.info("Min wage is equals " + wageMin + " грн.");
            return wageMin;
    }

    public void fillFieldsAndClickButton(String income, String residents) {
        actionsWithElements.enterTextIntoInput(dohod, income);
        actionsWithElements.enterTextIntoInput(residentsAmount, residents);
        actionsWithElements.clickOnElement(calcButton);
    }

    public float getSubsidyAmount(int income, int residentsAmount) {
        int wageMin = getActualWageMinSize();
        int result = (1500 / 2 / wageMin / 2 * 15 / 100 * 1500);
            float res = (float)(result);
            //String resultFormat = String.format("%.2f", result);
            logger.info("Subsidy is equals " + res + " грн.");
        return res;
    }

    public String getSubsidy() {
        return
                webDriver.findElement(By.xpath(".//td[contains(text(),'Обов’язкова плата за ЖКП')]//following-sibling::td/b[@class='green']")).getText();
    }

    public void checkSum(String sum) {
        try {
            Assert.assertEquals("Wrong sum",
                    sum,
                    getSubsidy());
            logger.info(sum + " is equals " + getSubsidy());
        } catch (Exception e) {
            logger.info(sum + " is not equals " + getSubsidy());
        }
    }

    public void checkSubsSum(Integer income, Integer residentsAmount) {
        try {
            Assert.assertEquals("Wrong sum",
                    getSubsidyAmount(income, residentsAmount),
                    getSubsidy());
            logger.info(getSubsidyAmount(income, residentsAmount) + " is equals " + getSubsidy());
        } catch (Exception e) {
            logger.info(getSubsidyAmount(income, residentsAmount) + " is not equals " + getSubsidy());
        }
    }


//    public double getSubsidy() {
//        try {
//            fillFieldsAndClickButton("1500", "2");
//            String subsidyString = webDriver.findElement(By.xpath("//td[contains(text(),'Обов’язкова плата за ЖКП')]//following-sibling::td")).getText();
//            double subsidyStringFl= System.out.println(subsidyString.replaceAll("[^ грн.]"));
//            }
////            String subsidy = String.format("%.2f", subsidyString);
//            //logger.info("Sybsidy you get from site gioc is " + subsidyString);
//        } catch (Exception e) {
//            logger.info("Cannot work with element");
//        }return getSubsidy();
//    }

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
