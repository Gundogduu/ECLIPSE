package com.javacourse.project.HibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.HibernateAndJpa.Entities.City;
@Repository             //hata üzerine ekledik.Normalde kendisi bulması gerekiyordu.Ama yarın öbür gün sen Hibernate yerine başka bir şey kullanırsan buradan silip oraya yazmalısın.
public class HibernateCityDal implements ICityDal{      //classı oluşturduktan sonra İnterface'e bağlayıp metodları implement ediyoruz.
														//Şimdi sıra geldi Hibernate'e.Hibernate'te hatırlayın bir SessionFactory ve bir Session açıyorduk.İşte bu noktada bir standart devreye giriyor,JPA. 
	
	private EntityManager entityManager;
	
	@Autowired                                         //Hibernate için SessionFactory'yi enjekte edecek
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	//READ-GET...
	//AOP-Aspect Oriented Programming 
	@Transactional								//bizim yerimize operasyonun başında ve sonunda Transaction açıyor ve kapatıyor. 
	@Override
	public List<City> getAll() {               
		Session session = entityManager.unwrap(Session.class);                           //JPA ya bana Hibernate session'ı ver diyoruz.JPA bizim için Hibernate ile ilgili gerekli olan tüm enjeksiyonları gerçekleştiriyor.
		List<City> cities = session.createQuery("from City",City.class).getResultList();   //Artık session'ımıza sahibiz.Şu an yapmamız gereken query/sorgu yazacağız."from City" yi hangi tipe map edecek>>(City.class) ve getResultList() diyerek sonuçları listele diyoruz. 
		return cities;
		//Artık getAll() operasyonunu çağırdığı zaman birisi, bütün şehirleri listeleyebilecek...

	}  
	//ADD...
	@Override
	public void add(City city) {
		//if()
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);                            //daha önce save'i kullanmıştık.Onun dışında bir de saveOrUpdate'de var.Bu da kullanılabilir.Bunun farkı; city'mize bir ID vermezsek onu ekleyecektir.Yani bu veritabanında olmayan bir kayıt.Ama ID verirsek onu güncelleyecektir.
	}														//Burada olay aslında session nesnesine gönderilen city nesnesinin ID'sinin olup olmaması.Neden tek operasyon yapmıyorum?Çünkü aslında programcı eklemek istiyor,fakat o ID'sini sıfır göndermek yerine,ID'yi görünce bir şekilde yanlışlıkla ID'yi veriyor.
															//O yüzden add'i güvenli bir şekilde bir kontrol yapabilirsiniz.Yani yeni bir kayıt olması için atıyorum bir if koduyla,eğer ID sıfırdan farklı olmasını kontrol edebilirsiniz size kalmış.
	//UPDATE...
	@Override
	public void update(City city) {
		Session session = entityManager.unwrap(Session.class);          //add operasyonuyla aynı yöntemle ekleniyor.Sadece 
		session.saveOrUpdate(city);
		
	}
	//DELETE...
	@Override
	public void delete(City city) {        
		Session session = entityManager.unwrap(Session.class);
		session.delete(city);
		
	}
	@Override
	public City getById(int id) {                                        //Bir adet city döndürmek için                     
			Session session = entityManager.unwrap(Session.class);
			
			City city = session.get(City.class,id);                   //bir city değişkeni oluşturup onu da sessiondan alıyorum arkadaşlar.Session.get() operasyonuyla bu işi yapabiliriz.Peki hangi tipte istiyorum,yani hangi tipe map etsin?
			return city;                                             //City nesnesine.Ve tabi bizim id'mizi göndererek bu işi yapıyor olacağız.Tabiki bu noktada bizim bir return'e de ihtiyacımız var.Bulduğumuz şehri bu şekilde geri döndürüyor olacağağız bu şekilde.
			
	}
}
//Evet artık tüm operasyonlarımız hazır arkadaşlar.Bizim artık ne yapmamız gerekiyor?Bu operasyonları diğer katmanlarda da Business katmanında da,Restapi katmanında da bunları yazıyor olmamız gerekiyor.
