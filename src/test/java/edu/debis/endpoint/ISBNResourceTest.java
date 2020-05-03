package edu.debis.endpoint;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ISBNResourceTest {

    @Test
    public void testISBNAllEndpoint() {
        given()
                .when().get("/isbn")
                .then()
                .statusCode(200);
                //.body(is());
    }

    public void testISBNError() {
        given()
                .when().get("/isbn/9971-5-0210")
                .then()
                .statusCode(500);
        //.body(is());
    }

    public void testISBNSuccess() {
        given()
                .when().get("/isbn/9971-5-0210-0")
                .then()
                .statusCode(200);
        //.body(is());
    }
}
