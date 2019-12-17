package parentPage;

import libs.ActionsWithElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.WebDriverAwareDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(String.valueOf(getClass()));
    protected ActionsWithElements actionsWithElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl = "https://www.gioc.kiev.ua/";
    String expectedUrl;

    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        //PageFactory.initElements(webDriver, this);
        PageFactory.initElements(new WebDriverAwareDecorator(new HtmlElementLocatorFactory(webDriver), webDriver), this);
        actionsWithElements = new ActionsWithElements(webDriver);
        expectedUrl = baseUrl + partUrl;
    }

    public void checkUrl() {
        try {
            Assert.assertEquals(
                    "Url is wrong",
                    expectedUrl,
                    webDriver.getCurrentUrl()
            );
        } catch (Exception e) {
            logger.error("Cannot get url " + e);
            Assert.fail("Cannot get url " + e);
        }
    }
}