package springIntro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//SPAGETTI CODE �LE...
//public class Main {

//	public static void main(String[] args) {
//		CustomerManager manager = new CustomerManager();
//		manager.add();
//i�te buraya kadar programc� "i�te ben de yapt�m oldu,yok interfacelermi� bilmem nelermi� u�ra�nad�m yapt�m oldu,b�yle de oluyor" diyor.
//Ama �imdi senaryoyu s�yl�yorum.Bu sadece veritaban� i�in de�il!Veri taban� olay� anlamak i�in kolay oldu�undan.�� kurallar�nda filan �ok kullan�yoruz bunu.	
//�imdi senaryoyu s�yl�yorum,biz sisteme MYSQL deste�ide getiriyoruz.Yani baz� m��terilerimiz oracle,baz�lar� mysql kulland��� i�in ikisini de desteklemesini istiyoruz.
//�imdi programc�n�n eli aya�� ba�land�...Ne yapacak? Mecburen CustomerDal'daki add() buraya bir tane Type ge�ecek ve iflerle i�i halletmeye �al��acak.Ve SPAGETTI kod dedi�imiz kod olu�acak.
//Peki ben bunu nas�l yazmal�y�m?
//
//		}

//}

//1.A�IKLAMA...
// IoC - Inversion Conltrol = ile Birbirinin alternatifi olan i�leri y�netiyorsunuz.
// Dependency Injection = Yap�y� aya�a kald�racak tasar�m deseni.

// IoC ile Birbirinin alternatifi olan operasyonlar� ayr� classlarda yaz�yorsunuz.Mesela ��yle d���n�n kredi ile ilgili bir kod yaz�yorsunuz.Birden fazla kredi t�rleri var ��retmen kredisi,��renci kredisi,Asker kredisi,Esnaf kredisi gibi...
//Her biri i�in ayr� ayr� ko�ullar var.E�er sen parametre olarak krediType ge�ersen; if kreditype buysa,if kreditype �uysa,if kreditype buysa durumu ortaya ��kar.
//Yaz�l�m geli�tirmemin en �nemli prensibleri olan SOLID yaz�l�m geli�tirme prensipleri(bunlar� ara�t�rabilirsiniz) O harfi open-close prensible der ki; yeni bir �zellik(bak�n yeni bir de�i�iklik demiyorum) ekledi�inde mevcuttaki hi� bir koda dokunamazs�n.
//E�er dokunursan b�y�k projelerde test edilebilirlikten tutun,o kodu y�netmek zorla��r.��te bu bak�mdan IoC ile biz birbirinin alternatifi olan operasyonlar� y�netiyoruz.
//�imdi olay� rahat anlamak i�in ben bir class ekliyor olaca��m...

//SPRING IoC �LE...
//public class Main {
    
	
 // public static void main(String[] args) {
		
		        //xml dosyas�ndan geldik ve bu noktada bizim xml'i okumam�z laz�m bunu a�a��daki kodla yap�yoruz...
				//newledi�imizde alt�n� �izdi nedeni uygulamay� ilk a�t���m�zda module.info.java eklenmesi se�ili kalm��.Bunu siliyoruz arkada�lar buna ihityac�m�z yok �uan, mod�llerle �al��may� bilmiyoruz hen�z bu noktada d�zelecektir.
				//Evet �imdi buraya kadar s�recimiz tamam.Biz ne yapt�k? applicationcontext.xml'i okuyaca��m�z� s�yledik.
				//---1 Peki benim burada neye ihtiyac�m var alttaki CustomerManager class�n�n new'indeki parametre yerinde bir nesneye ihtiyac�m var.Yani buras� oracle veya mysql olabilir.��nk� buradaki manager bir ICustomerDal nesnesi istiyor,onlar� tutabilir.
				//---2 i�te ben bu de�eri context'den okumak istiyorum.O da ��yle oluyor arkada�lar...
		
//		ClassPathXmlApplicationContext context =
//				new ClassPathXmlApplicationContext("applicationContext.xml");
																										  // ---1 yukarda bahsetti�imiz yer. ---2,
//		CustomerManager manager = new CustomerManager(context.getBean("database",ICustomerDal.class));    //diyerek Icustomerdal tipindeki database nesnesini istiyoruz.Bak�yoruz database nesnesine bize ne verecek? bize mysqlcustomerdal verecek yani onu newleyip verecek.Arka planda bizim yerimize newliyor yani.
//		manager.add();                                                                                    //D�KKAT! xml dosyas�n� src i�ine de�ilde springIntro i�ine olu�turdu�umdan hata f�rlatt� �al��t�rmad�,d�zelttim.
//	}
//}//---1 Asl�nda bu kod da �uan do�ru de�il.Zamanla ��reneceksiniz bunlar�.Benim �uan amac�m CustomerManager'� de�i�tirilebilir,s�rd�r�lebilir bir yaz�l�m ortam�na ta��mak olacak. ��yle d���n�n sizin onlarca yerde CustomerManager� �a��rman�z laz�m.
 //Hepsinde newled�inizi d���n�n oracle'�.Mesela 100 yerde kuland�n�z.Sonra mysql'e ge�iyorsunuz ve o 100 yeri de�i�tirmeniz gerekecek.Performans a��s�ndan da s�k�nt�l�.100 yerde 100 tane new yap�l�r arkada�lar.
 //Aam burada, olu�turdu�umuz nesne tek bir nesne olu�turuyor bellekte isteyene onu veriyor.Sonu�ta bunun i�erisinde field,data yok.Operasyon ta��yoruz biz.Yani ekle,sil,g�ncelle...
//EVET,Spring'in ilk implementasyonunu yazm�� olduk.�imdi altta "Constructor Arg ile �� ��e Ba��ml�l�k ��z�m�" dersine ge�iyoruz...

//CONSTRUCTOR ARG �LE �� ��E BA�IMLILIK ��Z�M�
//�imdi �stteki �rne�imizi daha da profesyonelle�tirmek istiyorum.��yle ki; CustomerManager class�da i� class'� biz Interface ile onu da beslemeliyiz arkada�lar.
//�imdi arkada�lar bunlar� size yava� yava� s�yl�yor olaca��m fakat bir class�n�z herhangi bir implements veya extends g�rm�yorsa anlay�n ki ilerde ba��ml�l�k problemleri ya�ayacak uygulaman�z.��plak class kalmayacak arkada�lar.Bir yerlerden implement veya extend etmesi gerekir.E�er ��plaksa anlay�n ki ba��ml�l�k durumu var.

public class Main {
    
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICustomerService customerService = context.getBean("service",ICustomerService.class);   
		customerService.add();                                                                                   
	}
}




//DEPENDENCY INJECTION �LE...	
//	public static void main(String[] args) {
//		CustomerManager manager = new CustomerManager(new MySQLCustomerDal());  //sadece parametreyi de�i�tirmemiz yeterli.
//		manager.add();

//		}

//}

//new CustomerManager(new MySQLCustomerDal()); SPRING bizim i�in buray� halledecek...
