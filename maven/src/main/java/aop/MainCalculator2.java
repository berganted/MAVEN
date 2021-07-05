package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chap05.Calculator;

public class MainCalculator2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator calculator = ctx.getBean("calculator",Calculator.class);
		System.out.println(calculator.facetorial(10));
		System.out.println(calculator.getClass().getName());
		
	}

}
