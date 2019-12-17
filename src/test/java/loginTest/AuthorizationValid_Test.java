package loginTest;

import io.qameta.allure.*;
import org.junit.Test;
import parentTest.ParentTest;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class AuthorizationValid_Test extends ParentTest {
    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void authorizationValid() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");

        String userName = "Anastasiia Student";
        homePage.correctName("Wrong name", userName);
    }
}
