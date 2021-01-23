//Veritabanı nesnelerini ben genellikle Entity katmanına koyarım.Genellikle de böyle yapılır.
//Şimdi bizim bu class'a sen bir veritabanı tablosusun dememiz gerekiyordu.Bunu da nasıl yapıyorduk?
//Tablonun üzerine gelerek yani City'nin üzerine gelerek bir Annotation veriyorduk.@Table() annotation'ı.


package com.javacourse.project.HibernateAndJpa.Entities;

import javax.persistence.*;      //IDE @Table annotation'ının importunu getirmedi.Biz elle yazdık yine görmedi.
									  //Bu yüzden pom.xml'e gidip dependency'e (spring-boot-starter-data-jpa) yı eklememiz gerekiyor.
@Entity                          //Veritabanı nesnesi olduğunu belirtmek için @Entity annotation'ını ekliyoruz buraya.
@Table(name="city")
public class City {
	//son olarak kolonları annotation ile tanımlamamız gerekiyor.
	@Id
	@Column(name="ID")                 //neye karşılık gelecekse onun adını yazıyoruz.
	@GeneratedValue(strategy=GenerationType.IDENTITY)        //ID alanının otomatik artacağına yönelik bir strateji belirliyoruz IDENTITY ile. Farklı veritanalarında örneğin Oracle'da SEQUENCE i seçmemiz gerekiyor.
	private int id;											 //Evet.Entity'miz hazır arkadaşlar.SON! ----Spring Boot: Katmanlı Mimariler--- dersine başlıyoruz.
	
	@Column(name="name")
	private String name;
	
	@Column(name="countrycode")                              //isimlendirme standardı yüzünden burayı null deyip okuyamıyordu.Küçük harf ile yazmamız gerekiyormuş burada.
	private String countryCode;
	
	@Column(name="district")
	private String district;
	
	@Column(name="population")
	private int population;
	
	public City() {}         //Hoca Hibernate için defaut,parametresiz constructor eklemeyi unutmuştu hata üzerine gelip ekledik.
	
	
	public City(int id, String name, String countryCode, String district, int population) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
}
