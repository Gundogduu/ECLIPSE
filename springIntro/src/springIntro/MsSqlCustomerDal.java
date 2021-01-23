package springIntro;

public class MsSqlCustomerDal implements ICustomerDal{

	String connectionString;										//metin injection
	
	public String getConnectionString() {							//metin injection
		return connectionString;
	}
	public void setConnectionString(String connectionString) {		//metin injection
		this.connectionString = connectionString;
	}
	
	@Override
	public void add() {
		System.out.println("ConnectionString : " +this.connectionString);          //metin injection
		System.out.println("Ms Sql veritabanýna eklendi"); //Ms Sql kodlarý...
		
	}

}
