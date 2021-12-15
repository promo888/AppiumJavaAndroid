import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestUtils {

    public boolean isElementExist(MobileElement element) throws Exception {
        WebDriverWait wait = new WebDriverWait(element.getWrappedDriver(), 10); //todo param+props
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    public void click(MobileElement element) throws Exception {
        if (isElementExist(element))
            element.click();
        else {
            throw new Exception("Error: Element Not Found: " + element.getText());
        }
        //System.out.println("Error: Element Not Found: " + element.getText());
    }

    public void killApp(AndroidDriver driver, String appPackage) throws Exception {
        try {
            driver.terminateApp(appPackage);
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
