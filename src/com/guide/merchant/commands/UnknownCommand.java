/*
 * 
 */
package com.guide.merchant.commands;

/*
 * The UnknownCommand class executes the commands that is not
 * recognized a valid command query
 * @author Dhiraj Chawla 
 */
public class UnknownCommand implements ICommand {

	@Override
	public void execute() {
		System.out.println(WRONG_COMMAND_MESSAGE);
	}

}
