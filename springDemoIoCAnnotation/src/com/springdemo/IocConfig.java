package com.springdemo;
//CLASS CONFIG ÝÇÝNDE BEAN TANIMLAMAK
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration                               
@ComponentScan("com.springdemo")
@PropertySource("classpath:values.properties")                      //Property injection için Annotation
public class IocConfig {
	@Bean                                      //database isimli bean annotation'una sahip metod ekledik.
	public ICustomerDal database() {
		return new MySqlCustomerDal();         //database'i deðiþtirmek için sadece burayý deðiþtiriyoruz.
	}
	//xml'den yapacaðýmýz iþlemleri,tamamen xml den kopuk bir þekilde, o zorlu xml yapýsýyla uðraþmak yerine kendi java bilgim ile IocConfig (ne isim verirseniz verin tabii)dosyamý kolayca kodladým
	//ve main'de bir database istedim.Onu da IocConfig'den istiyorum.Dolayýsýyla orada database isimli dosyayý bir güzel eklemiþ olduk,yani mysqlcustomerdal'ý þu an için eklemiþ olduk arkadaþlar...SON.
	
	
	//BAÐLI CLASSLARIN ÇÖZÜMLENMESÝ
	@Bean
	public ICustomerService service() {
		return new CustomerManager(database());   //ne döndürsün? CustomerManager,fakat burada altýný çizdi. Çünkü CustomerManager'ýn constructor'ýnda CustomerDal istiyor.O yüzden buraya (new MySqlCustomerDal()) diyebiliriz direkt ama doðru bir kod olmaz.Onun yerine yukardaki database'i buraya da geçiyorum.
		//böylece gelmek istediðimiz nokta burasý. Artýk böyle classlarla çalýþarak daha temiz,o xml configration'unun zorluklarýndan bu þekilde kurtuluyoruz arkadaþlar.SON.
	}



}



//Property injection için buraya @PropertySource ve customerDal nesnesine özelliðin/attribute'ün üzerine gelip @Value annotation'ýný yazmamýz ve deðerini okutmamýz yeterli(yani values.properties'in içindeki database.connetionString'ini). 
//Kýsacasý ilk adým: values.properties'imiz var.
//Sonrasýnda config dosyasýnda onu belirtiyorum.
//en son ilgili property'e gidiyoruz.O value'yu nerede okuyacaðýný söylüyoruz.SON