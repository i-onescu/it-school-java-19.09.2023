package org.bogdan.bankingsystem.configurations;

import org.bogdan.bankingsystem.interfaces.SomeInterface;
import org.bogdan.bankingsystem.service.BankingService;
import org.bogdan.bankingsystem.service.VATCalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
// We need to @ComponentScan to allow spring to scan for dependencies
@ComponentScan(basePackages = "org.bogdan.bankingsystem")
public class BankingSystemConfiguration {

    // In this case, bankingService has a dependency for a vatCalculatorService instance
    @Bean("firstBankingService")
    public BankingService bankingService(VATCalculatorService vatCalculatorService) {
        return new BankingService(vatCalculatorService);
    }

    @Bean("secondBankingService")
    public BankingService otherBankingService(VATCalculatorService vatCalculatorService) {
        return new BankingService(vatCalculatorService);
    }

    // We can add also anonymous class instances in the bean context,
    // they can either be referred by the method name,
    // or by the name specified in the @Bean annotation by using @Qualifier when injecting
    @Bean("chillInterface")
    public SomeInterface someInterface() {
        return new SomeInterface() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }

            @Override
            public void sayBye() {
                System.out.println("Bye");
            }
        };
    }

    @Bean("angryInterface")
    public SomeInterface someOtherInterface() {
        return new SomeInterface() {
            @Override
            public void sayHello() {
                System.out.println("Angry Hello");
            }

            @Override
            public void sayBye() {
                System.out.println("Angry Bye");
            }
        };
    }

    @Bean
    // By default, Spring creates beans in an 'eager' manner, meaning adding the beans
    // in the container at the moment of application starting.
    // We can manually specify that we want a specific bean to be added into the bean context
    // on demand by annotating the method with @Lazy.
    @Lazy
    public VATCalculatorService vatCalculatorService() {
        return new VATCalculatorService();
    }
}
