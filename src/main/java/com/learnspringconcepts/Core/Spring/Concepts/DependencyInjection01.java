package com.learnspringconcepts.Core.Spring.Concepts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBuisnessClass{

	@Autowired
	Dependency1 dependency1;
	@Autowired
	Dependency2 dependency2;

	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		System.out.println("Doing Setter Injection on Dependency1");
		this.dependency1 = dependency1;
	}

	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		System.out.println("Doing Setter Injection on Dependency2");
		this.dependency2 = dependency2;
	}

	@Autowired
	public YourBuisnessClass(Dependency1 dependency1, Dependency2 dependency2) {
		System.out.println("Doing Constructor Injection on Dependency1 and Dependency2");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	@Override
	public String toString() {
		return "Using " + dependency1 + " and  " + dependency2;

	}
}
@Component
class Dependency1{}
@Component
class Dependency2{}

@Configuration
@ComponentScan
public class DependencyInjection01 {

	public static void main(String[] args) {


		try (var context = new AnnotationConfigApplicationContext(DependencyInjection01.class)) {

			Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
			System.out.println(context.getBean(YourBuisnessClass.class));

		}

	}
}
