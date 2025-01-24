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

    @Test
    public void login_emptyEmail() {

        UserDTO userDTO = UserDTO.builder()
                .username("")
                .password("Password123!")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void login_spaceInEmail() {

        UserDTO userDTO = UserDTO.builder()
                .username(" ")
                .password("Password123!")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void login_invalidEmail_WOLocalPart() {

        UserDTO userDTO = UserDTO.builder()
                .username("@example.com")
                .password("Password123!")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Login or Password incorrect"));

    }

    @Test
    public void login_invalidEmail_WODomainPart() {

        UserDTO userDTO = UserDTO.builder()
                .username("testemail@example")
                .password("Password123!")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Login or Password incorrect"));

    }

    @Test
    public void login_emptyPassword() {

        UserDTO userDTO = UserDTO.builder()
                .username("testemail@example.com")
                .password("")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void login_spaceInPassword() {

        UserDTO userDTO = UserDTO.builder()
                .username("testemail@example.com")
                .password(" ")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void login_invalidPassword() {

        UserDTO userDTO = UserDTO.builder()
                .username("testemail@example.com")
                .password("Password123")
                .build();

        loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Login or Password incorrect"));

    }

}
