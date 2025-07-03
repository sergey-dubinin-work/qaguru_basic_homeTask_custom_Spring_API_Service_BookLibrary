package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookShelfApi {

    private static final String ADD_TO_BOOK_SHELF = "/bookshelf/addToBookShelf";

    public static Response addBookToBookShelf(AddBookToBookShelfRequest addBookToBookShelfRequest){
        return given()
                .contentType(ContentType.JSON)
                .body(addBookToBookShelfRequest)
                .when()
                .post(ADD_TO_BOOK_SHELF)
                .then()
                .extract().response();
    }

}
