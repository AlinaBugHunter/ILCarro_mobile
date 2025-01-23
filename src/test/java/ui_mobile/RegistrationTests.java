package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.RegistrationScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import static utils.RandomUtils.*;

public class RegistrationTests extends AppiumConfig {

    @BeforeMethod
    public void beforeTest() {
        new SplashScreen(driver);
        new SearchScreen(driver).navigateToRegistrationScreen();
    }

    @Test
    public void registration() {
        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("Test9999!")
                .build();
        new RegistrationScreen(driver).typeRegistrationForm(userDTO);

    }
}
