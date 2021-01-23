package com.hibernatedemo;

import javax.persistence.*;         	//burada hibernate.annotation'ý seçmedik,javax.persistence'ý seçtik çünkü hibernate,javax.persistence dediðimiz bir "javax.persistace.api" denilen altyapýsýyla geliyor ve hibernate tamamen bunun implementasyonunu yapýyor.
											//þu an da resimi olarak da hibernate javax.persistence'ýn kullanýlmasýný öneriyor.
//ilk veritabaný nesnemizi yapalým...

@Entity                   //Entity-vertabaný nesnesi demekti.Bu annotation'la City nesnemizi bir veritabaný nesnesi yaptýk.Peki bu veritabaný nesnesi hangi tablonun üyesidir?Hangi tabloya karþýlýk gelecek?
@Table(name= "city")		//tabloyu belirledik.Peki diðer alanlarý ne yapacaðýz?E bir de bizim kolonlarýmýz var.Onlarý da set'ediyor olmamýz gerekiyor.Onlarý da baðlamamýz lazým.
							//Bu noktada bir id annotation'ýnýmýz var.
public class City {
	@Id                              //veritabanýndaki id karþýlýðý yani o datayý diðerlerinden ayýracak alan anlamýna gelir.
	@Column(name= "ID")              //kolon ismi - bu isimleri vermezseniz sorun olmaz.Bu isimde veritabanýnda arar.Ama siz yine de verin!
	private int id;
	
	@Column(name= "Name")
	private String name;
	
	@Column(name="CountryCode")
	private String countryCode;
	
	@Column(name="District")
	private String district;
	
	@Column(name="Population")
	private int population;
	//iþte biz bu þekilde city nesnesini veritabanýndaki city tablosuyla map etmiþ(baðlamýþ) olduk.SON.
	
	
	//okuyabilmek ve düzenleyebilmek için getter/setter yapýyoruz sanýrým.
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
