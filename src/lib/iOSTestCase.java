package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class iOSTestCase extends TestCase {

   protected AppiumDriver driver;
   private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";

   @Override
   protected void setUp() throws Exception
    {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("deviceName","iPhone 11");
        capabilities.setCapability("platformVersion","15.2");
        //capabilities.setCapability("app","C:/vica/job/Новая папка/training_mobile_auto/apks/org.wikipedia.apk");
        capabilities.setCapability("app","/Users/andreigeiko/Documents/GitHub/training_mobile_auto/apks/Wikipedia.app");
        // capabilities.setCapability("orientation","PORTRAIT");

        driver  = new IOSDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backroudApp(Duration seconds)
    {
        driver.runAppInBackground(seconds);;
    }
}
