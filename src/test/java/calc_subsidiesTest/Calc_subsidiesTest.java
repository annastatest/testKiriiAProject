package calc_subsidiesTest;

import io.qameta.allure.*;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class Calc_subsidiesTest extends ParentTest {
    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Ignore
    @Test
    public void subsidyAmount() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");
        objectsPage.selectMenuFromOnLineCalc();
        calc_subsidiesPage.enterIncomeToField("1500");
        calc_subsidiesPage.enterIncomeToField("2");
        calc_subsidiesPage.clickOnСalculateButton();

        checkExpectedResult1("Wrong subsidy amount",
                calc_subsidiesPage.getSubsidyAmount(1500, 2),
                calc_subsidiesPage.getSubsidy());
    }//тест должен зафейлиться, тк на сайте баг - взяты показатели прожиточного мин за 2015 год

}
