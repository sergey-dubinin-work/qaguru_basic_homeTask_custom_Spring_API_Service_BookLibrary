package guru.qa.booklibrary.tests;

import guru.qa.booklibrary.BookLibraryApiTest;
import guru.qa.booklibrary.api.BookApi;
import guru.qa.booklibrary.dataGenerators.DataGeneratorAuthor;
import guru.qa.booklibrary.dataGenerators.DataGeneratorBook;
import guru.qa.booklibrary.dto.authors.AuthorResponse;
import guru.qa.booklibrary.dto.books.AddBookRequest;
import guru.qa.booklibrary.dto.books.BookResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BookTest extends BookLibraryApiTest {

    @Test
    void testBookCreation() {

        AuthorResponse authorResponse = DataGeneratorAuthor.createAuthorWithOnlyRequiredParameters();

        AddBookRequest addBookRequestBody = AddBookRequest.builder()
                .authorId(authorResponse.getId())
                .bookName(faker.starWars().wookieWords())
                .build();

        Response response = BookApi.addBook(addBookRequestBody);
        BookResponse bookResponse = response.as(BookResponse.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(bookResponse.getId()).isNotNull(),
                () -> assertThat(bookResponse.getAuthorId()).isEqualTo(addBookRequestBody.getAuthorId()),
                () -> assertThat(bookResponse.getBookName()).isEqualTo(addBookRequestBody.getBookName())
        );

    }

    @Test
    void testGetBooks() {
        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters();

        List<BookResponse> booksResponse = BookApi.getBooks().jsonPath().getList("", BookResponse.class);

        BookResponse bookResponseFromList = booksResponse.stream()
                .filter(book -> book.getId().equals(bookResponse.getId()))
                .findFirst().orElse(null);

        assertAll(
                () -> assertThat(booksResponse).isNotEmpty(),
                () -> assertThat(bookResponseFromList).isNotNull(),
                () -> assertThat(bookResponseFromList.getId()).isEqualTo(bookResponse.getId()),
                () -> assertThat(bookResponseFromList.getAuthorId()).isEqualTo(bookResponse.getAuthorId()),
                () -> assertThat(bookResponseFromList.getBookName()).isEqualTo(bookResponse.getBookName())
        );

    }

}
