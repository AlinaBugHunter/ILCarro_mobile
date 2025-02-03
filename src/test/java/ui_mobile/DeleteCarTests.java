package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

public class DeleteCarTests extends AppiumConfig {

    SearchScreen searchScreen;
    LoginScreen loginScreen;
    MyCarsScreen myCarsScreen;

    @BeforeMethod
    public void login() {

        UserDTO userDTO = UserDTO.builder()
                .username("testemail@example.com")
                .password("Password123!")
                .build();

        new SplashScreen(driver);
        searchScreen = new SearchScreen(driver);
        searchScreen.navigateToLoginScreen();
        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);
        searchScreen.navigateToMyCarsScreen();

    }

    @Test
    public void deleteFirstCar() {
        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.deleteFirstCarElement();
    }

}
