package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.BaseScreen;
import screens.LoginScreen;
import screens.SearchScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {

    LoginScreen loginScreen;

    @BeforeMethod
    public void preconditions() {
        new SplashScreen(driver);
        new SearchScreen(driver).navigateToLoginScreen();
    }

    @Test
    public void login() {

        UserDTO userDTO = UserDTO.builder()
                .username("testemail@example.com")
                .password("Password123!")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validatePopUpMessage("Login success!"));

    }

}
