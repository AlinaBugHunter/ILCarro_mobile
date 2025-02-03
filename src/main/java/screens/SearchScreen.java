package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;

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

    @FindBy(id = "com.telran.ilcarro:id/editLocation")
    AndroidElement inputLocation;

    @FindBy(id = "com.telran.ilcarro:id/editFrom")
    AndroidElement inputStartDate;

    @FindBy(id = "com.telran.ilcarro:id/editTo")
    AndroidElement inputEndDate;

    @FindBy(id = "android:id/prev")
    AndroidElement btnMonthPrev;

    @FindBy(id = "android:id/next")
    AndroidElement btnMonthNext;

    @FindBy(id = "android:id/date_picker_header_year")
    AndroidElement btnYear;

    @FindBy(id = "com.telran.ilcarro:id/searchBtn")
    AndroidElement btnYalla;

    @FindBy(id = "android:id/button1")
    AndroidElement btnOK;

    public void typeSearchCarForm(String city, String startDate, String endDate) {
        inputLocation.sendKeys(city);
        inputStartDate.click();
        setDateCalendar(startDate);
        inputEndDate.click();
        setDateCalendar(endDate);
        clickWait(btnYalla, 5);
    }

    private void setDateCalendar(String date) {

        String[] arrDate = date.split(" "); // 03 February 2025 -> [03][February][2025]

        // Month
        int month = returnNumberOfMonth(arrDate[1]); // [February] -> [2]
        int currentMont = LocalDate.now().getMonthValue() + 1; // +1 - Due to a logic error in the backend

        int quantityClick = month - currentMont;
        if (quantityClick > 0) {
            for (int i = 0; i < quantityClick; i++) {
                clickWait(btnMonthNext, 5);
            }
        } else if (quantityClick < 0) {
            for (int i = 0; i < Math.abs(quantityClick); i++) {
                clickWait(btnMonthPrev, 5);
            }
        }

        // Year
        if (LocalDate.now().getYear() != Integer.parseInt(arrDate[2])) {
            clickWait(btnYear, 5);
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//*[@text='" + arrDate[2] + "']")
                    )).click();
        }

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable
                        (By.xpath("//*[@content-desc='" + date + "']"))).click();
        clickWait(btnOK, 5);

        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.invisibilityOfElementLocated
                            (By.id("android:id/button1")));
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
            System.out.println("Created Exception -> setDateCalendar()");
        }

    }

    private int returnNumberOfMonth(String monthName) {
        Month month = Month.valueOf(monthName.toUpperCase(Locale.ENGLISH));
        return month.getValue();
    }

}
