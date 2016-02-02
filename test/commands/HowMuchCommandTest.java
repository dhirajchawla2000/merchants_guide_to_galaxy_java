package commands;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.guide.merchant.commands.HowMuchCommand;
import com.guide.merchant.databank.DataBank;

public class HowMuchCommandTest {

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

		HowMuchCommand hmc = new HowMuchCommand(db, "pish pish");
		hmc.execute();

		assertEquals(out.toString(), "pish pish is 2\n");
	}

}
