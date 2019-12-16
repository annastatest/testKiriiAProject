package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AuthorizationValid_Test extends ParentTest {

    @Test
    public void authorizationValid() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");

        String userName = "Anastasiia Student";
        homePage.correctName("Wrong name", userName);
    }
}
