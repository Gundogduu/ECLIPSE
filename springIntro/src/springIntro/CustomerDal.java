package springIntro;

// SPAGETTI CODE ILE...
//public class CustomerDal {
	//CustomerDal'ýn içerisine ise daha önce öðrendiðimiz insert operasyonlarýný yazarýz biz.Yani veriye eriþimi burada yaparýz.
//	public void add(int Type) {
//		if(Type == 1) {               //TYPE eklediðimiz için yazdýk.
//			System.out.println("Oracle veri tabanýna eklendi"); //ilerleyen süreçlerde hibernate ile yazacaðýz bunlarý.Burada oracle kodlarýnýn olduðunu varsayýn.
		 														//güzeel.Dolayýsýyla customerManager bunu yapacak.Haydi gelin Main.javaya gidelim kodlarýmýzý çalýþtýralým...
//		}else {
//			System.out.println("MySQL veri tabanýna eklendi");
//		}
		
//	}
		


//}

//Dal - Data Access Layer = Müþteri operasyonlarýnýn yazýlacaðý nesne.
//þimdi bir nesne daha oluþturuyorum.Onu kullanacak baþka bir nesne,bir tane daha class o da CustomerManager.
/////////////////////


public class CustomerDal implements ICustomerDal{
	
	String connectionString;                               //metin injection
	
	public String getConnectionString() {                  //metin injection
		return connectionString;
	}
	public void setConnectionString(String connectionString) {    //metin injection
		this.connectionString = connectionString;
	}
		

	public void add() {
			System.out.println("ConnectionString : " +this.connectionString);
			System.out.println("Oracle veri tabanýna eklendi");   //Oracle kodlarý...
		
	}
	

}
