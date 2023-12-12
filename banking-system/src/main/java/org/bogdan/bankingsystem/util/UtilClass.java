package org.bogdan.bankingsystem.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// When you are not sure about the class "speciality", you can annotate it with @Component
@Component
public class UtilClass {

    // This will fail as there is already a bean in the context with the same name,
    // but you can pass a name to the @Bean annotation and the app startup will be possible.
//    @Bean("test")
//    public CommandLineRunner doSomething() {
//        return args -> System.out.println("Hello");
//    }
}
