package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

//CLASS CONFIG ÝÇÝNDE BEAN TANIMLAMAK için config dosyasýna hariç bir þey eklememize gerek yok.
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
		System.out.println("Ms Sql veritabanýna eklendi");                     //Ms Sql kodlarý...
		
	}

}













//import org.springframework.stereotype.Component;                    

//@Component ("database")                                            //Annotation injection  için burada sadece bunu ekledik þimdi xml'e gidiyoruz.
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
//		System.out.println("Ms Sql veritabanýna eklendi");                     //Ms Sql kodlarý...
		
//	}

//}



