package springIntro;

// SPAGETTI CODE ILE...
//public class CustomerDal {
	//CustomerDal'�n i�erisine ise daha �nce ��rendi�imiz insert operasyonlar�n� yazar�z biz.Yani veriye eri�imi burada yapar�z.
//	public void add(int Type) {
//		if(Type == 1) {               //TYPE ekledi�imiz i�in yazd�k.
//			System.out.println("Oracle veri taban�na eklendi"); //ilerleyen s�re�lerde hibernate ile yazaca��z bunlar�.Burada oracle kodlar�n�n oldu�unu varsay�n.
		 														//g�zeel.Dolay�s�yla customerManager bunu yapacak.Haydi gelin Main.javaya gidelim kodlar�m�z� �al��t�ral�m...
//		}else {
//			System.out.println("MySQL veri taban�na eklendi");
//		}
		
//	}
		


//}

//Dal - Data Access Layer = M��teri operasyonlar�n�n yaz�laca�� nesne.
//�imdi bir nesne daha olu�turuyorum.Onu kullanacak ba�ka bir nesne,bir tane daha class o da CustomerManager.
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
			System.out.println("Oracle veri taban�na eklendi");   //Oracle kodlar�...
		
	}
	

}
