package org.bogdan.bankingsystem.service;

import org.springframework.stereotype.Service;

// The @Service annotation will add an instance of type BankingService in the Spring application context.
// Basically, this class is a regular instantiable class. It has methods, can also have other fields etc...
// The 'service' name means that here will happen the business logic.
@Service
public class BankingService {

    public void saySomething() {
        System.out.println("Say something from the banking service.");
    }
}
