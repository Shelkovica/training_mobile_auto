package lib.ui;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPageObject extends MainPageObject{

    private static final String
        SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
        SEARCH_INPUT = "//*[contains(@text, 'Search')]",
        SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
        SEARCH_RESULT_BY_SYBSTRING_TPL ="//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
        SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']",
        SEARCH_EMPTY_RESULTS_ELEMENT = "//*[@text='No results found']",
        SEARCH_INPUT_TEXT_ELEMENT = "org.wikipedia:id/search_src_text",
        SEARCH_INPUT_TEXT = "Search…",
        SEARCH_RESULT_TITLE_ARTICLE = "org.wikipedia:id/page_list_item_title",

        SEARCH_EMPTY_ELEMENT = "org.wikipedia:id/search_empty_message",
        SEARCH_EMPTY_ELEMENT_MESSAGE  = "Search and read the free encyclopedia in your language";


    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SYBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void initSearchInput()
    {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);

    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button!", 5);
    }

    public void waitForCancelButtonToDisAppear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present!", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line,"Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring "+substring);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring "+substring,10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                By.xpath(SEARCH_RESULT_ELEMENT),
                "Cannot find anything by the request",
                15
        );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULTS_ELEMENT), "Cannot find empty result element", 15);
    }

    public void assertThereIsNoResultOfSearch()
    {
       this.assertElementNotPresent(By.xpath(SEARCH_RESULT_ELEMENT), "We supposed not to find any results");
    }

    public String assertTextInSearchInput(String errorMessage)
    {
        return this.assertElementHasText(
                By.id(SEARCH_INPUT_TEXT_ELEMENT),
                SEARCH_INPUT_TEXT,
                errorMessage
        );
    }

    public int getArticleCountOnPage()
    {
        List count_article = driver.findElementsById(SEARCH_RESULT_TITLE_ARTICLE);
        return  count_article.size();
    }

    public void waitForEmptyResultMessage()
    {
       this.waitForElementPresent(By.id(SEARCH_EMPTY_ELEMENT), "Search is not empty",5);
    }

    public List getArticlesTitle()
    {
        List <WebElement> count_article = driver.findElementsByXPath(SEARCH_RESULT_TITLE_ARTICLE);
        return count_article;
    }

}
