package guru.qa.booklibrary;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BookLibraryApiTest extends ApiTest{
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8081/";
    }
}
