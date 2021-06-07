package pt.bnurbit.coding.quarkus.services;

import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;

@Mock
@ApplicationScoped
public class MockGreetingService extends GreetingService {

    @Override
    public String hello(String name){
        return String.format("Hello %s, your id is %s", name, "123");
    }
}
