package bank;

public class Customer {
	
	private String name;
	private String surname;
	private String accountNo;
	private String sortCode;
	
	public Customer(String name, String surname, String accountNo, String sortCode){
		this.name = name;
		this.surname = surname;
		this.accountNo = accountNo;
		this.sortCode = sortCode;
	
	}

	public String getName(){
		return name;
	}
	
	public String getSurname(){
		return surname;
	}

	public String getAccountNumber(){
		return accountNo;
	}
	
	public String getSortCode(){
		return sortCode;
	}
}