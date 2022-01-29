package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObjects;

public class iOSMyListsPageObjects extends MyListsPageObjects {
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        INFO_WINDOW_CLOSE = "xpath://XCUIElementTypeButton[@name='Close']";
    }

    public iOSMyListsPageObjects(AppiumDriver driver)
    {
        super(driver);
    }

    public void openArticleInList(String locator)
    {
        this.waitForElementAndClick(locator, "Cannot find Article in list", 15);
    }

}
