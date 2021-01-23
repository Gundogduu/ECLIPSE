package springIntro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//SPAGETTI CODE ÝLE...
//public class Main {

//	public static void main(String[] args) {
//		CustomerManager manager = new CustomerManager();
//		manager.add();
//iþte buraya kadar programcý "iþte ben de yaptým oldu,yok interfacelermiþ bilmem nelermiþ uðraþnadým yaptým oldu,böyle de oluyor" diyor.
//Ama þimdi senaryoyu söylüyorum.Bu sadece veritabaný için deðil!Veri tabaný olayý anlamak için kolay olduðundan.Ýþ kurallarýnda filan çok kullanýyoruz bunu.	
//Þimdi senaryoyu söylüyorum,biz sisteme MYSQL desteðide getiriyoruz.Yani bazý müþterilerimiz oracle,bazýlarý mysql kullandýðý için ikisini de desteklemesini istiyoruz.
//Þimdi programcýnýn eli ayaðý baðlandý...Ne yapacak? Mecburen CustomerDal'daki add() buraya bir tane Type geçecek ve iflerle iþi halletmeye çalýþacak.Ve SPAGETTI kod dediðimiz kod oluþacak.
//Peki ben bunu nasýl yazmalýyým?
//
//		}

//}

//1.AÇIKLAMA...
// IoC - Inversion Conltrol = ile Birbirinin alternatifi olan iþleri yönetiyorsunuz.
// Dependency Injection = Yapýyý ayaða kaldýracak tasarým deseni.

// IoC ile Birbirinin alternatifi olan operasyonlarý ayrý classlarda yazýyorsunuz.Mesela þöyle düþünün kredi ile ilgili bir kod yazýyorsunuz.Birden fazla kredi türleri var Öðretmen kredisi,Öðrenci kredisi,Asker kredisi,Esnaf kredisi gibi...
//Her biri için ayrý ayrý koþullar var.Eðer sen parametre olarak krediType geçersen; if kreditype buysa,if kreditype þuysa,if kreditype buysa durumu ortaya çýkar.
//Yazýlým geliþtirmemin en önemli prensibleri olan SOLID yazýlým geliþtirme prensipleri(bunlarý araþtýrabilirsiniz) O harfi open-close prensible der ki; yeni bir özellik(bakýn yeni bir deðiþiklik demiyorum) eklediðinde mevcuttaki hiç bir koda dokunamazsýn.
//Eðer dokunursan büyük projelerde test edilebilirlikten tutun,o kodu yönetmek zorlaþýr.Ýþte bu bakýmdan IoC ile biz birbirinin alternatifi olan operasyonlarý yönetiyoruz.
//Þimdi olayý rahat anlamak için ben bir class ekliyor olacaðým...

//SPRING IoC ÝLE...
//public class Main {
    
	
 // public static void main(String[] args) {
		
		        //xml dosyasýndan geldik ve bu noktada bizim xml'i okumamýz lazým bunu aþaðýdaki kodla yapýyoruz...
				//newlediðimizde altýný çizdi nedeni uygulamayý ilk açtýðýmýzda module.info.java eklenmesi seçili kalmýþ.Bunu siliyoruz arkadaþlar buna ihityacýmýz yok þuan, modüllerle çalýþmayý bilmiyoruz henüz bu noktada düzelecektir.
				//Evet þimdi buraya kadar sürecimiz tamam.Biz ne yaptýk? applicationcontext.xml'i okuyacaðýmýzý söyledik.
				//---1 Peki benim burada neye ihtiyacým var alttaki CustomerManager classýnýn new'indeki parametre yerinde bir nesneye ihtiyacým var.Yani burasý oracle veya mysql olabilir.Çünkü buradaki manager bir ICustomerDal nesnesi istiyor,onlarý tutabilir.
				//---2 iþte ben bu deðeri context'den okumak istiyorum.O da þöyle oluyor arkadaþlar...
		
//		ClassPathXmlApplicationContext context =
//				new ClassPathXmlApplicationContext("applicationContext.xml");
																										  // ---1 yukarda bahsettiðimiz yer. ---2,
//		CustomerManager manager = new CustomerManager(context.getBean("database",ICustomerDal.class));    //diyerek Icustomerdal tipindeki database nesnesini istiyoruz.Bakýyoruz database nesnesine bize ne verecek? bize mysqlcustomerdal verecek yani onu newleyip verecek.Arka planda bizim yerimize newliyor yani.
//		manager.add();                                                                                    //DÝKKAT! xml dosyasýný src içine deðilde springIntro içine oluþturduðumdan hata fýrlattý çalýþtýrmadý,düzelttim.
//	}
//}//---1 Aslýnda bu kod da þuan doðru deðil.Zamanla öðreneceksiniz bunlarý.Benim þuan amacým CustomerManager'ý deðiþtirilebilir,sürdürülebilir bir yazýlým ortamýna taþýmak olacak. Þöyle düþünün sizin onlarca yerde CustomerManagerý çaðýrmanýz lazým.
 //Hepsinde newledðinizi düþünün oracle'ý.Mesela 100 yerde kulandýnýz.Sonra mysql'e geçiyorsunuz ve o 100 yeri deðiþtirmeniz gerekecek.Performans açýsýndan da sýkýntýlý.100 yerde 100 tane new yapýlýr arkadaþlar.
 //Aam burada, oluþturduðumuz nesne tek bir nesne oluþturuyor bellekte isteyene onu veriyor.Sonuçta bunun içerisinde field,data yok.Operasyon taþýyoruz biz.Yani ekle,sil,güncelle...
//EVET,Spring'in ilk implementasyonunu yazmýþ olduk.Þimdi altta "Constructor Arg ile Ýç Ýçe Baðýmlýlýk Çözümü" dersine geçiyoruz...

//CONSTRUCTOR ARG ÝLE ÝÇ ÝÇE BAÐIMLILIK ÇÖZÜMÜ
//Þimdi üstteki örneðimizi daha da profesyonelleþtirmek istiyorum.Þöyle ki; CustomerManager classýda iþ class'ý biz Interface ile onu da beslemeliyiz arkadaþlar.
//Þimdi arkadaþlar bunlarý size yavaþ yavaþ söylüyor olacaðým fakat bir classýnýz herhangi bir implements veya extends görmüyorsa anlayýn ki ilerde baðýmlýlýk problemleri yaþayacak uygulamanýz.Çýplak class kalmayacak arkadaþlar.Bir yerlerden implement veya extend etmesi gerekir.Eðer çýplaksa anlayýn ki baðýmlýlýk durumu var.

public class Main {
    
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICustomerService customerService = context.getBean("service",ICustomerService.class);   
		customerService.add();                                                                                   
	}
}




//DEPENDENCY INJECTION ÝLE...	
//	public static void main(String[] args) {
//		CustomerManager manager = new CustomerManager(new MySQLCustomerDal());  //sadece parametreyi deðiþtirmemiz yeterli.
//		manager.add();

//		}

//}

//new CustomerManager(new MySQLCustomerDal()); SPRING bizim için burayý halledecek...
