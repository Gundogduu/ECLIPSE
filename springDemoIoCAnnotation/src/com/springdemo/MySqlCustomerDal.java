package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

//CLASS CONFIG ���NDE BEAN TANIMLAMAK i�in config dosyas�na hari� bir �ey eklememize gerek yok.
public class MySqlCustomerDal implements ICustomerDal{
	@Value("${database.connectionString}")                           //Property injection
	String connectionString;								
	
	public String getConnectionString() {					
		return connectionString;
	}
	public void setConnectionString(String connectionString) {     
		this.connectionString = connectionString;
	}
	
	
	@Override
	public void add() {
		System.out.println("ConnectionString : " +this.connectionString);      
		System.out.println("MySql veritaban�na eklendi");                      //MYSQL kodlar�...
	}

}
