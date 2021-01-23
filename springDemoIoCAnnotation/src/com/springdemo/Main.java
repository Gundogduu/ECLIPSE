package com.springdemo;
//CLASS CONFIG ���NDE BEAN TANIMLAMAK i�in config dosyas�na hari� bir �ey eklememize gerek yok.
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{
		
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(IocConfig.class);          
		//context.refresh();                                   
		ICustomerDal customerDal = context.getBean("database",ICustomerDal.class);
		customerDal.add();
		
		//BA�LI CLASSLARIN ��Z�MLENMES�
		ICustomerService customerService = context.getBean("service",ICustomerService.class);
		customerService.add();
	}

}
