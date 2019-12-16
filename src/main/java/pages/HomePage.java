package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import parentPage.ParentPage;


public class HomePage extends ParentPage implements IsUserPresent {
    public HomePage(WebDriver webDriver) {
        super(webDriver, "cabinet/objects/");
    }

    public String getUserName() {
        String userName = webDriver.findElement(By.xpath(".//div[@class='username']/span")).getText();
        return userName;
    }

    public Boolean correctName(String message, String name) {
        Assert.assertEquals(message, getUserName(), name);
        return true;
    }


    @Override
    public boolean IsAvatarPresent() {
        return true;
    }

    @Override
    public boolean IsUserFirstamePresent() {

        return true;
    }

    @Override
    public boolean IsUserLastnamePresent() {
        return true;
    }
}
