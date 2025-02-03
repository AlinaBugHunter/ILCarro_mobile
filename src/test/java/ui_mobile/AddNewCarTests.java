package ui_mobile;

import config.AppiumConfig;
import dto.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

import static utils.RandomUtils.*;

public class AddNewCarTests extends AppiumConfig {

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
    public void addNewCar() {

        CarDTO carDTO = CarDTO.builder()
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

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validatePopUpMessage("Car was added!"));

    }

    @Test
    public void addNewCarValidateCarList() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("Hi")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("best of the best")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertEquals(myCarsScreen.scrollToLastCarElement(), carDTO.getSerialNumber());

    }

    @Test
    public void addNewCar_emptySerialNumber() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("")
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

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver)
                .validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_emptyManufacture() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_emptyModel() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_emptyCity() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_emptyCarClass() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{carClass=must not be blank}"));

    }

    @Test
    public void addNewCar_emptyYear() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{year=must not be blank}"));

    }

    @Test
    public void addNewCar_spaceInSerialNumber() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber(" ")
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

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_spaceInManufacture() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture(" ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_spaceInModel() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model(" ")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_spaceInCity() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city(" ")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Fields: Serial number, Manufacture, Model, City, Price per day is required!"));

    }

    @Test
    public void addNewCar_spaceInCarClass() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass(" ")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{carClass=must not be blank}"));

    }

    @Test
    public void addNewCar_spaceInYear() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year(" ")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("{year=must not be blank}"));

    }

    @Test
    public void addNewCar_withExistingSerialNumber() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-3805")
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

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Car with serial number " + carDTO.getSerialNumber() + " already exists"));

    }

    // TODO: Create Bug Report
    // It is possible to add a car with a negative price.
    @Test
    public void addNewCar_negativePrice() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(-333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);

    }

    // TODO: Create a Bug Report
    // It is possible to add a car with the maximum possible double value as its price.
    @Test
    public void addNewCar_tooLargePrice() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(Double.MAX_VALUE)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);

    }

    @Test
    public void addNewCar_invalidSeats() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(-4)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);
        Assert.assertTrue(new BaseScreen(driver).validateAlertMessage("Seats count should be positive number!"));

    }

    // TODO: Create a Bug Report
    // It is possible to add a car with the maximum possible integer value for seats.
    @Test
    public void addNewCar_tooLargeSeatsCount() {

        CarDTO carDTO = CarDTO.builder()
                .serialNumber("SN-" + generatePhone(6))
                .manufacture("ZAZ")
                .model("969")
                .city("Haifa")
                .pricePerDay(333.33)
                .carClass("H")
                .fuel("Gas")
                .year("1975")
                .seats(Integer.MAX_VALUE)
                .about("Description")
                .build();

        myCarsScreen = new MyCarsScreen(driver);
        myCarsScreen.navigateToAddNewCarScreen();
        new AddNewCarScreen(driver).addNewCar(carDTO);

    }

}
