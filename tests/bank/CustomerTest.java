package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;

	@Before
	public void before(){
		customer = new Customer("John", "Smith", "23456543", "45-43-12");
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
}
