package pt.bnurbit.coding.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
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
    public void testHelloConfigEndpoint() {
        given()
                .when()
                .get("/hello/config")
                .then()
                .statusCode(200)
                .body(is("null-test-english-country-CountryName:351"));
    }
}
