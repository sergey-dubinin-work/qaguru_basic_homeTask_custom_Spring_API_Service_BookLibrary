package guru.qa.booklibrary.api;

import guru.qa.booklibrary.dto.users.UserAuthRequest;
import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String USER_REGISTER  = "/user/register";
    private static final String USER_GET_TOKEN = "/user/getToken";

    public static Response registerUser(UserRegistrationRequest userRegistrationRequest){

        return given()
                .contentType(ContentType.JSON)
                .body(userRegistrationRequest)
                .when()
                .post(USER_REGISTER)
                .then()
                .extract().response();

    }

    public static Response getToken(UserAuthRequest userAuthRequest){

        return given()
                .contentType(ContentType.JSON)
                .body(userAuthRequest)
                .when()
                .post(USER_GET_TOKEN)
                .then()
                .extract().response();
    }

}
