package guru.qa.booklibrary.api;

import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String USER_REGISTER = "/user/register";

    public static Response registerUser(UserRegistrationRequest userRegistrationRequest){

        return given()
                .contentType(ContentType.JSON)
                .body(userRegistrationRequest)
                .when()
                .post(USER_REGISTER)
                .then()
                .extract().response();

    }

}
