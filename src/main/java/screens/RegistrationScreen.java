package screens;

import dto.UserDTO;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends BaseScreen {

    public RegistrationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/editRegName")
    AndroidElement inputName;

    @FindBy(id = "com.telran.ilcarro:id/editRegLastName")
    AndroidElement inputLastName;

    @FindBy(id = "com.telran.ilcarro:id/editRegEmail")
    AndroidElement inputEmail;

    @FindBy(id = "com.telran.ilcarro:id/editRegPassword")
    AndroidElement inputPassword;

    @FindBy(id = "com.telran.ilcarro:id/checkBoxAgree")
    AndroidElement checkbox;

    @FindBy(id = "com.telran.ilcarro:id/regBtn")
    AndroidElement btnRegistration;

    private void fillRegistrationForm(UserDTO userDTO) {
        inputName.sendKeys(userDTO.getFirstName());
        inputLastName.sendKeys(userDTO.getLastName());
        inputEmail.sendKeys(userDTO.getUsername());
        inputPassword.sendKeys(userDTO.getPassword());
    }

    public void typeRegistrationForm(UserDTO userDTO) {
        fillRegistrationForm(userDTO);
        clickWait(checkbox, 5);
        clickWait(btnRegistration, 5);
    }

    public void typeRegistrationForm_WOCheckbox(UserDTO userDTO) {
        fillRegistrationForm(userDTO);
        clickWait(btnRegistration, 5);
    }

}
