package commands;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.guide.merchant.commands.AssignmentCommand;
import com.guide.merchant.databank.DataBank;

public class AssignmentCommandTest {

	private DataBank db;

	@Before
	public void setUp() throws Exception {
		db = new DataBank();
	}

	@Test
	public void test() {
		AssignmentCommand ac = new AssignmentCommand(db, "pish", "I");
		ac.execute();
		assertEquals(db.getAssignment("pish"), "I");
	}
}
