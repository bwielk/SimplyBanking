package bank;

import java.util.ArrayList;

public class Branch {
	
	private String id;
	private String postcode;
	private ArrayList<Customer> customers;
	
	public Branch(String id, String postcode){
		this.id = id;
		this.postcode = postcode;
		this.customers = new ArrayList<Customer>();
	}

	public String getId(){
		return id;
	}
	
	public String getPostcode(){
		return postcode;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
}