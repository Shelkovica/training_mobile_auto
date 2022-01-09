package Tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObjects;
import lib.ui.NavigationUi;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        NavigationUi NavigationUi = new NavigationUi(driver);
        NavigationUi.clickMyLists();
        MyListsPageObjects MyListsPageObjects = new MyListsPageObjects(driver);
        MyListsPageObjects.openFolderByName(name_of_folder);
        MyListsPageObjects.swipeByArticleToDelete(article_title);
    };

    @Test
    public void testSaveTwoArticle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Test folder";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Programming language");
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();
        NavigationUi NavigationUi = new NavigationUi(driver);
        NavigationUi.clickMyLists();
        MyListsPageObjects MyListsPageObjects = new MyListsPageObjects(driver);
        MyListsPageObjects.openFolderByName(name_of_folder);
        MyListsPageObjects.swipeByArticleToDelete(article_title);
        String title_article_in_list =  ArticlePageObject.getTitleArticleFromMyList();
        ArticlePageObject.openArticle();
        String title_article_after_open =  ArticlePageObject.getArticleTitle();
        assertEquals(
                "Article title have been change after open",
                title_article_in_list,
                title_article_after_open
        );
    }
}
