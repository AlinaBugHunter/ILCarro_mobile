package ui_mobile;

import config.AppiumConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

public class RegistrationTests extends AppiumConfig {

    SplashScreen splashScreen;
    SearchScreen searchScreen;

    @BeforeMethod
    public void setUp() {
        System.out.println("hello");

        splashScreen = new SplashScreen(driver);
        System.out.println("1");

        searchScreen = new SearchScreen(driver);
        System.out.println("2");

        searchScreen.navigateToRegistrationScreen();
        System.out.println("3");
    }

    @Test
    public void registration() {

    }

}
