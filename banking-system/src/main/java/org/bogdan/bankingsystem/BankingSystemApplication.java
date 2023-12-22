package org.bogdan.bankingsystem;

import jakarta.annotation.PostConstruct;
import org.bogdan.bankingsystem.configurations.BankingConfigurations;
import org.bogdan.bankingsystem.configurations.BankingSystemConfiguration;
import org.bogdan.bankingsystem.service.BankingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

@SpringBootApplication
@EnableConfigurationProperties
public class BankingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
	}

//	@PostConstruct
//	public void saySomething() {
//		ApplicationContext context =
//				new AnnotationConfigApplicationContext(BankingSystemConfiguration.class);
//		Object bankingService = context.getBean("bankingService");
//		System.out.println(bankingService);
//		Class<BankingService> bankingServiceClass = BankingService.class;
//		Annotation[] annotations = bankingServiceClass.getAnnotations();
//		System.out.println(annotations);
//	}
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
