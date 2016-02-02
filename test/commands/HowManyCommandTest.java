package commands;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.guide.merchant.commands.HowManyCommand;
import com.guide.merchant.databank.DataBank;

public class HowManyCommandTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private DataBank db;

	@Before
	public void setUp() throws Exception {
		db = new DataBank();
		System.setOut(new PrintStream(out));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}

	@Test
	public void test() {
		db.setAssignment("pish", "I");
		db.setCredit("Iron", Double.valueOf(2.0));
		
		HowManyCommand hmc = new HowManyCommand(db, "pish pish pish", "Iron");
		hmc.execute();

		assertEquals(out.toString(), "pish pish pish Iron is 6.0 Credits\n");
	}

}
