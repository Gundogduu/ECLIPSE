package com.hibernatedemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//HAYD� GEL�N �LK SORGUMUZU YAZALIM... 
//Bunun i�in bize bir Session laz�m.Peki Session mimarisini ne ile olu�turuyoruz? Bir SessionFactory-Oturum fabrikas� ile.
//SessionFactory uygulamalarda bir kez olu�turulmas� gereken bir fabrikad�r.
public class Main {

	public static void main(String[] args) {
		//burada mainde yapt�k her seferinde main �al���nca bu da �al��acak ama web uygulamalar�nda nas�l yap�ld���n� g�rece�iz �imdi tak�lmay�n buna.
		//bu noktada bir konfigrasyon olu�turaca��z.Bak�n bunu ilk kez g�r�yorsunuz; (bir �eyi new'ledi�iniz zaman o �eyin metodlar� gelir)
		//new Configuration().configure() deyip konfigrasyon dosyam�z�n hangisi oldu�unu s�yl�yoruz.
		//Uygulamalarda SessionFactory bir yere yaz�l�r, ilk a��l��ta �al��t�r�l�r ve o kullan�l�r arkada�lar.
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")			//configure de bir class d�nd�r�yor(addAnnotatedClass).
				.addAnnotatedClass(City.class)   		//ile istedi�im herhangi bir class'� (City.class) buraya verebilirim.Bunu daha sonra t�m nesneler i�in yap�yor olaca��z.
				.buildSessionFactory();    				//dedi�imiz anda art�k fabrikam�z olu�tu.
		
		//�imdi fabrikadan bir oturum almam�z laz�m.��nk� sorgu yollayaca��m.
		//Unit of Word-Session'�n tasar�m desenidir.Unit of Word'�n uygulanm�� halidir.
		Session session = factory.getCurrentSession();
		
		//art�k biz bu session'� kullanarak veritaban�na sorgu g�nderebiliyor olaca��z.
		
		//session. dedi�imiz zaman bir s�r� i�lem se�ene�i ��kacak kar��m�za amac�m�za g�re her�eyi se�ebiliyoruz.Bunlardan begintransaction'� se�ip i�lemi ba�lataca��z.
		//�imdi hani dedik ya session'lar arka arkaya sorgular g�nderebilece�imiz yap�lard�r.O y�zden hani 2.de hata oldu�unda 1. vas�tas�yla 1.yi geri alabilmeliyiz.2. de hata oldu�unda bu noktada bizim bir kod yaz�yor olmam�z gerekir. 
		//�imdi bunu korumak i�in bir try-catch'in i�ine al�yoruz.
		//�ncelikle begintransaction diyerek i�leme ba�layaca��m� s�yl�yorum.
		try {
			session.beginTransaction();
			//sorgular�m�z� yazaca��m�z yer...
			//bu a�a��da yapt���m�z SQL sorgular�na hibernate ile yapt���m�zdan dolay� "HQL-Hibernate Query Language" deniyor.
			//select * from city ile ayn� �ey
			//KO�ULLU SORGULAR YAZMAK...
			//"from City c where c.countryCode='TUR' OR c.countryCode='USA'"                  ayn� t�rde sorgulama yaparken OR kullan�l�yor.AND kullan�lm�yor.
			//"from City c where c.countryCode='TUR' AND c.district='Ankara'"	              farkl� t�rde sorgulama yaparken AND kullan�l�yor.
			//"from City c where c.name LIKE '%kar%'"                                         kar% ba��nda, %kar% ortas�nda, %kar sonunda gibi �e�itleri var.
			//"from City c ORDER BY c.name"													  Alfabetik,az'dan �ok'a,yeniden eskiye,say�sal veya metinsel ifadelerde s�ralama yapmakta kullanabilirsiniz.
			//ASC-Ascending(Y�kselen)                                                         yazsan�zda yazmasan�da default olarak ASC olarak s�ralan�r.
			//DESC-Descending(Al�alan)
			//List<City> cities = session.createQuery("from City c ORDER BY c.name").getResultList();			//java.util.List aynen arraylist gibi kullanabilce�imiz bir koleksiyon.Fark� yok.�ua an hibernate'den dolay� bunu kulland�k.
			//evet,art�k elimizde cities de�eri var.Bunu art�k ben ne yapmak istersem altta kullanabilirim.
			
			//for(City city:cities) {                        //bakal�m d�nd�rebilecekmiyiz diye denedik.Ve �al��t�.��te hibernate kullanarak ilk sorgumuzu yapt�k.�imdi KO�ULLU SORGULAR YAZMAK dersine ge�iyoruz...
			//	System.out.println(city.getName());
			//}
			
			//GROUP BY-group(gruplamak),by(bi�eyle) 
			/*
			 * List<String> countryCodes =
			 * session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList(); for(String countryCode:countryCodes) { //bakal�m d�nd�rebilecekmiyiz diye denedik.Ve �al��t�.��te hibernate kullanarak ilk sorgumuzu yapt�k.�imdi KO�ULLU SORGULAR YAZMAK dersine ge�iyoruz...
			 * System.out.println(countryCode); }
			 */
			
			//INSERT i�lemi...
//			City city = new City();
//			city.setName("Mus");
//			city.setCountryCode("TUR");
//			city.setDistrict("DoguAnadolu");
//			city.setPopulation(250000);
//			
//			session.save(city);
//			session.save(city);                             //diyerek ikinci bir �ehir ekleyebiliriz.E�er ikinci kodda bir sorun olursa,ilk kodda iptal olacakt�r.��nk� transaction boyunca hepsinin ba�ar�l� olmas� �artt�r. G�nl�k hayattan bir �rnek olarak benim hesab�mda 100 lira para var ve 10tl k�z�ma g�nderiyorum.Benim hesab�mda 90tl kal�yor ama hata oluyor ve k�z�m�n hesab�na aktarm�yor.Bu noktada ikinci i�lem �al��mad���ndan ilk i�lemi de iptal edip param� iade ediyor.��te hibernate ve session bu i�e yar�yor arkada�lar.
			
			
			//UPDATE i�lemi...
			//City city = session.get(City.class, 4081);     //4081- id numaral� �ehir
			//city.setPopulation(14000000);
			
			//DELETE ��lemi... 
			City city = session.get(City.class, 4081);
			session.delete(city);
			
			session.getTransaction().commit();				//i�im bittikten sonra mevcut bu sessionun transaction'�n� commit et(veritaban�na bas) diyorum.��imiz bittikten sonra session'� kapatma i�lemini finally'de factory ile ger�ekle�tirmemiz gerekiyor. 
			System.out.println("�ehir silindi");
		}finally {											//normalde bir hata oldu�unda burada catch i�ine session.roll diye bir �ey ekleriz.Ama bir hata oldu�unda al�yor hibernate.O y�zden catch'i sildik. 
			factory.close();
		}
	}

}
