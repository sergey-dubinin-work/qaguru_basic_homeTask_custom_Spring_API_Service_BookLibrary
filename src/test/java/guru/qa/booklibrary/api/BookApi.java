package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.books.AddBookRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class BookApi {
    private static final String BOOK = "/book";

    private static Response sendAddBookResponse(String token, AddBookRequest addBookRequestBody){
        RequestSpecification spec =
                given();

        if(!Objects.isNull(token)){
            spec
                    .auth().oauth2(token);
        }

        return spec
                .contentType(ContentType.JSON)
                .body(addBookRequestBody)
                .when()
                .post(BOOK)
                .then()
                .extract().response();

    }

    public static Response addBook(AddBookRequest addBookRequestBody){
        return sendAddBookResponse(null, addBookRequestBody);
    }

    public static Response addBook(String token, AddBookRequest addBookRequestBody){
        return sendAddBookResponse(token, addBookRequestBody);
    }

    public static Response getBooks(){
        return given()
                .when()
                .get(BOOK)
                .then()
                .extract().response();
    }

}
