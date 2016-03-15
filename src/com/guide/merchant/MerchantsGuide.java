/*
 * 
 */
package com.guide.merchant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.guide.merchant.commandparser.CommandParser;
import com.guide.merchant.commands.ICommand;

/*
 * The MerchantsGuide class is the main class the reads the input file and
 * executes the each command given in the input file
 * @author Dhiraj Chawla 
 */
public class MerchantsGuide {

	/*
	 * This method returns a list of command string from a given input file
	 * @param file
	 */
	private static ArrayList<String> readFile(String file) throws IOException {
		BufferedReader br = null;
		try {
			ArrayList<String> queries = new ArrayList<String>();
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					queries.add(line);
				}
			}
			return queries;
		}
		catch (IOException e) {
			throw e;
		}
		finally {
			try {
				br.close();
			}
			catch (IOException e) {
				throw e;
			}
		}
	}

	/*
	 * This is the main method which executes all the commands after reading
	 * the input file
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			if (args.length != 0) {
				String file = args[0];
				ArrayList<String> queries = readFile(file);
				CommandParser cp = new CommandParser();
				ArrayList<ICommand> commands = cp.getCommands(queries);
				
				for (ICommand command : commands) {
					command.execute();
				}
				commands.clear();
			}
			else {
				System.out.println("No file given as input. Please provide a valid input file.");
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
