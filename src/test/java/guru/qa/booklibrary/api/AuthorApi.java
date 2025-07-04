package guru.qa.booklibrary.api;

import guru.qa.booklibrary.model.dto.authors.AddAuthorRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static java.util.Objects.isNull;

public class AuthorApi {

    private static final String AUTHOR = "/author";

    private static Response sendAddAuthorRequest(String token, AddAuthorRequest addAuthorRequestBody){
        RequestSpecification spec =
                given();

        if (!isNull(token)){
            spec
                    .auth().oauth2(token);
        }

        return
                spec
                        .contentType(ContentType.JSON)
                        .body(addAuthorRequestBody)
                        .when()
                        .post(AUTHOR)
                        .then()
                        .extract().response();
    }

    public static Response addAuthor(AddAuthorRequest addAuthorRequestBody){
        return sendAddAuthorRequest(null, addAuthorRequestBody);
    }

    public static Response addAuthor(String token, AddAuthorRequest addAuthorRequestBody){
        return sendAddAuthorRequest(token, addAuthorRequestBody);
    }

    public static Response getAuthors(){
        return given()
                .when()
                .get(AUTHOR)
                .then()
                .extract().response();
    }
}
