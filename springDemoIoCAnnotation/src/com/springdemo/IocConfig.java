package com.springdemo;
//CLASS CONFIG ���NDE BEAN TANIMLAMAK
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration                               
@ComponentScan("com.springdemo")
@PropertySource("classpath:values.properties")                      //Property injection i�in Annotation
public class IocConfig {
	@Bean                                      //database isimli bean annotation'una sahip metod ekledik.
	public ICustomerDal database() {
		return new MySqlCustomerDal();         //database'i de�i�tirmek i�in sadece buray� de�i�tiriyoruz.
	}
	//xml'den yapaca��m�z i�lemleri,tamamen xml den kopuk bir �ekilde, o zorlu xml yap�s�yla u�ra�mak yerine kendi java bilgim ile IocConfig (ne isim verirseniz verin tabii)dosyam� kolayca kodlad�m
	//ve main'de bir database istedim.Onu da IocConfig'den istiyorum.Dolay�s�yla orada database isimli dosyay� bir g�zel eklemi� olduk,yani mysqlcustomerdal'� �u an i�in eklemi� olduk arkada�lar...SON.
	
	
	//BA�LI CLASSLARIN ��Z�MLENMES�
	@Bean
	public ICustomerService service() {
		return new CustomerManager(database());   //ne d�nd�rs�n? CustomerManager,fakat burada alt�n� �izdi. ��nk� CustomerManager'�n constructor'�nda CustomerDal istiyor.O y�zden buraya (new MySqlCustomerDal()) diyebiliriz direkt ama do�ru bir kod olmaz.Onun yerine yukardaki database'i buraya da ge�iyorum.
		//b�ylece gelmek istedi�imiz nokta buras�. Art�k b�yle classlarla �al��arak daha temiz,o xml configration'unun zorluklar�ndan bu �ekilde kurtuluyoruz arkada�lar.SON.
	}



}



//Property injection i�in buraya @PropertySource ve customerDal nesnesine �zelli�in/attribute'�n �zerine gelip @Value annotation'�n� yazmam�z ve de�erini okutmam�z yeterli(yani values.properties'in i�indeki database.connetionString'ini). 
//K�sacas� ilk ad�m: values.properties'imiz var.
//Sonras�nda config dosyas�nda onu belirtiyorum.
//en son ilgili property'e gidiyoruz.O value'yu nerede okuyaca��n� s�yl�yoruz.SON