import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class YouTubeTest {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait                wait;
    public TestUtils                    testUtils;
    //Elements By
      By youtubeAppIconBy = By.id("YouTube");
      By searchBy         = By.id("com.google.android.youtube:id/menu_item_0"); // xpath //android.widget.ImageView[@content-desc="Search"]
      String SEARCH_EDIT_TEXT = "com.google.android.youtube:id/search_edit_text";
      String SEARCH_FROM_KEYBOARD = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView";
      String APP_PACKAGE = "com.google.android.youtube";


    @BeforeMethod
    public void setup() throws Exception { //} MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 30");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
        caps.setCapability("appPackage", APP_PACKAGE);
        caps.setCapability("appActivity", ".app.honeycomb.Shell$HomeActivity"); //todo waitAppActivity duration test
//        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
        testUtils = new TestUtils();
        //PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //testUtils.killApp(driver, APP_PACKAGE);
        //driver.launchApp();
        driver.resetApp();
    }

    @Test
    public void basicTest() throws Exception {
        //driver.pressKey(new KeyEvent(AndroidKey.HOME));
        //driver.terminateApp(APP_PACKAGE);
/*        testUtils.killApp(driver, APP_PACKAGE);
        driver.launchApp();*/
        //wait.until(ExpectedConditions.visibilityOfElementLocated(youtubeAppIconBy)).click();
        //driver.findElement(By.id("android:id/aerr_wait")).click();

        //driver.resetApp();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(youtubeAppIconBy));
        MobileElement el = (MobileElement) driver.findElementByAccessibilityId("YouTube");
        wait.until(ExpectedConditions.visibilityOf(el));
        //el1.isDisplayed()
        //el1.click();
        testUtils.click(el);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(searchBy)).click();
        MobileElement el2 = ((MobileElement) driver.findElement(searchBy)); //findElementByAccessibilityId("Search")); //.click();
        //wait.until(ExpectedConditions.visibilityOf(el2));
        testUtils.click(el2);
        ((MobileElement) driver.findElementById(SEARCH_EDIT_TEXT)).sendKeys("my search");
        ((MobileElement) driver.findElementByXPath(SEARCH_FROM_KEYBOARD)).click();



    }




    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}


