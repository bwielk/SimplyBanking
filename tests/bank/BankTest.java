package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private Bank bank;
	private Branch branch1;
	private Branch branch2;
	private Branch branch3;
	private Branch branch4;
	private Branch branch5;
	
	@Before
	public void before(){
		bank = new Bank();
		branch1 = new Branch("EH19938","EH130RP");
		branch2 = new Branch("LA48553","LA539SD");
		branch3 = new Branch("LA12553","LA539SD");
		branch4 = new Branch("EH19938","LA139SD");
		branch5 = new Branch("LA48553","LA539SD");
	}
	
	@Test
	public void bankCanStoreBranchesWithDifferentIds(){
		bank.addBranch(branch1);
		bank.addBranch(branch2);
		assertEquals(2, bank.allBranches());
	}
	
	@Test
	public void bankCannotStoreBranchesWithSimilarIds(){
		bank.addBranch(branch1);
		bank.addBranch(branch5);
		bank.addBranch(branch1);
		bank.addBranch(branch4);
		assertEquals(2, bank.allBranches());
	}
	
	@Test
	public void bankCanRemoveABranchById(){
		bank.addBranch(branch1);
		bank.addBranch(branch2);
		bank.addBranch(new Branch("WC43212", "WC189FF"));
		assertEquals(3, bank.allBranches());
		bank.removeBranchByID("EH19938");
		assertEquals(2, bank.allBranches());
		bank.removeBranchByID(branch2.getId());
		assertEquals(1, bank.allBranches());
		assertEquals("WC43212", bank.getBranches().get(0).getId());
	}
}
