package commands;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.guide.merchant.commands.UnknownCommand;

public class UnknownCommandTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(out));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}

	@Test
	public void test() {
		UnknownCommand uc = new UnknownCommand();
		uc.execute();

		assertEquals(out.toString(), "I have no idea what you are talking about\n");
	}

}
