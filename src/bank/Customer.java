package bank;

import java.util.ArrayList;

public class Customer {
	
	private String name;
	private String surname;
	private String accountNo;
	private String sortCode;
	private String id;
	private ArrayList<Transaction> transactions;
	
	public Customer(String name, String surname, String accountNo, String sortCode, String id){
		this.name = name;
		this.surname = surname;
		this.accountNo = accountNo;
		this.sortCode = sortCode;
		this.transactions = new ArrayList<Transaction>();
		this.id = id;
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

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public String getID() {
		return id;
	}
}