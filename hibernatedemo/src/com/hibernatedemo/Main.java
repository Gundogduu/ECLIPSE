package com.hibernatedemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//HAYDÝ GELÝN ÝLK SORGUMUZU YAZALIM... 
//Bunun için bize bir Session lazým.Peki Session mimarisini ne ile oluþturuyoruz? Bir SessionFactory-Oturum fabrikasý ile.
//SessionFactory uygulamalarda bir kez oluþturulmasý gereken bir fabrikadýr.
public class Main {

	public static void main(String[] args) {
		//burada mainde yaptýk her seferinde main çalýþýnca bu da çalýþacak ama web uygulamalarýnda nasýl yapýldýðýný göreceðiz þimdi takýlmayýn buna.
		//bu noktada bir konfigrasyon oluþturacaðýz.Bakýn bunu ilk kez görüyorsunuz; (bir þeyi new'lediðiniz zaman o þeyin metodlarý gelir)
		//new Configuration().configure() deyip konfigrasyon dosyamýzýn hangisi olduðunu söylüyoruz.
		//Uygulamalarda SessionFactory bir yere yazýlýr, ilk açýlýþta çalýþtýrýlýr ve o kullanýlýr arkadaþlar.
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")			//configure de bir class döndürüyor(addAnnotatedClass).
				.addAnnotatedClass(City.class)   		//ile istediðim herhangi bir class'ý (City.class) buraya verebilirim.Bunu daha sonra tüm nesneler için yapýyor olacaðýz.
				.buildSessionFactory();    				//dediðimiz anda artýk fabrikamýz oluþtu.
		
		//Þimdi fabrikadan bir oturum almamýz lazým.Çünkü sorgu yollayacaðým.
		//Unit of Word-Session'ýn tasarým desenidir.Unit of Word'ün uygulanmýþ halidir.
		Session session = factory.getCurrentSession();
		
		//artýk biz bu session'ý kullanarak veritabanýna sorgu gönderebiliyor olacaðýz.
		
		//session. dediðimiz zaman bir sürü iþlem seçeneði çýkacak karþýmýza amacýmýza göre herþeyi seçebiliyoruz.Bunlardan begintransaction'ý seçip iþlemi baþlatacaðýz.
		//þimdi hani dedik ya session'lar arka arkaya sorgular gönderebileceðimiz yapýlardýr.O yüzden hani 2.de hata olduðunda 1. vasýtasýyla 1.yi geri alabilmeliyiz.2. de hata olduðunda bu noktada bizim bir kod yazýyor olmamýz gerekir. 
		//þimdi bunu korumak için bir try-catch'in içine alýyoruz.
		//öncelikle begintransaction diyerek iþleme baþlayacaðýmý söylüyorum.
		try {
			session.beginTransaction();
			//sorgularýmýzý yazacaðýmýz yer...
			//bu aþaðýda yaptýðýmýz SQL sorgularýna hibernate ile yaptýðýmýzdan dolayý "HQL-Hibernate Query Language" deniyor.
			//select * from city ile ayný þey
			//KOÞULLU SORGULAR YAZMAK...
			//"from City c where c.countryCode='TUR' OR c.countryCode='USA'"                  ayný türde sorgulama yaparken OR kullanýlýyor.AND kullanýlmýyor.
			//"from City c where c.countryCode='TUR' AND c.district='Ankara'"	              farklý türde sorgulama yaparken AND kullanýlýyor.
			//"from City c where c.name LIKE '%kar%'"                                         kar% baþýnda, %kar% ortasýnda, %kar sonunda gibi çeþitleri var.
			//"from City c ORDER BY c.name"													  Alfabetik,az'dan çok'a,yeniden eskiye,sayýsal veya metinsel ifadelerde sýralama yapmakta kullanabilirsiniz.
			//ASC-Ascending(Yükselen)                                                         yazsanýzda yazmasanýda default olarak ASC olarak sýralanýr.
			//DESC-Descending(Alçalan)
			//List<City> cities = session.createQuery("from City c ORDER BY c.name").getResultList();			//java.util.List aynen arraylist gibi kullanabilceðimiz bir koleksiyon.Farký yok.Þua an hibernate'den dolayý bunu kullandýk.
			//evet,artýk elimizde cities deðeri var.Bunu artýk ben ne yapmak istersem altta kullanabilirim.
			
			//for(City city:cities) {                        //bakalým döndürebilecekmiyiz diye denedik.Ve çalýþtý.Ýþte hibernate kullanarak ilk sorgumuzu yaptýk.Þimdi KOÞULLU SORGULAR YAZMAK dersine geçiyoruz...
			//	System.out.println(city.getName());
			//}
			
			//GROUP BY-group(gruplamak),by(biþeyle) 
			/*
			 * List<String> countryCodes =
			 * session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList(); for(String countryCode:countryCodes) { //bakalým döndürebilecekmiyiz diye denedik.Ve çalýþtý.Ýþte hibernate kullanarak ilk sorgumuzu yaptýk.Þimdi KOÞULLU SORGULAR YAZMAK dersine geçiyoruz...
			 * System.out.println(countryCode); }
			 */
			
			//INSERT iþlemi...
//			City city = new City();
//			city.setName("Mus");
//			city.setCountryCode("TUR");
//			city.setDistrict("DoguAnadolu");
//			city.setPopulation(250000);
//			
//			session.save(city);
//			session.save(city);                             //diyerek ikinci bir þehir ekleyebiliriz.Eðer ikinci kodda bir sorun olursa,ilk kodda iptal olacaktýr.Çünkü transaction boyunca hepsinin baþarýlý olmasý þarttýr. Günlük hayattan bir örnek olarak benim hesabýmda 100 lira para var ve 10tl kýzýma gönderiyorum.Benim hesabýmda 90tl kalýyor ama hata oluyor ve kýzýmýn hesabýna aktarmýyor.Bu noktada ikinci iþlem çalýþmadýðýndan ilk iþlemi de iptal edip paramý iade ediyor.Ýþte hibernate ve session bu iþe yarýyor arkadaþlar.
			
			
			//UPDATE iþlemi...
			//City city = session.get(City.class, 4081);     //4081- id numaralý þehir
			//city.setPopulation(14000000);
			
			//DELETE Ýþlemi... 
			City city = session.get(City.class, 4081);
			session.delete(city);
			
			session.getTransaction().commit();				//iþim bittikten sonra mevcut bu sessionun transaction'ýný commit et(veritabanýna bas) diyorum.Ýþimiz bittikten sonra session'ý kapatma iþlemini finally'de factory ile gerçekleþtirmemiz gerekiyor. 
			System.out.println("Þehir silindi");
		}finally {											//normalde bir hata olduðunda burada catch içine session.roll diye bir þey ekleriz.Ama bir hata olduðunda alýyor hibernate.O yüzden catch'i sildik. 
			factory.close();
		}
	}

}
