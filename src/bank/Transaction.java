package bank;

public class Transaction {
	
	private double value;
	private String company;
	private String postcode;
	private String country;
	private String transactionID;
	
	public Transaction(double val, String company, String postcode, String country, String transactionID){
		this.value = val;
		this.company = company;
		this.postcode = postcode;
		this.country = country;
		this.transactionID = transactionID;
	}
	
	public double getValue(){
		return value;
	}
	
	public String getCompany(){
		return company;
	}
	
	public String getID(){
		return transactionID;
	}
}