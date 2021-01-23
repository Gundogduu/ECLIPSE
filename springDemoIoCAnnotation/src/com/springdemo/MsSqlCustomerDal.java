package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

//CLASS CONFIG ���NDE BEAN TANIMLAMAK i�in config dosyas�na hari� bir �ey eklememize gerek yok.
public class MsSqlCustomerDal implements ICustomerDal{
	@Value("${database.connectionString}")										//Property injection
	String connectionString;										
	
	public String getConnectionString(String connectionString) {
		return connectionString;
	}
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	@Override
	public void add() {
		System.out.println("ConnectionString : " +this.connectionString);          
		System.out.println("Ms Sql veritaban�na eklendi");                     //Ms Sql kodlar�...
		
	}

}













//import org.springframework.stereotype.Component;                    

//@Component ("database")                                            //Annotation injection  i�in burada sadece bunu ekledik �imdi xml'e gidiyoruz.
//public class MsSqlCustomerDal implements ICustomerDal{

//	String connectionString;										
	
//	public String getConnectionString(String connectionString) {
//		return connectionString;
//	}
//	public void setConnectionString(String connectionString) {
//		this.connectionString = connectionString;
//	}
	
//	@Override
//	public void add() {
//		System.out.println("ConnectionString : " +this.connectionString);          
//		System.out.println("Ms Sql veritaban�na eklendi");                     //Ms Sql kodlar�...
		
//	}

//}



