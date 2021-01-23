package com.javacourse.project.HibernateAndJpa.Business;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.HibernateAndJpa.DataAccess.ICityDal;
import com.javacourse.project.HibernateAndJpa.Entities.City;
@Service                      //İş katmanı olduğunu belirtmek için.
public class CityManager implements ICityService{

	
	private ICityDal cityDal;      //DataAccess'den hizmet alacak bu hizmeti hiçbir zaman somut,yani class'larla iletişim kurdurmayacağız.Interface'lerden iletişim kurmamız grekiyor.
	
	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}
	//Business kodları - bizim burada yaptığımız işlem sadece veri erişimi çağırmaktan ibaret değil arkadaşlar!
	//Örneğin biz burada şöyle kontroller yapabiliriz; şehir eklenecek ama daha önce veri tabanında böyle bir şehir eklenmemiş olması lazım.
	//Veya şehir gönderilecek ama şu kurallar geçerli olacak...Yani burada Business dediğimiz iş kuralları yazılır.
	//O yüzden burada çeşitli kodların da olabileceğini düşünmemiz gerekir.Bu kurallarda iş gereksinimine göre yazılır.
	@Override
	@Transactional                      //Diyeceksiniz ki hocam niye buraya da koyduk?Zaten DataAccess'te vardı.Şöyle ki siz DataAccesste,DataAccess için yapıyorsunuz.
	public List<City> getAll() {          //Yani Business'ın Transactional'ını orada kastediyoruz bunu unutmayın!
		return this.cityDal.getAll();   //Bakın şu an ben Hibernate'e bağımlı değilim.Hibernate kodu yazmıyorum.Sadece Interface'i verdim.@Autowired,sadece Hibernate olduğundan bizim için bu çözümlemeyi gerçekleştiriyor olacak arkadaşlar...>>>Rest API'nin yazılması ve yayınlanması'dersine geçiyoruz....
	}
	@Override
	@Transactional
	public void add(City city) {                
		this.cityDal.add(city);				//this.add(city); deyince de hata vermedi
		
	}
	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
	}
	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}
	@Override
	@Transactional
	public City getById(int id) {
		this.cityDal.getById(id);
		return this.cityDal.getById(id);
	}
//Artık burayı da yazdıktan sonra CityController'ımıza gidip gerekli operasyonları yazzabiliriz...
}

