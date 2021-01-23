package com.javacourse.project.HibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.HibernateAndJpa.Business.ICityService;

import com.javacourse.project.HibernateAndJpa.Entities.*;

@RestController
@RequestMapping("/api")
public class CityController {
	
	private ICityService cityService;
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")						   //Get operasyonu-Ben veritabanında değişklik yapmak istemiyorum.Bana data ver demek.
	public List<City> get(){                       //burada bir liste oluşturmak istiyorum.
		return cityService.getAll();				//cityService'den getAll operasyonunu döndürttük.
	}
	
	@PostMapping("/add")                                //Post operasyonu -gönderme durumu söz konusu
	public void add(@RequestBody City city) {
		cityService.add(city);                          //buraya yine this.cityService şekilinde de yazabilirsiniz ikiside olur.
	}
	
	@PostMapping("/update")
	public void update(@RequestBody City city) {		//PostMapping'lerde buradaki parametreyi nereden alacağız?Yapılan isteğin body'sinden.Dolayısıyla buna @RequestBody diye bir annotation ekliyoruz.
		cityService.update(city);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}	
	//Yukarıda tüm şehirleri getirdiğimizde parametre yazmamıştık fakat getById'de cities'e bir parametre yazmamız gerekiyor.
	//Mesela /cities/1 gibi, ama bu dinamiktir arkadaşlar.O yüzden biz bir city {id} göndermemiz lazım.İşte ben bir parametre istiyorum demek oluyor bu noktada.
	//Peki bu id yi bu noktada nasıl okuyacağız? Olay çok net arkadaşlar zaten bizim getById() de bir parametreye ihtiyacımız var.
	@GetMapping("/cities/{id}")                              //Peki bunu nereden alacak? "/{id}" den.Yani bu Restful api'mizin yolu.Bunun için de bir Annotation var.İsmi @PathVariable.      
	 public City getById(@PathVariable int id) {             //
		return cityService.getById(id);
	}
	

//Biz artık bütün operasyonlarımızı çağırabilecek durumdayız...
}

//GET operasyonlarını tarayıcıdan deneyebiliyoruz.Fakat (Insert,Update,Delete)POST operasyonlarını tarayıcıdan deneme imkanımız yok
//POST operasyonlarını POSTMAN adlı sitede deneyebiliriz.




