package springIntro;

// SPAGETTI CODE
//public class CustomerManager {
	
//	public void add() {    //parametre olarak customer vs. alacak girmiyorum oralara...
		//i� kuralllar�             //managerlar i� kodlar�d�r i� kurallar�n� �al��t�r�r.Yani bu m��teri daha �nce eklenmi� mi?
									//m��teriyi kaydedebilir miyiz?,kaydetmek i�in m��terinin �artlar� sa�lan�yor mu?... bunlar� yazar�z.
									//b�t�n �artlar sa�lan�yorsa biz customerDal'� �a��r�r�z...
		//i� kurallar� ge�ti,ge�tiyse veri eri�imi �a��r.
//		CustomerDal customerDal = new CustomerDal();
//		customerDal.add(1);                 //CustomerDal'a type ge�ince buraya da 1 ekledik.
//	}

//}


public class CustomerManager implements ICustomerService{
	
	private ICustomerDal customerDal;
	
	//Constructor Injection - sekt�r�n %99'u kullan�yor
	public CustomerManager(ICustomerDal customerDal) {    //Evet,bu �u anlama geldi arkada�lar; CustomerManager'�n Constructor'�nda bir ICustomerDal nesnesi istiyor demek.Alttaki operasyonda newledi�imiz yeri siliyoruz gerek kalmad�.
		this.customerDal = customerDal;                   //�imdi durum ��yle CustomerManager,parametre olarak bir ICustomerDal istiyor.Ve onun add() ini �al��t�r�yor.Daha �nce konu�tuk ama bu bir referance type(ICustomerDal customerDal).
	}													  //Referans tip oldu�u i�in bunu implement eden herkesi CustomerManager'a parametre olarak verebilirsin demektir.Yani CustomerDal implemente ediyor ya ICustomerDal'�! i�te Oracle'� parametre olarak verebilirsin demek.
														  //Bak�n Main.java ya gelidi�imizde newledi�imiz yere paramere istiyor olacak.ICustomerDal nesnesi istiyor olacak.ICustomerDal'�n referans�n� tuttu�u nesneyi yazd���m�zda kod ba�ar�yla �al��m�� olacak.		
														  //�imdi diyelin ki 5 ay ge�ti ve y�netim dedi ki; art�k MYSQL deste�i getiriyoruz...
														  //�imdi yapmam�z gereken sadece yeni bir class ekleyip MYSQL kodlar�n� yazmak,Class'� implemente etmek ve main.java da parametre alan�na class'�n ad�n� yazmak arkada�lar.
														  //Bu i�lemlerin hepsi Dependency Injection olarak yapt�k,onu ��rendik.Peki IoC container nerde? ��te SPRING tam olarak onu yap�yor arkada�lar. SON!!!
														//�imdi IoC ile yapaca��z...

	//Setter Injection  - Engin hoca tavsiye etmiyor
	//public void setCustomerDal(ICustomerDal customerDal) {
	//	this.customerDal = customerDal;
	//}

	public void add() {
		//i� kuralllar�
		//CustomerDal customerDal = new CustomerDal();  //Evet,i� kodudur bu.Bir class bak�a bir class'� newlememelidir.Peki newlemeden nas�l olacak?
		customerDal.add();							    //��te IoC bize burada yarayacak.Peki nas�l yapacak?��yle ki bir tane ICustomerDal isimli Interface ekliyorum...
	}												    //Yani ben CustomerDal'�n  void add() operasyonunu Interface �zerinden y�netmek istiyorum.
													    //Ekledikten sonra CustomerDal'�n implemente etmesi gerekiyor ICustomerDal'dan...
													    //daha sonra Peki manager bunu nass�l kullanacak?Daha sonra g�rece�iz bunlar� en �ok kullan�lan Dependency Injection y�ntemidir.
													    //�imdi size Dependency Injection'�n bir tasar�m desenini g�sterece�im.�lk kez g�r�yorsunuz bunu!...
													    //Manager'a bir ICustomerDal nesnesi olu�turuyorum private olarak ve sa�t�k>source yap�p Constructor olu�turuyorum...
}



