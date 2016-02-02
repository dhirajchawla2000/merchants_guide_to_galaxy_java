package commandparser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.guide.merchant.commandparser.CommandParser;
import com.guide.merchant.commands.AssignmentCommand;
import com.guide.merchant.commands.CreditAssignCommand;
import com.guide.merchant.commands.HowManyCommand;
import com.guide.merchant.commands.HowMuchCommand;
import com.guide.merchant.commands.ICommand;
import com.guide.merchant.commands.UnknownCommand;

public class CommandParserTest {

	@Test
	public void inputReturnsAssignmentCommandTest() {
		CommandParser cp = new CommandParser();
		ICommand command = cp.getCommand("pish is I");
		
		assertTrue(command instanceof AssignmentCommand);
	}

	@Test
	public void inputReturnsCreditAssignCommandTest() {
		CommandParser cp = new CommandParser();
		ICommand command = cp.getCommand("pish Iron is 10 Credits");
		
		assertTrue(command instanceof CreditAssignCommand);
	}

	@Test
	public void inputReturnsHowMuchCommandTest() {
		CommandParser cp = new CommandParser();
		ICommand command = cp.getCommand("how much is pish ?");
		
		assertTrue(command instanceof HowMuchCommand);
	}

	@Test
	public void inputReturnsHowManyCommandTest() {
		CommandParser cp = new CommandParser();
		ICommand command = cp.getCommand("how many Credits is pish Iron ?");
		
		assertTrue(command instanceof HowManyCommand);
	}

	@Test
	public void inputReturnsUnknownCommandTest() {
		CommandParser cp = new CommandParser();
		ICommand command = cp.getCommand("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
		
		assertTrue(command instanceof UnknownCommand);
	}

	@Test
	public void inputReturnsMultipleCommandsTest() {
		ArrayList<String> queries = new ArrayList<String>();
		queries.add("pish is I");
		queries.add("pish Iron is 10 Credits");
		queries.add("how much is pish ?");
		queries.add("how many Credits is pish Iron ?");
		queries.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");

		CommandParser cp = new CommandParser();
		ArrayList<ICommand> commands = cp.getCommands(queries);

		assertTrue(commands.get(0) instanceof AssignmentCommand);
		assertTrue(commands.get(1) instanceof CreditAssignCommand);
		assertTrue(commands.get(2) instanceof HowMuchCommand);
		assertTrue(commands.get(3) instanceof HowManyCommand);
		assertTrue(commands.get(4) instanceof UnknownCommand);
	}

}
