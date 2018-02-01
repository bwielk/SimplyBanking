package bank;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private Bank bank;
	private Branch branch1;
	private Branch branch2;
	private Branch branch3;
	private Branch branch4;
	private Branch branch5;
	private Customer customer1;
	private Customer customer2;
	private Customer customer3;
	
	@Before
	public void before(){
		bank = new Bank();
		//SUCCESSFUL ADDING OF BRANCHES TO A BANK 
		branch1 = new Branch("EH19938","EH130RP");
		branch2 = new Branch("LA48553","LA539SD");
		branch3 = new Branch("LA12553","LA539SD");
		//UNSUCCESSFUL ADDING OF BRANCHES TO A BANK
		branch4 = new Branch("EH19938","LA139SD");//THE SAME ID LIKE BRANCH 1
		branch5 = new Branch("LA48553","LA539SD");//THE SAME ID LIKE BRANCH 5
		customer1 = new Customer("Alex", "Doe", "11123431", "90-34-11", "90993432");
		customer2 = new Customer("Sam", "Clover", "98223123", "10-12-92", "46422344");
		customer3 = new Customer("Daniel", "Birmin", "03473728", "23-77-81", "12239342");
	}
	
	@Test
	public void bankCanStoreBranchesWithDifferentIds(){
		bank.addBranch(branch1);
		bank.addBranch(branch2);
		assertEquals(2, bank.getBranches().size());
		bank.addBranch(branch5);
		assertEquals(2, bank.getBranches().size());
		bank.addBranch(branch3);
		assertEquals(3, bank.getBranches().size());
	}
	
	@Test
	public void bankCannotStoreBranchesWithSimilarIds(){
		bank.addBranch(branch1);
		bank.addBranch(branch5);
		bank.addBranch(branch1);
		bank.addBranch(branch4);
		assertEquals(2, bank.getBranches().size());
	}
	
	@Test
	public void bankCanRemoveABranchById(){
		bank.addBranch(branch1);
		bank.addBranch(branch2);
		bank.addBranch(new Branch("WC43212", "WC189FF"));
		assertEquals(3, bank.getBranches().size());
		bank.removeBranchByID("EH19938");
		assertEquals(2, bank.getBranches().size());
		bank.removeBranchByID(branch2.getId());
		assertEquals(1, bank.getBranches().size());
		assertEquals("WC43212", bank.getBranches().get(0).getId());
	}
	
	@Test
	public void bankCanAddCustomersToBranches(){
		bank.addBranch(branch1);
		bank.addBranch(branch2);
		assertEquals(true, bank.addCustomerToBranch(customer1, branch2));
		assertEquals(true, bank.addCustomerToBranch(customer2, branch1));
		assertEquals(true, bank.addCustomerToBranch(customer3, branch1));
		assertEquals(2, branch1.getCustomers().size());
		assertEquals(1, branch2.getCustomers().size());
	}
	
	@Test
	public void bankCannotAddTheSameCustomerTwiceToANYBranch(){
		bank.addBranch(branch1);
		bank.addBranch(branch2);
		assertEquals(true, bank.addCustomerToBranch(customer1, branch2));
		assertEquals(true, bank.addCustomerToBranch(customer2, branch2));
		assertEquals(true, bank.addCustomerToBranch(customer3, branch1));
		assertEquals(false, bank.addCustomerToBranch(customer1, branch1));
		assertEquals(2, branch2.getCustomers().size());
		assertEquals(1, branch1.getCustomers().size());
	}
	
	private Customer getCustomerByBranchID(HashMap<Customer, String>list, String id){
		for(Customer customer : list.keySet()){
			if(customer.equals(id)){
				return customer;
			}
		}
		return null;
	}
	
	@Test
	public void bankCanFindACustomerByItsSurname(){
		bank.addBranch(branch1);
		bank.addBranch(branch2);
		assertEquals(true, bank.addCustomerToBranch(customer1, branch2));
		assertEquals(true, bank.addCustomerToBranch(customer2, branch2));
		assertEquals(true, bank.addCustomerToBranch(customer3, branch1));
		Customer customer4 = new Customer("John", "Doe", "23123539", "07-32-99", "10897432");
		assertEquals(true, bank.addCustomerToBranch(customer4, branch1));
		HashMap<Customer, String> results = bank.findCustomerBySurname("Doe");
		assertEquals(2, results.size());
		assertEquals("LA48553", results.get(customer1));
		assertEquals("EH19938", results.get(customer4));
	}
	
	public void prepareBankForCustomerSearch(){
		bank.addBranch(branch3);
		bank.addBranch(branch2);
		assertEquals(true, bank.addCustomerToBranch(customer1, branch2));
		assertEquals(true, bank.addCustomerToBranch(customer2, branch3));
		assertEquals(true, bank.addCustomerToBranch(customer3, branch2));
	}
	
	@Test
	public void bankCanFindACustomerByItsID(){
		System.out.println("bankCanFindACustomerByItsID");
		prepareBankForCustomerSearch();
		Customer customer4 = new Customer("John", "Doe", "23123539", "07-32-99", "10897432");
		assertEquals(true, bank.addCustomerToBranch(customer4, branch3));
		HashMap<Customer, String> results = bank.findCustomerById("10897432");
		assertEquals("LA12553", results.get(customer4));
		assertEquals(1, results.size());
	}
	
	@Test
	public void bankCanFindACustomerByItsIDPart2(){
		System.out.println("bankCanFindACustomerByItsIDPart2");
		prepareBankForCustomerSearch();
		HashMap<Customer, String> results = bank.findCustomerById("46422344");
		assertEquals("LA12553", results.get(customer2));
		assertEquals(1, results.size());
	}
	
	@Test
	public void bankCanFindACustomerByItsIDPart3(){
		System.out.println("bankCanFindACustomerByItsIDPart3");
		prepareBankForCustomerSearch();
		System.out.println(bank.getBranches().size());
		for(int i=0; i<bank.getBranches().size(); i++){
			System.out.println(bank.getBranches().get(i).getId());
		}
		Customer customer5 = new Customer("Dan", "Montague", "29844329", "05-52-59", "44444232");
		assertEquals(true, bank.addCustomerToBranch(customer5, branch2));
		HashMap<Customer, String> results = bank.findCustomerById("44444232");
		assertEquals("LA48553", results.get(customer5));
		assertEquals(1, results.size());
	}
}