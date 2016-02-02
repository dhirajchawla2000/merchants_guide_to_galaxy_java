package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.guide.merchant.commands.CreditAssignCommand;
import com.guide.merchant.databank.DataBank;

public class CreditAssignCommandTest {

	private DataBank db;

	@Before
	public void setUp() throws Exception {
		db = new DataBank();
	}

	@Test
	public void test() {
		db.setAssignment("pish", "I");

		CreditAssignCommand cac = new CreditAssignCommand(db, "pish pish", "Iron", "4");
		cac.execute();

		assertEquals(db.getCredit("Iron"), Double.valueOf(2.0));
	}

}
