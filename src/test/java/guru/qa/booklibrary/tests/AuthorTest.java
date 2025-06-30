package guru.qa.booklibrary.tests;

import guru.qa.booklibrary.BookLibraryApiTest;
import guru.qa.booklibrary.api.AuthorApi;
import guru.qa.booklibrary.dto.authors.AddAuthorRequest;
import guru.qa.booklibrary.dto.authors.AuthorResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AuthorTest extends BookLibraryApiTest {

    @Test
    void testAuthorCreation() {
        AddAuthorRequest addAuthorRequest = AddAuthorRequest.builder()
                .authorName(faker.name().fullName())
                .build();

        Response response = AuthorApi.addAuthor(addAuthorRequest);
        AuthorResponse authorResponse = response.as(AuthorResponse.class);

        assertAll(
                () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK),
                () -> assertThat(authorResponse.getId()).isNotNull(),
                () -> assertThat(authorResponse.getAuthorName()).isEqualTo(addAuthorRequest.getAuthorName())
        );

    }

    @Test
    void testGetAuthors() {
        AddAuthorRequest addAuthorRequest = AddAuthorRequest.builder()
                .authorName(faker.name().fullName())
                .build();

        AuthorResponse authorResponse = AuthorApi.addAuthor(addAuthorRequest).as(AuthorResponse.class);

        List<AuthorResponse> authorsResponse = AuthorApi.getAuthors().jsonPath().getList("", AuthorResponse.class);

        AuthorResponse authorResponseFromList = authorsResponse.stream()
                        .filter(author -> author.getId().equals(authorResponse.getId()))
                                .findFirst().orElse(null);

        assertAll(
                () -> assertThat(authorsResponse).isNotEmpty(),
                () -> assertThat(authorResponseFromList).isNotNull(),
                () -> assertThat(authorResponseFromList.getAuthorName()).isEqualTo(addAuthorRequest.getAuthorName()),
                () -> assertThat(authorResponseFromList.getId()).isEqualTo(authorResponse.getId())
        );

    }
}
