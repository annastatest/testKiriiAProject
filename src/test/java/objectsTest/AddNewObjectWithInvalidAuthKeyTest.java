package objectsTest;

import io.qameta.allure.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@Epic("Allure examples")
@Feature("Junit 4 support")
public class AddNewObjectWithInvalidAuthKeyTest extends ParentTest {
    String auth_key;

    public AddNewObjectWithInvalidAuthKeyTest(String auth_key) {
        this.auth_key = auth_key;
    }

    @Parameterized.Parameters(name = "Parameters are {0} ")
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                        {"1234-5678-9012"},
                        {"1234-5678-0"},
                        {"yhug-fdr4-23eg"}
                }
        );
    }

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
        objectsPage.clickAndFillAuthField(auth_key);
        objectsPage.clickOnAddObject();
        objectsPage.checkMessageAboutErrorIsDisplayed();
    }
}
