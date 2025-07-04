package guru.qa.booklibrary.tests;

import guru.qa.booklibrary.BookLibraryApiTest;
import guru.qa.booklibrary.api.BookShelfApi;
import guru.qa.booklibrary.api.UserApi;
import guru.qa.booklibrary.dataGenerators.DataGeneratorBook;
import guru.qa.booklibrary.dataGenerators.DataGeneratorUser;
import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.model.dto.bookShelf.BookShelfResponse;
import guru.qa.booklibrary.model.dto.bookShelf.RentABookRequest;
import guru.qa.booklibrary.model.dto.books.BookResponse;
import guru.qa.booklibrary.model.dto.users.UserAuthRequest;
import guru.qa.booklibrary.model.dto.users.UserAuthResponse;
import guru.qa.booklibrary.model.dto.users.UserInfoResponse;
import guru.qa.booklibrary.model.dto.users.UserRegistrationRequest;
import guru.qa.booklibrary.models.ErrorModel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BookShelfTest extends BookLibraryApiTest {

    @Test
    void testAddingBookToBookShelfWithUnauthorizedUser() {
        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters(VALID_TOKEN);

        Response response = BookShelfApi.addBookToBookShelf(
                AddBookToBookShelfRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        );

        ErrorModel errorResponse = response.as(ErrorModel.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_UNAUTHORIZED),
                () -> assertThat(errorResponse).isNotNull(),
                () -> assertThat(errorResponse.getStatus()).isEqualTo(401),
                () -> assertThat(errorResponse.getError()).isEqualTo("Unauthorized")
        );
    }

    @Test
    void testAddingBookToBookShelfWithInvalidTokenUser() {
        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters(VALID_TOKEN);

        Response response = BookShelfApi.addBookToBookShelf(
                "random_token",
                AddBookToBookShelfRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        );

        ErrorModel errorResponse = response.as(ErrorModel.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_UNAUTHORIZED),
                () -> assertThat(errorResponse).isNotNull(),
                () -> assertThat(errorResponse.getStatus()).isEqualTo(401),
                () -> assertThat(errorResponse.getError()).isEqualTo("Unauthorized")
        );
    }

    @Test
    void testAddingBookToBookShelfWithAuthorizedUser() {
        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters(VALID_TOKEN);

        Response response = BookShelfApi.addBookToBookShelf(
                VALID_TOKEN,
                AddBookToBookShelfRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        );

        BookShelfResponse bookShelfResponse = response.as(BookShelfResponse.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(bookShelfResponse).isNotNull(),
                () -> assertThat(bookShelfResponse.getId()).isNotNull(),
                () -> assertThat(bookShelfResponse.getBookId()).isEqualTo(bookResponse.getId()),
                () -> assertThat(bookShelfResponse.getRentedByUserId()).isNull()
        );
    }

    @Test
    void testGettingBookFromBookShelfWithUnauthorizedUser() {
        RentABookRequest rentABookRequestBody = RentABookRequest.builder()
                .bookId(UUID.randomUUID())
                .build();

        Response response = BookShelfApi.rentABook(rentABookRequestBody);

        ErrorModel errorResponse = response.as(ErrorModel.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_UNAUTHORIZED),
                () -> assertThat(errorResponse).isNotNull(),
                () -> assertThat(errorResponse.getStatus()).isEqualTo(401),
                () -> assertThat(errorResponse.getError()).isEqualTo("Unauthorized")
        );
    }

    @Test
    void testGettingNotExistingBookFromBookShelf() {
        RentABookRequest rentABookRequestBody = RentABookRequest.builder()
                .bookId(UUID.randomUUID())
                .build();

        Response response = BookShelfApi.rentABook(VALID_TOKEN, rentABookRequestBody);

        ErrorModel errorResponse = response.as(ErrorModel.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND),
                () -> assertThat(errorResponse).isNotNull(),
                () -> assertThat(errorResponse.getStatus()).isEqualTo(404),
                () -> assertThat(errorResponse.getError()).isEqualTo("Not Found")
        );
    }

    @Test
    void testRentingBookFromBookShelfWithAuthorizedUser() {
        UserRegistrationRequest userRegistrationRequest = DataGeneratorUser.getUserRegistrationRequestWithOnlyRequiredParameters();

        UserInfoResponse userInfoResponse = UserApi.registerUser(userRegistrationRequest).as(UserInfoResponse.class);

        UserAuthResponse userAuthResponse = UserApi.getToken(new UserAuthRequest(
                userRegistrationRequest.getUserName(),
                userRegistrationRequest.getPassword()
        )).as(UserAuthResponse.class);

        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters(userAuthResponse.getToken());

        BookShelfResponse bookShelfResponseBody = BookShelfApi.addBookToBookShelf(
                userAuthResponse.getToken(),
                AddBookToBookShelfRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        ).as(BookShelfResponse.class);

        Response response = BookShelfApi.rentABook(
                userAuthResponse.getToken(),
                RentABookRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        );

        BookShelfResponse bookShelfResponseBodyAfterRent = response.as(BookShelfResponse.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(bookShelfResponseBodyAfterRent).isNotNull(),
                () -> assertThat(bookShelfResponseBodyAfterRent.getId()).isEqualTo(bookShelfResponseBody.getId()),
                () -> assertThat(bookShelfResponseBodyAfterRent.getBookId()).isEqualTo(bookShelfResponseBody.getBookId()),
                () -> assertThat(bookShelfResponseBodyAfterRent.getRentedByUserId()).isEqualTo(userInfoResponse.getId())
        );

    }

    @Test
    void testImpossibleToRentBookTwiceIfItIsOnlyOneOnBookShelf() {
        UserRegistrationRequest userRegistrationRequest = DataGeneratorUser.getUserRegistrationRequestWithOnlyRequiredParameters();

        UserApi.registerUser(userRegistrationRequest).as(UserInfoResponse.class);

        UserAuthResponse userAuthResponse = UserApi.getToken(new UserAuthRequest(
                userRegistrationRequest.getUserName(),
                userRegistrationRequest.getPassword()
        )).as(UserAuthResponse.class);

        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters(userAuthResponse.getToken());

        BookShelfApi.rentABook(
                userAuthResponse.getToken(),
                RentABookRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        );

        Response responseSecondRent = BookShelfApi.rentABook(
                userAuthResponse.getToken(),
                RentABookRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        );

        ErrorModel errorResponse = responseSecondRent.as(ErrorModel.class);

        assertAll(
                () -> assertThat(responseSecondRent.statusCode()).isEqualTo(HttpStatus.SC_CONFLICT),
                () -> assertThat(errorResponse).isNotNull(),
                () -> assertThat(errorResponse.getStatus()).isEqualTo(409),
                () -> assertThat(errorResponse.getError()).isEqualTo("Conflict")
        );

    }

    @Test
    void testGetBookShelfState() {
        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters(VALID_TOKEN);

        BookShelfResponse bookShelfResponseBody = BookShelfApi.addBookToBookShelf(
                VALID_TOKEN,
                AddBookToBookShelfRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        ).as(BookShelfResponse.class);

        Response response = BookShelfApi.getBookShelf();

        List<BookShelfResponse> booksOnShelf = response.jsonPath().getList("", BookShelfResponse.class);

        BookShelfResponse bookOnShelfFromList = booksOnShelf.stream()
                        .filter(bookShelfResponse -> bookShelfResponse.getId().equals(bookShelfResponseBody.getId()))
                                .findFirst().orElse(null);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(booksOnShelf).isNotEmpty(),
                () -> assertThat(bookOnShelfFromList).usingRecursiveComparison().isEqualTo(bookShelfResponseBody)
        );
    }

}
