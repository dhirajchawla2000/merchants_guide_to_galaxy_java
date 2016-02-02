/*
 * 
 */
package com.guide.merchant.commands;

import com.guide.merchant.databank.DataBank;

/*
 * The AssignmentCommand class executes the commands like
 * "pish is I"
 * @author Dhiraj Chawla 
 */
public class AssignmentCommand implements ICommand {

	private String word;
	private String meaning;
	private DataBank bank;

	public AssignmentCommand(DataBank bank, String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
		this.bank = bank;
	}

	@Override
	public void execute() {
		bank.setAssignment(word, meaning);
	}

}
