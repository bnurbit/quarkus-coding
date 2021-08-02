package pt.bnurbit.coding.quarkus.crypto;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static io.restassured.RestAssured.given;

@QuarkusTest
class CryptoResourceTest {

    @Test
    void testGetCryptoEndpoint() {
        Optional<Currency> currency = Arrays.stream(given()
                .when()
                .queryParam("id", 80)
                .get("/crypto")
                .then()
                .statusCode(200)
                .extract().body().as(Currency[].class)).findFirst();

        Assertions.assertTrue(currency.isPresent());
        Assertions.assertEquals("80", currency.get().getId());
        Assertions.assertEquals("Ethereum", currency.get().getName());
        Assertions.assertEquals("ETH", currency.get().getSymbol());
    }
}
