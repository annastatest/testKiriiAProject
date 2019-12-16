package objectsTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewObjectTest extends ParentTest {
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

        objectsPage.checkStreetName("ВЕРБИЦЬКОГО АРХІТЕКТОРА ВУЛ.");


//        String houseAndFlatNumber = "Київ, ВЕРБИЦЬКОГО АРХІТЕКТОРА ВУЛ., буд. 14В, кв. 188";
//        checkExpectedResult1("Data is not expected",
//                houseAndFlatNumber,
//                objectsPage.);
        }


}
