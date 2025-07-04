package guru.qa.booklibrary;

import guru.qa.booklibrary.api.UserApi;
import guru.qa.booklibrary.dataGenerators.DataGeneratorUser;
import guru.qa.booklibrary.model.dto.users.UserAuthRequest;
import guru.qa.booklibrary.model.dto.users.UserAuthResponse;
import guru.qa.booklibrary.model.dto.users.UserInfoResponse;
import guru.qa.booklibrary.model.dto.users.UserRegistrationRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BookLibraryApiTest extends ApiTest{

    protected static String VALID_TOKEN;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8081/";

        UserRegistrationRequest userRegistrationRequest = DataGeneratorUser.getUserRegistrationRequestWithOnlyRequiredParameters();

        UserApi.registerUser(userRegistrationRequest).as(UserInfoResponse.class);

        UserAuthResponse userAuthResponse = UserApi.getToken(
                new UserAuthRequest(
                        userRegistrationRequest.getUserName(),
                        userRegistrationRequest.getPassword()
                )
        ).as(UserAuthResponse.class);

        VALID_TOKEN = userAuthResponse.getToken() ;

    }
}
