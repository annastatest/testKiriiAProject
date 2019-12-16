package calc_subsidiesTest;

import org.junit.Test;
import parentTest.ParentTest;

public class Calc_subsidiesTest extends ParentTest {
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
