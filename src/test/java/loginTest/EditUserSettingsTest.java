package loginTest;

import org.junit.Test;
import parentTest.ParentTest;

public class EditUserSettingsTest extends ParentTest {
    @Test
    public void addFathersNameToUserSettings() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");
        editUserSettingsPage.selectMenuFromUsersProfile();
        editUserSettingsPage.enterFatherNameIntoField("Uuuu");
        editUserSettingsPage.clickOnSaveButton();
        editUserSettingsPage.checkMessageIsDisplayed();
    }
}
