package org.bogdan.bankingsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
	}
//
//	// This is another manner to add a bean in the Spring application context.
//	// marking the method with @Bean annotation.
//	// CommandLineRunner method can be initialized with an anonymous class, or a lambda function
//	// this type will be executed after the application started.
//	@Bean
//	public CommandLineRunner doSomething() {
//		CommandLineRunner commandLineRunner = new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("say something");
//			}
//		};
//		return commandLineRunner;
//	}
//
//	// by default, when we annotate the class with @Service etc... there is only one instance of that type in the context.
//	// this manner is called 'singleton'
//	// we can also define multiple beans of the same type in our context, by using @Bean annotation.
//	// note here that the difference between them is the method name that will become the bean name.
//	@Bean
//	public CommandLineRunner doSomethingElse() {
//		CommandLineRunner commandLineRunner = new CommandLineRunner() {
//			@Override
//			public void run(String... args) throws Exception {
//				System.out.println("say something else");
//			}
//		};
//		return commandLineRunner;
//	}
}
