/*
 * 
 */
package com.guide.merchant.commandparser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.guide.merchant.commands.*;
import com.guide.merchant.databank.*;

/*
 * The CommandParser class parses the given command string(s) and returns a command
 * object or a set of command objects which can effectively execute the command string
 * @author Dhiraj Chawla 
 */
public class CommandParser {

	/*
	 * Pattern matching strings for each type of valid commands
	 */
	private final String assignmentPattern = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
	private final String creditPattern = "^((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) [c|C]redits$";
	private final String howMuchPattern = "^[h|H]ow much is ((?:[a-z]+ )+)\\?$";
	private final String howManyPattern = "^[h|H]ow many [c|C]redits is ((?:[a-z]+ )+)([A-Z]\\w+) \\?$";

	/*
	 * DataBank to store assignment and credit assignment data, which will be
	 * referenced and used by the command objects during execution
	 */
	private DataBank bank;

	public CommandParser() {
		bank = new DataBank();
	}

	/*
	 * This method returns a list of command objects for each command query
	 * @param queries
	 */
	public ArrayList<ICommand> getCommands(ArrayList<String> queries) {
		if (queries == null) {
			return new ArrayList<ICommand>();
		}

		ArrayList<ICommand> commands = new ArrayList<ICommand>();
		for (int i=0; i<queries.size(); i++) {
			ICommand command = getCommand(queries.get(i));
			commands.add(command);
		}
		return commands;
	}

	/*
	 * This method returns a command object corresponding to the input command query
	 * @param query
	 */
	public ICommand getCommand(String query) {
		ICommand command;
		if (query.matches(assignmentPattern)) {
			Pattern p = Pattern.compile(assignmentPattern);
			Matcher m = p.matcher(query);
			m.matches();
			String word = m.group(1).trim();
			String meaning = m.group(2).trim();
			command = new AssignmentCommand(bank, word, meaning);
		}
		else if (query.matches(creditPattern)) {
			Pattern p = Pattern.compile(creditPattern);
			Matcher m = p.matcher(query);
			m.matches();
			String words = m.group(1).trim();
			String item = m.group(2).trim();
			String value = m.group(3).trim();
			command = new CreditAssignCommand(bank, words, item, value);
		}
		else if (query.matches(howMuchPattern)) {
			Pattern p = Pattern.compile(howMuchPattern);
			Matcher m = p.matcher(query);
			m.matches();
			String words = m.group(1).trim();
			command = new HowMuchCommand(bank, words);
		}
		else if (query.matches(howManyPattern)) {
			Pattern p = Pattern.compile(howManyPattern);
			Matcher m = p.matcher(query);
			m.matches();
			String words = m.group(1).trim();
			String item = m.group(2).trim();
			command = new HowManyCommand(bank, words, item);
		}
		else {
			command = new UnknownCommand();
		}
		return command;
	}
}
