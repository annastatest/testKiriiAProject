package objectsTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewObjectTest extends ParentTest {
    @Description("Add 1 new object with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void addNewObject() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");
        objectsPage.clickOnAddNewObjectButton();
        objectsPage.fillFieldsOfNewObjects("верби", "1072961001", "932340");
        objectsPage.clickOnAddObject();
        objectsPage.clickAndFillAuthField("K4WC-E672-EPBL");
        objectsPage.clickOnAddObject();

        checkExpectedResult("Icon is not present",
                objectsPage.IsNewIconDisplayed());

        checkExpectedResult("Link not present",
                objectsPage.IsGoToObjectLinkDisplayed());

        objectsPage.checkStreetName("ВЕРБИЦЬКОГО АР...");
    }
}
