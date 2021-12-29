import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.List;

public class FirstTest {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","C:/vica/job/Новая папка/training_mobile_auto/apks/org.wikipedia.apk");

        driver  = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

//    @Test
//    public  void firstTest()
//    {
//
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//        );
//
//    }
//
//    @Test
//    public void testCancelSearch()
//    {
//        waitForElementAndClick(By.id("org.wikipedia:id/search_container"),
//                "Cannot find 'Search Wikipedia' input",
//                5
//                );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementAndClear(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Cannot find search field",
//                5
//        );
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X to cancel search",
//                5
//        );
//
//        waitForElementNotPresent(By.id("org.wikipedia:id/search_close_btn"),
//                "X is still present on the page",
//                5
//                );
//
//    };
//
//    @Test
//    public void testCompareArticleTitle()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementAndClick(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
//                "Cannot find Search Wikipedia input",
//                5
//        );
//
//        WebElement title_element = waitForElementPresent(
//                By.id("org.wikipedia:id/view_page_title_text"),
//                "Cannot find article title",
//                15
//
//        );
//
//        String article_title = title_element.getAttribute("text");
//
//        Assert.assertEquals(
//                "We see unexpected title",
//                "Java (programming language)",
//                article_title
//        );
//    };

//    @Test
//    public void testElementText()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                5
//        );
//
//        waitForElementPresent(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Cannot find Search Wikipedia input",
//                15
//        );
//        String errorMessage = "Text in element with error";
//        String resultAssert = assertElementHasText(
//                By.id("org.wikipedia:id/search_src_text"),
//                "Search…",
//                errorMessage
//
//        );
//        Assert.assertEquals(errorMessage, "Ok", resultAssert);
//    }


//    @Test
//    public void testSearchCancel()
//    {
//        waitForElementAndClick(
//                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//                "Cannot find Search Wikipedia input",
//                5
//        );
//
//        waitForElementAndSendKeys(
//                By.xpath("//*[contains(@text, 'Search')]"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//
//        waitForElementPresent(
//                By.xpath("//*[contains(@text, 'Java')]"),
//                "Cannot find 'Java'",
//                15
//        );
//
//        List count_article = driver.findElementsById("org.wikipedia:id/page_list_item_title");
//      //  Тут возможно нужно еще проверять, что статьи содержат искомую строку
//
//        Assert.assertTrue("no find article",  count_article.size()>0);
//
//        waitForElementAndClick(By.id("org.wikipedia:id/search_close_btn"),
//                "Cannot find X to cancel search",
//                5
//        );
//        WebElement searchMessage = waitForElementPresent(By.id("org.wikipedia:id/search_empty_message"),
//                "Search is not empty",
//                5
//                );
//
//        String resultAssert = assertElementHasText(
//                By.id("org.wikipedia:id/search_empty_message"),
//                "Search and read the free encyclopedia in your language",
//                "page is not empty"
//        );
//        Assert.assertEquals("page is not empty", "Ok", resultAssert);
//
//    };


    @Test
    public void testSearchResult()
    {
        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search Wikipedia input",
                5
        );

        String string_search = "Java";

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text, 'Search')]"),
                string_search,
                "Cannot find search input",
                5
        );

        waitForElementPresent(
                By.xpath("//*[contains(@text, '"+string_search+"')]"),
                "Cannot find "+string_search ,
                15
        );

        List <WebElement> count_article = driver.findElementsByXPath("//*[@resource-id='org.wikipedia:id/page_list_item_title']");
        for(WebElement c_article:count_article) {
            String title_article = c_article.getText();
            Assert.assertTrue(
                    "some article in search result not contain "+string_search,
                    title_article.toLowerCase().contains(string_search.toLowerCase()));
        }

    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message)
    {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element =  waitForElementPresent(by, error_message, 5);
        element.click();
        return element;
    };

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element =  waitForElementPresent(by, error_message, 5);
        element.sendKeys(value);
        return element;
    };

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return  wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    };

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    };

    private String  assertElementHasText(By by, String assert_text, String error_message)
    {
        WebElement element = waitForElementPresent(by, error_message, 5);
        String field_text = element.getText();
        if (new String(field_text).equals(assert_text)){return "Ok";}
        else {return error_message;}
    };



};

