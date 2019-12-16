package libs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class ExtraneousResources {

    protected WebDriver webDriver;

    private void openPage() {
        try {
            webDriver.get("https://index.minfin.com.ua/labour/wagemin/");
        } catch (Exception e) {
            Assert.fail("Cannot work with browser");
        }
    }

    public String getActualWageMinSize() {
        openPage();
        return webDriver.findElement(By.xpath(".//tbody//tr[last()]//td[@align = 'right'][4]")).getText();
    }
}
