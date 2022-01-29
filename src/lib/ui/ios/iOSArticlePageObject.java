package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject
{
    static {
        TITLE = "id:Java (programming language)";
        TITLE_SECOND = "id:JavaScript";
        FOOTER_ELEMENT = "id:View article on browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='W']";

        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        SECOND_ARTICLE_TITLE = "JavaScript";
        SECOND_ARTICLE_ID = "id:JavaScript";
    };

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
