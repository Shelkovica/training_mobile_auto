package Tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchTests extends CoreTestCase
{

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisAppear();
    };

    @Test
    public void testElementText()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String errorMessage = "Text in element with error";
        String resultAssert = SearchPageObject.assertTextInSearchInput(errorMessage);
        assertEquals(errorMessage, "Ok", resultAssert);
    }

    @Test
    public void testResultAfterSearchCancel()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        assertTrue("no find article",  SearchPageObject.getArticleCountOnPage()>0);
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.waitForEmptyResultMessage();
    };

    @Test
    public void testSearchResult()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String string_search = "Java";
        SearchPageObject.typeSearchLine(string_search);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        List<WebElement> count_article = SearchPageObject.getArticlesTitle();
        for(WebElement c_article:count_article) {
            String title_article = c_article.getText();
            assertTrue(
                    "some article in search result not contain "+string_search,
                    title_article.toLowerCase().contains(string_search.toLowerCase()));
        }
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park Diskography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();
        assertTrue(
                "We found too few results!",
                amount_of_search_results>0
        );
    };

    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "dfdfsfsste";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }
}
