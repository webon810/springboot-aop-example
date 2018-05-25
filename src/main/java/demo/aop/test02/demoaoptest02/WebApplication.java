package demo.aop.test02.demoaoptest02;

import demo.aop.test02.demoaoptest02.service.Person;
import demo.aop.test02.demoaoptest02.service.Speakable;

import org.springframework.beans.factory.annotation.Autowired;
#manually add this dependency
import org.springframework.context.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebApplication {

	@Autowired
	private Speakable personSpring;

	public static void main(String[] args) {

		SpringApplication.run(WebApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// spring aop
			System.out.println("********spring aop ******** ");
			personSpring.sayHi();
			personSpring.sayBye();
			// jdk dynamic proxy
			System.out.println("********jdk dynamic proxy ******** ");
			Speakable jdkProxy = PersonProxyFactory.newJdkProxy();
			jdkProxy.sayHi();
			jdkProxy.sayBye();
			// cglib dynamic proxy
			System.out.println("********cglib proxy ******** ");
			Person cglibProxy = PersonProxyFactory.newCglibProxy();
			cglibProxy.sayHi();
			cglibProxy.sayBye();
			System.exit(0);
		};
	}
}
