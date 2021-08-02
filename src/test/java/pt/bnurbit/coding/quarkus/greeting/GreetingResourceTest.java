package pt.bnurbit.coding.quarkus.greeting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        final String name = UUID.randomUUID().toString();
        given()
                .when()
                .queryParam("name", name)
                .get("/hello")
                .then()
                .statusCode(200)
                .body(is(String.format("Hello %s, your id is %s", name, "123")));
    }

    @Test
    void testHelloConfigEndpoint() {
        given()
                .when()
                .get("/hello/config")
                .then()
                .statusCode(200)
                .body(is("null-test-english-country-CountryName:351"));
    }
}
