package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen {

    public SearchScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    AndroidElement btnMoreOptions;

    @FindBy(xpath = "//*[@text='Registration']")
    AndroidElement btnRegistration;

    @FindBy(xpath = "//*[@text='Login']")
    AndroidElement btnLogin;

    public void navigateToRegistrationScreen() {
        clickWait(btnMoreOptions, 5);
        clickWait(btnRegistration, 5);
    }

    public void navigateToLoginScreen() {
        clickWait(btnMoreOptions, 5);
        clickWait(btnLogin, 5);
    }

    @FindBy(xpath = "//*[@text='My Cars']")
    AndroidElement btnMyCars;

    public void navigateToMyCarsScreen() {
        clickWait(btnMoreOptions, 5);
        clickWait(btnMyCars, 5);
    }

}
