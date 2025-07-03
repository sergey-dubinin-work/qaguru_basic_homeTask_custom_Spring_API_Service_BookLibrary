package guru.qa.booklibrary.tests;

import guru.qa.booklibrary.BookLibraryApiTest;
import guru.qa.booklibrary.api.BookShelfApi;
import guru.qa.booklibrary.dataGenerators.DataGeneratorBook;
import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import guru.qa.booklibrary.model.dto.bookShelf.BookShelfResponse;
import guru.qa.booklibrary.model.dto.books.BookResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BookShelfTest extends BookLibraryApiTest {

    @Test
    void testAddingBookToBookShelf() {
        BookResponse bookResponse = DataGeneratorBook.createBookWithOnlyRequiredParameters();

        BookShelfResponse bookShelfResponse = BookShelfApi.addBookToBookShelf(
                AddBookToBookShelfRequest.builder()
                        .bookId(bookResponse.getId())
                        .build()
        ).as(BookShelfResponse.class);

        assertAll(
                () -> assertThat(bookShelfResponse).isNotNull(),
                () -> assertThat(bookShelfResponse.getId()).isNotNull(),
                () -> assertThat(bookShelfResponse.getBookId()).isEqualTo(bookResponse.getId()),
                () -> assertThat(bookShelfResponse.getRentedByUserId()).isNull()
        );
    }
}
