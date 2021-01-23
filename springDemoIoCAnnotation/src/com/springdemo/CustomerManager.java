package com.springdemo;

public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	
	//Constructor Injection - sektörün %99'u kullanýyor
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;                 
	}													


	public void add() {
		//iþ kuralllarý
		//CustomerDal customerDal = new CustomerDal();
		customerDal.add();							   
	}												  
													   
													    
}



