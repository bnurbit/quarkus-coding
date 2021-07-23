package pt.bnurbit.coding.quarkus.services;

import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;

/**
 * Mocking GreetingService to be used during test execution.
 * Mock sets priority to 1 (highest priority), which is higher than in the methods of GreetingService
 */
@Mock
@ApplicationScoped
public class MockGreetingService extends GreetingService {

    @Override
    public String hello() {
        return "null-test-english-country-CountryName:351";
    }

    @Override
    public String hello(String name) {
        return String.format("Hello %s, your id is %s", name, "123");
    }
}
