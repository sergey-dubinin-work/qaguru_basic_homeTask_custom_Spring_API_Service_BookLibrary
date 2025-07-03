package guru.qa.booklibrary.tests;

import guru.qa.booklibrary.BookLibraryApiTest;
import guru.qa.booklibrary.api.UserApi;
import guru.qa.booklibrary.dataGenerators.DataGeneratorUser;
import guru.qa.booklibrary.dto.users.UserAuthRequest;
import guru.qa.booklibrary.dto.users.UserAuthResponse;
import guru.qa.booklibrary.dto.users.UserInfoResponse;
import guru.qa.booklibrary.dto.users.UserRegistrationRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UserTest extends BookLibraryApiTest {

    @Test
    void testUserRegistration() {

        UserRegistrationRequest userRegistrationRequest = UserRegistrationRequest.builder()
                .userName(faker.name().fullName())
                .password(faker.internet().password())
                .age(faker.random().nextInt())
                .build();

        Response response = UserApi.registerUser(userRegistrationRequest);
        UserInfoResponse userInfoResponse = response.as(UserInfoResponse.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(userInfoResponse).isNotNull(),
                () -> assertThat(userInfoResponse.getId()).isNotNull(),
                () -> assertThat(userInfoResponse.getUserName()).isEqualTo(userRegistrationRequest.getUserName()),
                () -> assertThat(userInfoResponse.getAge()).isEqualTo(userRegistrationRequest.getAge())
        );

    }

    @Test
    void testUserAuthorization() {
        UserRegistrationRequest userRegistrationRequest = DataGeneratorUser.getUserRegistrationRequestWithOnlyRequiredParameters();

        UserApi.registerUser(userRegistrationRequest);

        Response response = UserApi.getToken(
                new UserAuthRequest(
                        userRegistrationRequest.getUserName(),
                        userRegistrationRequest.getPassword()
                )
        );

        UserAuthResponse userAuthResponse = response.as(UserAuthResponse.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(userAuthResponse).isNotNull(),
                () -> assertThat(userAuthResponse.getToken()).isNotNull()
        );

    }

    @Test
    void testGetUserInfo() {
        UserRegistrationRequest userRegistrationRequest = DataGeneratorUser.getUserRegistrationRequestWithOnlyRequiredParameters();

        UserInfoResponse userCreationInfoResponse = UserApi.registerUser(userRegistrationRequest).as(UserInfoResponse.class);

        UserAuthResponse userAuthResponse = UserApi.getToken(
                new UserAuthRequest(
                        userRegistrationRequest.getUserName(),
                        userRegistrationRequest.getPassword()
                )
        ).as(UserAuthResponse.class);

        Response response = UserApi.getUserInfo(userAuthResponse.getToken());

        UserInfoResponse userInfoResponse = response.as(UserInfoResponse.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(userInfoResponse).usingRecursiveComparison().isEqualTo(userCreationInfoResponse)
        );

    }
}
