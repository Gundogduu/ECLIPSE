package com.springdemo;
//CLASS CONFIG ÝÇÝNDE BEAN TANIMLAMAK için config dosyasýna hariç bir þey eklememize gerek yok.
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main{
		
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(IocConfig.class);          
		//context.refresh();                                   
		ICustomerDal customerDal = context.getBean("database",ICustomerDal.class);
		customerDal.add();
		
		//BAÐLI CLASSLARIN ÇÖZÜMLENMESÝ
		ICustomerService customerService = context.getBean("service",ICustomerService.class);
		customerService.add();
	}

}
