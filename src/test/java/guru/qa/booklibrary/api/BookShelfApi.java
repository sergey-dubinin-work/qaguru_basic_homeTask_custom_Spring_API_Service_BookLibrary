package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.bookShelf.AddBookToBookShelfRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static java.util.Objects.isNull;

public class BookShelfApi {

    private static final String ADD_TO_BOOK_SHELF = "/bookshelf/addToBookShelf";

    private static Response sendAddBookToBookShelfRequest(String token, AddBookToBookShelfRequest addBookToBookShelfRequest){
        RequestSpecification spec = given();

        if (!isNull(token)){
            spec
                    .auth().oauth2(token);
        }

        return spec
                .contentType(ContentType.JSON)
                .body(addBookToBookShelfRequest)
                .when()
                .post(ADD_TO_BOOK_SHELF)
                .then()
                .extract().response();
    }

    public static Response addBookToBookShelf(AddBookToBookShelfRequest addBookToBookShelfRequest){
        return sendAddBookToBookShelfRequest(null, addBookToBookShelfRequest);
    }

    public static Response addBookToBookShelf(String token, AddBookToBookShelfRequest addBookToBookShelfRequest){
        return sendAddBookToBookShelfRequest(token, addBookToBookShelfRequest);
    }

}
