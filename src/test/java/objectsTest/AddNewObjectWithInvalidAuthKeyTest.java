package objectsTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewObjectWithInvalidAuthKeyTest extends ParentTest {
    @Test
    public void addNewObject() {
        loginPage.fillLoginFormAndSubmitIt("380503810022", "AutoTests");
        objectsPage.clickOnAddNewObjectButton();
        objectsPage.fillFieldsOfNewObjects("верби", "1072961001", "932340");
        objectsPage.clickOnAddObject();
        objectsPage.clickAndFillAuthField("5555-5555-5555");
        objectsPage.clickOnAddObject();
        objectsPage.checkMessageAboutErrorIsDisplayed();
    }
}
