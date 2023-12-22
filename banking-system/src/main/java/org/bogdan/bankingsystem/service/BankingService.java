package org.bogdan.bankingsystem.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.bogdan.bankingsystem.service.VATCalculatorService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// The @Service annotation will add an instance of type BankingService in the Spring application context.
// Basically, this class is a regular instantiable class. It has methods, can also have other fields etc...
// The 'service' name means that here will happen the business logic.
//@Service

// @Deprecated is an informational annotation which marks a class, method, etc. as not used anymore.
//@Deprecated
//@Component
public class BankingService {

    private final VATCalculatorService vatCalculatorService;

    public BankingService(VATCalculatorService vatCalculatorService) {
        this.vatCalculatorService = vatCalculatorService;
    }

    @PostConstruct
    public void populateBankTransactions() {
        System.out.println("salutare");
    }

    @PreDestroy
    public void clearBankTransactions() {
        System.out.println("papa");
    }

    public static void saySomething() {
        System.out.println("Something");
    }
}
