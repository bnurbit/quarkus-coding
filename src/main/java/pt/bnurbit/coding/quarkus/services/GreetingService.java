package pt.bnurbit.coding.quarkus.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {

    public String hello(String name){
        return String.format("Hello %s, your id is %s", name, UUID.randomUUID());
    }
}
