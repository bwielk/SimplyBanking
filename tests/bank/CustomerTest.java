package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	private Bank bank;
	private Branch branch;

	@Before
	public void before(){
		customer = new Customer("John", "Smith", "23456543", "45-43-12");
		branch = new Branch("EH12322", "EH10LP");
		bank = new Bank();
		bank.addBranch(branch);
	}
	
	@Test
	public void customerHasNameAndSurname(){
		assertEquals("John", customer.getName());
		assertEquals("Smith", customer.getSurname());
	}
	
	@Test
	public void customerHasAnAccountNumberAndSortCode(){
		assertEquals("23456543", customer.getAccountNumber());
		assertEquals("45-43-12", customer.getSortCode());
	}
	
	@Test
	public void customerHasTransactionRegisteredByTheBank(){
		Transaction transaction1 = new Transaction(2.00, "Tesco Express", "EH120QE", "Scotland", "12102018abc");
		bank.addTransactionToCustomer(customer, transaction1);
		assertEquals("Tesco Express", customer.getTransactions().get(0).getCompany());
		Transaction transaction2 = new Transaction(32.00, "Sainsbury's", "EH16PE", "Scotland", "13102018ddc");
		bank.addTransactionToCustomer(customer, transaction2);
		assertEquals(32.00, customer.getTransactions().get(1).getValue(), 0.1);
	}
	
	@Test
	public void customerHasTransactionWithUniqueID_TransactionsWithTheSameIDCannotBeStored(){
		Transaction transaction1 = new Transaction(2.00, "Tesco Express", "EH120QE", "Scotland", "12102018abc");
		bank.addTransactionToCustomer(customer, transaction1);
		assertEquals("Tesco Express", customer.getTransactions().get(0).getCompany());
		Transaction transaction2 = new Transaction(32.00, "Sainsbury's", "EH16PE", "Scotland", "13102018ddc");
		bank.addTransactionToCustomer(customer, transaction2);
		Transaction transaction3 = new Transaction(132.00, "John Lewis", "EH26AE", "Scotland", "12102018abc");
		bank.addTransactionToCustomer(customer, transaction3);
		Transaction transaction4 = new Transaction(132.00, "John Lewis", "EH26AE", "Scotland", "12102018abc");
		bank.addTransactionToCustomer(customer, transaction4);
		assertEquals(2, customer.getTransactions().size());
		assertEquals(2.00, customer.getTransactions().get(0).getValue(), 0.1);
	}
}
