package databank;

import com.guide.merchant.databank.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataBankTest {

	DataBank bank;

	@Before
	public void setUp() throws Exception {
		bank = new DataBank();
	}

	@Test
	public void validAssignmentTest() {
		bank.setAssignment("pish", "I");
		assertEquals(bank.getAssignment("pish"), "I");
	}

	@Test
	public void invalidAssignmentTest() {
		assertEquals(bank.getAssignment("gish"), null);
	}

	@Test
	public void validCreditTest() {
		bank.setCredit("Gold", Double.valueOf(2.0));
		assertEquals(bank.getCredit("Gold"), Double.valueOf(2.0));
	}

	@Test
	public void invalidCreditTest() {
		assertEquals(bank.getCredit("Rubber"), null);
	}

}
