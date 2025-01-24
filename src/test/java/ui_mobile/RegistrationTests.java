package ui_mobile;

import config.AppiumConfig;
import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.BaseScreen;
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

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validatePopUpMessage("Registration success!"));

    }

    @Test
    public void registration_emptyFirstName() {

        UserDTO userDTO = UserDTO.builder()
                .firstName("")
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("Test9999!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void registration_emptyLastName() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName("")
                .username(generateEmail(5))
                .password("Test9999!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void registration_emptyEmail() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username("")
                .password("Test9999!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void registration_emptyPassword() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void registration_emptyCheckbox() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("Test9999!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm_WOCheckbox(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void registration_spaceInFirstName() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(" ")
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("Test9999!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    // SUGGESTION: The [First Name] field must not contain only special symbols.
    @Test
    public void registration_invalidFirstName() {

        UserDTO userDTO = UserDTO.builder()
                .firstName("!@#$%^&")
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("Test9999!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    // SUGGESTION: The [Last Name] field must not contain only digits.
    @Test
    public void registration_invalidLastName() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName("11212123")
                .username(generateEmail(5))
                .password("Test9999!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("All fields must be filled and agree terms"));

    }

    @Test
    public void registration_duplicateEmail() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username("testemail@example.com")
                .password("Test0000!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("User already exists"));

    }

    @Test
    public void registration_invalidEmail() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username("@example.com")
                .password("Test0000!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{username=must be a well-formed email address}"));

    }

    // TODO: Bug Report
    // It is possible to create a user without a top-level domain, such as '.com' or others.
    @Test
    public void registration_invalidEmail_WOTopLevelDomain() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username("testemail@example")
                .password("Test0000!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{username=must be a well-formed email address}"));

    }

    @Test
    public void registration_invalidEmail_WOSecondLevelDomain() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username("testemail@.com")
                .password("Test0000!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{username=must be a well-formed email address}"));

    }

    @Test
    public void registration_invalidEmail_doubleAtSymbol() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username("testemail@@example.com")
                .password("Test0000!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{username=must be a well-formed email address}"));

    }

    // SUGGESTION: Rewrite the error message: change '[Can contain special characters [@$#^&!]]'
    // to '[Must contain special characters [@$#^&!]]'.
    @Test
    public void registration_invalidPassword_WOSpecialCharacters() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("Test000000")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{password= At least 8 characters; Must contain " +
                "at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}"));

    }

    @Test
    public void registration_invalidPassword_WOUppercaseLetter() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("test0000!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{password= At least 8 characters; Must contain " +
                "at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}"));

    }

    @Test
    public void registration_invalidPassword_WOLowercaseLetter() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("TEST0000!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{password= At least 8 characters; Must contain " +
                "at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}"));

    }

    @Test
    public void registration_invalidPassword_WONumbers() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("TestTest!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{password= At least 8 characters; Must contain " +
                "at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}"));

    }

    @Test
    public void registration_invalidPassword_incorrectLength() {

        UserDTO userDTO = UserDTO.builder()
                .firstName(generateString(5))
                .lastName(generateString(5))
                .username(generateEmail(5))
                .password("Test56!")
                .build();

        RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        registrationScreen.typeRegistrationForm(userDTO);

        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{password= At least 8 characters; Must contain " +
                "at least 1 uppercase letter, 1 lowercase letter, and 1 number; Can contain special characters [@$#^&*!]}"));

    }

}
