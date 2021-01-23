package springIntro;

// SPAGETTI CODE
//public class CustomerManager {
	
//	public void add() {    //parametre olarak customer vs. alacak girmiyorum oralara...
		//iþ kuralllarý             //managerlar iþ kodlarýdýr iþ kurallarýný çalýþtýrýr.Yani bu müþteri daha önce eklenmiþ mi?
									//müþteriyi kaydedebilir miyiz?,kaydetmek için müþterinin þartlarý saðlanýyor mu?... bunlarý yazarýz.
									//bütün þartlar saðlanýyorsa biz customerDal'ý çaðýrýrýz...
		//iþ kurallarý geçti,geçtiyse veri eriþimi çaðýr.
//		CustomerDal customerDal = new CustomerDal();
//		customerDal.add(1);                 //CustomerDal'a type geçince buraya da 1 ekledik.
//	}

//}


public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	
	//Constructor Injection - sektörün %99'u kullanýyor
	public CustomerManager(ICustomerDal customerDal) {    //Evet,bu þu anlama geldi arkadaþlar; CustomerManager'ýn Constructor'ýnda bir ICustomerDal nesnesi istiyor demek.Alttaki operasyonda newlediðimiz yeri siliyoruz gerek kalmadý.
		this.customerDal = customerDal;                   //Þimdi durum þöyle CustomerManager,parametre olarak bir ICustomerDal istiyor.Ve onun add() ini çalýþtýrýyor.Daha önce konuþtuk ama bu bir referance type(ICustomerDal customerDal).
	}													  //Referans tip olduðu için bunu implement eden herkesi CustomerManager'a parametre olarak verebilirsin demektir.Yani CustomerDal implemente ediyor ya ICustomerDal'ý! iþte Oracle'ý parametre olarak verebilirsin demek.
														  //Bakýn Main.java ya gelidiðimizde newlediðimiz yere paramere istiyor olacak.ICustomerDal nesnesi istiyor olacak.ICustomerDal'ýn referansýný tuttuðu nesneyi yazdýðýmýzda kod baþarýyla çalýþmýþ olacak.		
														  //Þimdi diyelin ki 5 ay geçti ve yönetim dedi ki; artýk MYSQL desteði getiriyoruz...
														  //Þimdi yapmamýz gereken sadece yeni bir class ekleyip MYSQL kodlarýný yazmak,Class'ý implemente etmek ve main.java da parametre alanýna class'ýn adýný yazmak arkadaþlar.
														  //Bu iþlemlerin hepsi Dependency Injection olarak yaptýk,onu öðrendik.Peki IoC container nerde? Ýþte SPRING tam olarak onu yapýyor arkadaþlar. SON!!!
														//Þimdi IoC ile yapacaðýz...

	//Setter Injection  - Engin hoca tavsiye etmiyor
	//public void setCustomerDal(ICustomerDal customerDal) {
	//	this.customerDal = customerDal;
	//}

	public void add() {
		//iþ kuralllarý
		//CustomerDal customerDal = new CustomerDal();  //Evet,iþ kodudur bu.Bir class bakþa bir class'ý newlememelidir.Peki newlemeden nasýl olacak?
		customerDal.add();							    //Ýþte IoC bize burada yarayacak.Peki nasýl yapacak?Þöyle ki bir tane ICustomerDal isimli Interface ekliyorum...
	}												    //Yani ben CustomerDal'ýn  void add() operasyonunu Interface üzerinden yönetmek istiyorum.
													    //Ekledikten sonra CustomerDal'ýn implemente etmesi gerekiyor ICustomerDal'dan...
													    //daha sonra Peki manager bunu nassýl kullanacak?Daha sonra göreceðiz bunlarý en çok kullanýlan Dependency Injection yöntemidir.
													    //Þimdi size Dependency Injection'ýn bir tasarým desenini göstereceðim.Ýlk kez görüyorsunuz bunu!...
													    //Manager'a bir ICustomerDal nesnesi oluþturuyorum private olarak ve saðtýk>source yapýp Constructor oluþturuyorum...
}



