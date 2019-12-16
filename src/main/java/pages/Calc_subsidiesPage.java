package pages;

import org.openqa.selenium.WebDriver;
import parentPage.ParentPage;

public class Calc_subsidiesPage extends ParentPage implements IsUserPresent {

    public Calc_subsidiesPage(WebDriver webDriver, String partUrl) {
        super(webDriver, partUrl);
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
