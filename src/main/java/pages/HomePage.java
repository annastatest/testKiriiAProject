package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import parentPage.ParentPage;


public class HomePage extends ParentPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver, "cabinet/objects/");
    }

    public String getUserName() {
        String userName = webDriver.findElement(By.xpath(".//div[@class='username']/span")).getText();
        return userName;
    }

    @Step
    public void checkCorrectName(String message, String userName) {
        Assert.assertEquals(message, getUserName(), userName);
    }
}
