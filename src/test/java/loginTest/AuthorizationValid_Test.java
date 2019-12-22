package loginTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class AuthorizationValid_Test extends ParentTest {
    @Description("Fill login form with valid data and check that User name is correct")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void authorizationValid() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");
        homePage.checkCorrectName("Wrong name", "Anastasiia Student");
    }
}
