package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.books.AddBookRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookApi {
    private static final String BOOK = "/book";

    public static Response addBook(AddBookRequest addBookRequestBody){
        return given()
                .contentType(ContentType.JSON)
                .body(addBookRequestBody)
                .when()
                .post(BOOK)
                .then()
                .extract().response();
    }

    public static Response getBooks(){
        return given()
                .when()
                .get(BOOK)
                .then()
                .extract().response();
    }

}
