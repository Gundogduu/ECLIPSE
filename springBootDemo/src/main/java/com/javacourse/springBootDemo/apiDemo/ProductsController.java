package com.javacourse.springBootDemo.apiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController                    //@RestController-Restful API olabilmesi için
public class ProductsController {
	
// "/" bu ne demmek biliyormusunuz arkadaşlar?Yani bizim uygulama sunucumuzun anasayfası,ana istek noktasında bu ProductController'ın get()'i çalışacak demek. 	
//Yani biz hiç bir şey yapmasakda uygulamamızı çalıştırdığımızda bunun gelmesini bekliyorum.
	@GetMapping("/")              
	public String get() {                          //Restful json döndürüyordu ben string döndüreceğim,get operasyonu yazıyorum.
		return "Laptop";										//Yani ProductsController'da products/ürünleri listeliyor olacağım.	
		}
	
	@GetMapping("/products")                      //ilk başta çalışmadı.Çümkü önceki uygulamamız yayındaydı.Durdurup tekrar denedik,çalıştı.
	public String get2() {						  //şimdi kendini otomatik yenilesin diye pom.xml dosyasında,dependency'e yandakini ekleyeceğim (spring-boot-devtools)
		return "Laptop 7";
	}

}



//MVC- Module,View,Controller