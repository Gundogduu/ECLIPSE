package springIntro;

public class MySqlCustomerDal implements ICustomerDal{
	
	String connectionString;								//metin injection
	
	public String getConnectionString() {					//metin injection
		return connectionString;
	}
	public void setConnectionString(String connectionString) {     //metin injection
		this.connectionString = connectionString;
	}
	
	
	@Override
	public void add() {
		System.out.println("ConnectionString : " +this.connectionString);      //metin injection
		System.out.println("MySql veritabanýna eklendi"); //MYSQL kodlarý...
	}

}
