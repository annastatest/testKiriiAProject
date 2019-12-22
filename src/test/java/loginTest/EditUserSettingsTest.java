package loginTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class EditUserSettingsTest extends ParentTest {
    @Description("Father name field is empty. Test add valid data 'Father name' in User settings")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addFathersNameToUserSettings() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");
        editUserSettingsPage.selectMenuFromUsersProfile();
        editUserSettingsPage.enterFatherNameIntoField("Uuuu");
        editUserSettingsPage.clickOnSaveButton();
        editUserSettingsPage.checkMessageIsDisplayed();
    }
}
