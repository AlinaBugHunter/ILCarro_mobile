package config;

import dto.CarDTO;
import dto.TokenDTO;
import dto.UserDTO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.BaseAPI;

import static io.restassured.RestAssured.given;

public class CarController implements BaseAPI {

    public TokenDTO tokenDTO;
    RequestSpecification requestSpecBuilder;

    public void login() {

        UserDTO user = UserDTO.builder()
                .username("testemail@example.com")
                .password("Password123!")
                .build();

        AuthController authController = new AuthController();

        Response response = authController.requestRegLogin(user, LOGIN);
        if (response.getStatusCode() == 200) {
            tokenDTO = response.getBody().as(TokenDTO.class);
            requestSpecBuilder = new RequestSpecBuilder()
                    .addHeader("Authorization", tokenDTO.getAccessToken())
                    .build();
        } else {
            System.out.println("Status Code -> " + response.getStatusCode());
        }

    }

    public Response getUserCars(String token) {
        return given()
                .spec(requestSpecBuilder) // == .header("Authorization", token)
                .when()
                .get(BASE_URL + GET_USER_CARS)
                .thenReturn();
    }

    public Response addUserCar(CarDTO carDTO, String token) {
        return given()
                .body(carDTO)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .post(BASE_URL + ADD_NEW_CAR)
                .thenReturn();
    }

    public Response deleteCar(String serialNumber) {
        return given()
                .spec(requestSpecBuilder)
                .when()
                .delete(BASE_URL + DELETE_CAR + serialNumber)
                .thenReturn();
    }

}
