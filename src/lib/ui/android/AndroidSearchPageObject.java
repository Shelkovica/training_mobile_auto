package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
                SEARCH_INPUT = "xpath://*[contains(@text, 'Search')]";
                SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
                SEARCH_RESULT_BY_SYBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";
                SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
                SEARCH_EMPTY_RESULTS_ELEMENT = "xpath://*[@text='No results found']";
                SEARCH_INPUT_TEXT_ELEMENT = "id:org.wikipedia:id/search_src_text";
                SEARCH_INPUT_TEXT = "Search…";
                SEARCH_RESULT_TITLE_ARTICLE = "id:org.wikipedia:id/page_list_item_title";
                SEARCH_EMPTY_ELEMENT = "id:org.wikipedia:id/search_empty_message";
    }
    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
