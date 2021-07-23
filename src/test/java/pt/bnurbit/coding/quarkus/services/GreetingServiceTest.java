package pt.bnurbit.coding.quarkus.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class GreetingServiceTest {

    @Inject
    private GreetingService greetingService;

    @Test
    public void checkReturnsHello() {
        Assertions.assertEquals("null-test-english-country-CountryName:351", greetingService.hello()); // uses mock service
    }
}
