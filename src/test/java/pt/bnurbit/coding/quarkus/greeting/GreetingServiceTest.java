package pt.bnurbit.coding.quarkus.greeting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class GreetingServiceTest {

    @Inject
    private GreetingService greetingService;

    @Test
    void checkReturnsHello() {
        Assertions.assertEquals("null-test-english-country-CountryName:351", greetingService.hello()); // uses mock service
    }
}
