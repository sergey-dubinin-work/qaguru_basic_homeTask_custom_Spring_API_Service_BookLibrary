package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static java.util.Objects.isNull;

public class BookShelfApi {

    private static final String BOOKSHELF           = "/bookshelf";
    private static final String ADD_TO_BOOK_SHELF   = "/bookshelf/addToBookShelf";

    private static Response sendAddBookToBookShelfRequest(String token, AddBookToBookShelfRequest addBookToBookShelfRequestBody){
        RequestSpecification spec = given();

        if (!isNull(token)){
            spec
                    .auth().oauth2(token);
        }

        return spec
                .contentType(ContentType.JSON)
                .body(addBookToBookShelfRequestBody)
                .when()
                .post(ADD_TO_BOOK_SHELF)
                .then()
                .extract().response();
    }

    public static Response addBookToBookShelf(AddBookToBookShelfRequest addBookToBookShelfRequestBody){
        return sendAddBookToBookShelfRequest(null, addBookToBookShelfRequestBody);
    }

    public static Response addBookToBookShelf(String token, AddBookToBookShelfRequest addBookToBookShelfRequestBody){
        return sendAddBookToBookShelfRequest(token, addBookToBookShelfRequestBody);
    }

    public static Response getBookShelf(){
        return given()
                .when()
                .get(BOOKSHELF)
                .then()
                .extract().response();
    }
}
