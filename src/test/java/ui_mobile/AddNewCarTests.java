package ui_mobile;

import config.AppiumConfig;
import dto.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import static utils.RandomUtils.*;

public class AddNewCarTests extends AppiumConfig {

    SearchScreen searchScreen;
    LoginScreen loginScreen;

    @BeforeMethod
    public void login() {
        new SplashScreen(driver);
        searchScreen = new SearchScreen(driver);
        searchScreen.navigateToLoginScreen();
        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(UserDTO.builder()
                .username("0bagginsbob@mail.com")
                .password("Qwerty123!")
                .build());
        searchScreen.navigateToMyCarsScreen();
    }

    @Test
    public void addNewCar() {
        CarDTO car = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();
        new MyCarsScreen(driver).navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(car);
    }

}
