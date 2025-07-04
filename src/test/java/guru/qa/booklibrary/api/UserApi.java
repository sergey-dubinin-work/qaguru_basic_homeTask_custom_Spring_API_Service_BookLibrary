package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.users.UserAuthRequest;
import guru.qa.booklibrary.model.dto.users.UserRegistrationRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String USER_REGISTER  = "/user/register";
    private static final String USER_GET_TOKEN = "/user/getToken";
    private static final String USER_USER_INFO = "/user/userInfo";

    public static Response registerUser(UserRegistrationRequest userRegistrationRequestBody){

        return given()
                .contentType(ContentType.JSON)
                .body(userRegistrationRequestBody)
                .when()
                .post(USER_REGISTER)
                .then()
                .extract().response();

    }

    public static Response getToken(UserAuthRequest userAuthRequestBody){

        return given()
                .contentType(ContentType.JSON)
                .body(userAuthRequestBody)
                .when()
                .post(USER_GET_TOKEN)
                .then()
                .extract().response();
    }

    public static Response getUserInfo(String token){
        return given()
                .auth().oauth2(token)
                .when()
                .get(USER_USER_INFO)
                .then()
                .extract().response();
    }

}
