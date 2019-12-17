package objectsTest;

import io.qameta.allure.*;
import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

@Epic("Allure examples")
@Feature("Junit 4 support")
public class AddNewObjectTest extends ParentTest {
    @Description("Some detailed test description")
    @Story("Base support for bdd annotations")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @Issue("123")
    @Issue("432")
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

    @After
    public void deleteObject() {
        objectsPage.deleteObject();
    }
}
