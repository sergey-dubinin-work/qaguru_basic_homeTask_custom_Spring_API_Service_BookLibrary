package guru.qa.booklibrary.tests;

import guru.qa.booklibrary.BookLibraryApiTest;
import guru.qa.booklibrary.api.BookShelfApi;
import guru.qa.booklibrary.dataGenerators.DataGeneratorBook;
import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.model.dto.bookShelf.BookShelfResponse;
import guru.qa.booklibrary.model.dto.books.BookResponse;
import guru.qa.booklibrary.models.ErrorModel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

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
}
