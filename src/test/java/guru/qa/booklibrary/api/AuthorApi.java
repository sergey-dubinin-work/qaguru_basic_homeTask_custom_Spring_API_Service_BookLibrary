package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.authors.AddAuthorRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthorApi {

    private static final String AUTHOR = "/author";

    public static Response addAuthor(AddAuthorRequest addAuthorRequest){
        return given()
                .contentType(ContentType.JSON)
                .body(addAuthorRequest)
                .when()
                .post(AUTHOR)
                .then()
                .extract().response();
    }

    public static Response getAuthors(){
        return given()
                .when()
                .get(AUTHOR)
                .then()
                .extract().response();
    }
}
