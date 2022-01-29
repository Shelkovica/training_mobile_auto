package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.MyListsPageObjects;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.android.AndroidMyListsPageObjects;
import lib.ui.ios.iOSArticlePageObject;
import lib.ui.ios.iOSMyListsPageObjects;

public class MyListsPageObjectFactory
{
    public static MyListsPageObjects get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidMyListsPageObjects(driver);
        } else {
            return new iOSMyListsPageObjects(driver);
        }
    }
}
