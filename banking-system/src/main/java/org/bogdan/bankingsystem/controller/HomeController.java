package org.bogdan.bankingsystem.controller;

import org.bogdan.bankingsystem.service.BankingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// annotations like @Component, @Controller, @Service and @Repository
// will create a spring bean in the Spring Application Context.
// the @Controller will make the class a controller (like a receptor) for user requests
// also, it will render templates used in combination with a templating engine like Thymeleaf.
@Controller
// this annotation will establish a path for this controller
// thus, each method within the controller must respect the path prefix (in our case, each request must start with "http://localhost:8080/home")
@RequestMapping("/home")
public class HomeController {

    // we can inject beans from context into instance variables by:
    // - adding @Autowired on the instance field (makes the injection less visible, complicated)
    // - by making the field final and initializing it through the ctor
    // - by adding @Autowired on the setter method corresponding the instance field
    //@Autowired
    private final BankingService bankingService;

    public HomeController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    // @GetMapping annotation will make the "home()" method a receptor each GET request
    @GetMapping
    // in order to reach the receptor, we need to have requests like http://localhost:8080/home/banking
    @RequestMapping("/banking")
    public String home() {
        // the "bankingService" variable is not null because it was injected
        // if we require the variable to be injected from the spring context
        // and let's say that the variable is not found, the app will be prevented from running
        // thus, we don't need to deal with Null Pointer Exceptions.
        bankingService.saySomething();
        return "home";
    }

//    @Autowired
//    public void setBankingService(BankingService bankingService) {
//        this.bankingService = bankingService;
//    }
}
