package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject
{

    protected  static String
        TITLE,
            TITLE_SECOND,
        FOOTER_ELEMENT,
        OPTIONS_BUTTON,
        OPTIONS_ADD_TO_MY_LIST_BUTTON,
        ADD_TO_MY_LIST_OVERLAY,
        MY_LIST_NAME_INPUT,
        MY_LIST_OK_BUTTON,
        CLOSE_ARTICLE_BUTTON,
        FOLDER_BY_NAME_TPL,
        SECOND_ARTICLE_TITLE,
    SECOND_ARTICLE_ID;


    private static String getFolderXpathByName(String name_of_folder)
    {
        return  FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }

    public WebElement waitForTitleSecondElement()
    {
        return this.waitForElementPresent(TITLE_SECOND, "Cannot find article title on page!", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }


    public String getArticleSecondTitle()
    {
        WebElement title_element = waitForTitleSecondElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }
    public void swipeToFooter()
    {
        if(Platform.getInstance().isAndroid()){
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                40
        );} else {
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 40);
        }
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementPresent(
                TITLE,
                "Cannot find article title",
                15

        );

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got It' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of article folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press ok button",
                5
        );

    }

    public void addSecondArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find options to add article to reading list",
                5
        );
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find options to add article to old reading list",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );
    }


    public String getTitleArticleFromMyList()
    {
      if (Platform.getInstance().isAndroid()){
        return this.waitForElementAndGetAttribute(
                SECOND_ARTICLE_TITLE,
                "text",
                "Cannot find title of article in list",
                15
        );} else {
          return SECOND_ARTICLE_TITLE;}


    }

    public void openArticle()
    {if (Platform.getInstance().isAndroid()) {
        this.waitForElementAndClick(
                SECOND_ARTICLE_TITLE,
                "Cannot close article, cannot find X link",
                5
        );} else {
        this.openArticleInList();
    }
    }

    public void openArticleInList()
    {

        this.waitForElementAndClick(
                SECOND_ARTICLE_ID,
                "Cannot close article, cannot find X link",
                5
        );

    }


    public void assertTitlePresent()
    {
        this.assertElementPresent(
                TITLE,
                "article title is not present"
        );
    }

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }
}
