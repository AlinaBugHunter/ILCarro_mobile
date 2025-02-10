package config;

import dto.UserDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseAPI;

import static io.restassured.RestAssured.given;

public class AuthController implements BaseAPI {

    public Response requestRegLogin(UserDTO user, String url) {
        return given()
                .body(user)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL + url)
                .thenReturn();
    }

}
