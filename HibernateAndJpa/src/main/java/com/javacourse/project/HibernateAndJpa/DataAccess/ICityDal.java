package com.javacourse.project.HibernateAndJpa.DataAccess;



import java.util.List;                      //List için

import com.javacourse.project.HibernateAndJpa.Entities.City;       //City için

public interface ICityDal {
	List<City> getAll();                    //CityControler'da farkettik eğer () buraya parametre yazarsak parametre gerekiyor ve o parametreye göre çalışıyor.
	void add(City city);                    //aslında eğitimin başından beri parametreli kullanıyoruz ama daha yeni tam anlamını öğrendim!...
	void update(City city);
	void delete(City city);
	City getById(int id);                  //bir adet city döndüren getById oluşturuyoruz ve HibernateCityDal'a gidiyoruz.


}


//Evet,Artık temel Interface'imizi hazır arkadaşlar...>>>İlk Hibernate,JPA ve AOP implementasyonu dersine geçiyoruz.
//Şimdi bizim bu Interface'i Hibernate kodunu kullanarak doldurmamız lazım.Bu noktada DataAccess paketi içinde bir CityDal adında class oluşturuyoruz.
//Fakat başına hangi teknolojiyi kullanıyorsak onu yazıyoruz,HibernateCityDal.