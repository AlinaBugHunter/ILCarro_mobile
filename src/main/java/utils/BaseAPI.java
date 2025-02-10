package utils;

import com.google.gson.Gson;
import okhttp3.MediaType;

public interface BaseAPI {

    String BASE_URL = "https://ilcarro-backend.herokuapp.com";
    String REGISTRATION = "/v1/user/registration/usernamepassword";
    String LOGIN = "/v1/user/login/usernamepassword";
    String ADD_NEW_CAR = "/v1/cars";
    String GET_USER_CARS = "/v1/cars/my";
    String DELETE_CAR = "/v1/cars/";

    Gson GSON = new Gson();
    MediaType JSON = MediaType.get("application/json");

    String AUTH = "Authorization";

}
