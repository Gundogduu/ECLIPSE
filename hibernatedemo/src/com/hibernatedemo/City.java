package com.hibernatedemo;

import javax.persistence.*;         	//burada hibernate.annotation'� se�medik,javax.persistence'� se�tik ��nk� hibernate,javax.persistence dedi�imiz bir "javax.persistace.api" denilen altyap�s�yla geliyor ve hibernate tamamen bunun implementasyonunu yap�yor.
											//�u an da resimi olarak da hibernate javax.persistence'�n kullan�lmas�n� �neriyor.
//ilk veritaban� nesnemizi yapal�m...

@Entity                   //Entity-vertaban� nesnesi demekti.Bu annotation'la City nesnemizi bir veritaban� nesnesi yapt�k.Peki bu veritaban� nesnesi hangi tablonun �yesidir?Hangi tabloya kar��l�k gelecek?
@Table(name= "city")		//tabloyu belirledik.Peki di�er alanlar� ne yapaca��z?E bir de bizim kolonlar�m�z var.Onlar� da set'ediyor olmam�z gerekiyor.Onlar� da ba�lamam�z laz�m.
							//Bu noktada bir id annotation'�n�m�z var.
public class City {
	@Id                              //veritaban�ndaki id kar��l��� yani o datay� di�erlerinden ay�racak alan anlam�na gelir.
	@Column(name= "ID")              //kolon ismi - bu isimleri vermezseniz sorun olmaz.Bu isimde veritaban�nda arar.Ama siz yine de verin!
	private int id;
	
	@Column(name= "Name")
	private String name;
	
	@Column(name="CountryCode")
	private String countryCode;
	
	@Column(name="District")
	private String district;
	
	@Column(name="Population")
	private int population;
	//i�te biz bu �ekilde city nesnesini veritaban�ndaki city tablosuyla map etmi�(ba�lam��) olduk.SON.
	
	
	//okuyabilmek ve d�zenleyebilmek i�in getter/setter yap�yoruz san�r�m.
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
