package org.bogdan.bankingsystem.controller;

import org.bogdan.bankingsystem.interfaces.SomeInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class MyTestController {

    private final SomeInterface someInterfaceList;

    // We can use injection by either respective the class name, or bean-annotated method name,
    // or we can specify a name to the beans on @Component/@Service/@Bean etc... annotations.
    // In order to specify the name when we inject the bean, we can use @Qualifier
    public MyTestController(@Qualifier("salutInterface") SomeInterface someInterfaceList) {
        this.someInterfaceList = someInterfaceList;
    }
}
