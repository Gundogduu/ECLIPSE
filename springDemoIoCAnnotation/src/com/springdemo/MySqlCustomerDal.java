package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

//CLASS CONFIG ÝÇÝNDE BEAN TANIMLAMAK için config dosyasýna hariç bir þey eklememize gerek yok.
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
		System.out.println("MySql veritabanýna eklendi");                      //MYSQL kodlarý...
	}

}
