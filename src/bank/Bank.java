package bank;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
	
	private ArrayList<Branch> branches;
	
	public Bank(){
		branches = new ArrayList<Branch>();
	}
	
	public boolean addBranch(Branch branch){
		if(!branchAlreadyExists(branch)){
			branches.add(branch);
			return true;
		}
		return false;
	}

	public boolean removeBranchByID(String string){
		for(int i=0; i<branches.size(); i++){
			Branch branch = branches.get(i);
			if(branch.getId() == string){
				branches.remove(i);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Branch> getBranches(){
		return branches;
	}

	public boolean addTransactionToCustomer(Customer customer, Transaction transaction){
		if(customer.getTransactions().isEmpty()){
			customer.getTransactions().add(transaction);
			return true;
		}
		if(!transactionAlreadyExists(customer, transaction)){
			customer.getTransactions().add(transaction);
			return true;
		}
		return false;
	}

	public boolean addCustomerToBranch(Customer customer, Branch branch) {
		if(branchAlreadyExists(branch) && !customerAlreadyExists(customer)){
			branch.getCustomers().add(customer);
			return true;
		}
		return false;
	}
	
	private boolean branchAlreadyExists(Branch branch){
		for(int i=0; i<branches.size(); i++){
			Branch branchToEvaluate = branches.get(i);
			if(branchToEvaluate.getId() == branch.getId()){
				return true;
			}
		}
		return false;
	}
	
	private boolean transactionAlreadyExists(Customer customer, Transaction transaction){
		for(int i=0; i<customer.getTransactions().size(); i++){
			Transaction t = customer.getTransactions().get(i);
			if(t.getID().equals(transaction.getID())){
				return true;
			}
		}
		return false;
	}

	private boolean customerAlreadyExists(Customer customer) {
		for(int i=0; i<branches.size(); i++){
			ArrayList<Customer> customers = branches.get(i).getCustomers();
			for(int n=0; n<customers.size(); n++){
				if(customer.getID().equals(customers.get(n).getID())){
					return true;
				}
			}
		}
		return false;
	}

	public HashMap findCustomerBySurname(String surname){
		HashMap<Customer, String> results = new HashMap<Customer, String>();
		for(int i=0; i<branches.size(); i++){
			Branch currentBranch = branches.get(i);
			String branchID = currentBranch.getId();
			ArrayList<Customer> customers = currentBranch.getCustomers();
			for(int n=0; n<customers.size(); n++){
				Customer currentCustomer = customers.get(n);
				if(surname.equals(currentCustomer.getSurname())){
					results.put(currentCustomer, branchID);
				}
			}
		}
		return results;
	}
	
	public HashMap<Customer, String> findCustomerById(String id){
		HashMap<Customer, String> results = new HashMap<Customer, String>();
		for(int i=0; i<branches.size(); i++){
			Branch currentBranch = branches.get(i);
			String branchID = currentBranch.getId();
			ArrayList<Customer> customers = currentBranch.getCustomers();
			for(int n=0; n<customers.size(); n++){
				Customer currentCustomer = customers.get(n);
				if(id.equals(currentCustomer.getID())){
					results.put(currentCustomer, branchID);
				}
			}
		}
		return results;
	}
}