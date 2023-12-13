package org.bogdan.bankingsystem.interfaces;

import org.springframework.stereotype.Component;

// now we have an instance of 'SomeInterface' in the Spring container
@Component("salutInterface")
public class InterfaceImpl implements SomeInterface {
    @Override
    public void sayHello() {
        System.out.println("Interface Hello");
    }

    @Override
    public void sayBye() {
        System.out.println("Interface Bye");
    }
}
