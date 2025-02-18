package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {

    public static AppiumDriver<AndroidElement> driver;

    @BeforeMethod
    public void setup() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "Nexus 5.1");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("appPackage", "com.telran.ilcarro");
        desiredCapabilities.setCapability("appActivity", ".SplashActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

        String urlNexus_5_1 = "http://localhost:4723/wd/hub";

        try {
            driver = new AppiumDriver<>(new URL(urlNexus_5_1), desiredCapabilities);
        } catch (MalformedURLException e) {
            System.out.println("Created Exception -> setUp()");
            throw new RuntimeException(e);
        }

    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
