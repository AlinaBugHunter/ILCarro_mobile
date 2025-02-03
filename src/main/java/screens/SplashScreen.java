package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SplashScreen extends BaseScreen {

    public SplashScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/versionText")
    AndroidElement versionApp;

    public boolean validateVersion(String version) {
        return validateTextPresentInElement(versionApp, version, 5);
    }

    public void navigateToSearchScreen() {
        try {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated
                            (By.id("com.telran.ilcarro:id/findTitle")));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
            System.out.println("Created Exception -> navigateToSearchScreen()");
        }
    }

}
