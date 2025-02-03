package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyCarsScreen extends BaseScreen {

    public MyCarsScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/addCarBtn")
    AndroidElement btnAddCar;

    public void navigateToAddNewCarScreen() {
        clickWait(btnAddCar, 5);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/myCarsRv']//*[@resource-id='com.telran.ilcarro:id/myCarSerialTxt']")
    List<AndroidElement> carsList;

    public String scrollToLastCarElement() {

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println(height + "X" + width);
        TouchAction<?> touchAction = new TouchAction<>(driver);

        String second = "";
        boolean flag = true;
        while (flag) {
            String first = carsList.get(carsList.size() - 1).getText();
            System.out.println("First -> " + first);
            touchAction.longPress(PointOption.point(5, height / 6 * 5))
                    .moveTo(PointOption.point(5, height / 6))
                    .release().perform();
            second = carsList.get(carsList.size() - 1).getText();
            System.out.println("Second -> " + second);
            flag = !first.equals(second);
        }
        return second;

    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/LinearLayout']")
    AndroidElement firstCarElement;

    @FindBy(id = "android:id/button1")
    AndroidElement btnYes;

    public void deleteFirstCarElement() {

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println(height + "X" + width);

        int y = firstCarElement.getLocation().getY();
        int elementHeight = firstCarElement.getSize().getHeight();

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(width / 10 * 9, y + elementHeight / 2))
                .moveTo(PointOption.point(width / 10, y + elementHeight / 2)).release().perform();

        clickWait(btnYes, 5);

    }

}
