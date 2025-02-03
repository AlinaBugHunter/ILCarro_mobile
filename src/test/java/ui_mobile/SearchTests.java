package ui_mobile;

import config.AppiumConfig;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.SearchScreen;
import screens.SplashScreen;

public class SearchTests extends AppiumConfig {

    SearchScreen searchScreen;

    @BeforeMethod
    public void preconditions() {
        new SplashScreen(driver).navigateToSearchScreen();
        searchScreen = new SearchScreen(driver);
    }

    @Test
    public void searchCarWOCalendar() {
        searchScreen.typeSearchCarForm("Rehovot", "17 March 2025", "25 June 2025");
    }

}
