package bank;

public class Branch {
	
	private String id;
	private String postcode;
	
	public Branch(String id, String postcode){
		this.id = id;
		this.postcode = postcode;
	}

	public String getId(){
		return id;
	}
	
	public String getPostcode(){
		return postcode;
	}
}