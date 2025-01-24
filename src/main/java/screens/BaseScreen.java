package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {

    AppiumDriver<AndroidElement> driver;

    public BaseScreen(AppiumDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void pause(int time) {
        try {
            Thread.sleep(1000L * time);
        } catch (InterruptedException e) {
            System.out.println("Created Exception -> pause()");
            throw new RuntimeException(e);
        }
    }

    public void clickWait(AndroidElement element, int time) {
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public boolean validateTextPresentInElement(AndroidElement element, String text, int time) {
        try {
            return new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            System.out.println("Created Exception -> validateTextPresentInElement()");
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Pop Up Message

    @FindBy(xpath = "/hierarchy/android.widget.Toast")
    AndroidElement pupUpMessage;

    public boolean validatePopUpMessage(String text) {
        return validateTextPresentInElement(pupUpMessage, text, 5);
    }

    // Alert Message

    @FindBy(id = "android:id/message")
    AndroidElement alertMessage;

    public boolean validateAlertMessage(String text) {
        return validateTextPresentInElement(alertMessage, text, 5);
    }

}
