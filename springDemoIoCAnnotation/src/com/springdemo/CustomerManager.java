package com.springdemo;

public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	
	//Constructor Injection - sekt�r�n %99'u kullan�yor
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;                 
	}													


	public void add() {
		//i� kuralllar�
		//CustomerDal customerDal = new CustomerDal();
		customerDal.add();							   
	}												  
													   
													    
}



