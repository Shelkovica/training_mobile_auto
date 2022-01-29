package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia']";
       // SEARCH_CANCEL_BUTTON = "id:close";
        SEARCH_CANCEL_BUTTON = "id:cancel";
        //XCUIElementTypeStaticText[@name="Java (programming language)"]
        SEARCH_RESULT_BY_SYBSTRING_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";

       // SEARCH_RESULT_BY_SYBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";

        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeStaticText']";
        SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='No results found']";


        SEARCH_INPUT_TEXT_ELEMENT = "id:org.wikipedia:id/search_src_text";
        SEARCH_INPUT_TEXT = "Search…";
        SEARCH_RESULT_TITLE_ARTICLE = "id:org.wikipedia:id/page_list_item_title";
        SEARCH_EMPTY_ELEMENT = "id:org.wikipedia:id/search_empty_message";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
