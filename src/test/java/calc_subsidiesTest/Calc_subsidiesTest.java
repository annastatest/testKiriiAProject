package calc_subsidiesTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class Calc_subsidiesTest extends ParentTest {
    @Description("Take value of 'living wage' from another site, substitute the value in the formula and verify the result obtained with the result on the site 'gioc")
    @Severity(SeverityLevel.CRITICAL)
    @Ignore
    @Test
    public void subsidyAmount() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");
        objectsPage.selectMenuFromOnLineCalc();
        calc_subsidiesPage.fillFieldsAndClickButton("1500", "2");
        String actualSubsidy = calc_subsidiesPage.actualSubsidy();
        String expectedSubsidy = calc_subsidiesPage.getSubsidyAmount(1500.00, 2);
        calc_subsidiesPage.checkSubSum(expectedSubsidy, actualSubsidy);
    } // тест должен зафейлиться, тк на сайте баг - взяты показатели прожиточного мин за 2015 год
}
