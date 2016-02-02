/*
 * 
 */
package com.guide.merchant.commands;

import com.guide.merchant.databank.DataBank;
import com.guide.merchant.roman.RomanNumber;

/*
 * The CreditAssignCommand class executes the commands like
 * "pish Iron is 10 Credits"
 * @author Dhiraj Chawla 
 */
public class CreditAssignCommand implements ICommand {

	private String words;
	private String item;
	private String value;
	private DataBank bank;

	public CreditAssignCommand(DataBank bank, String words, String item, String value) {
		this.words = words;
		this.item = item;
		this.value = value;
		this.bank = bank;
	}

	@Override
	public void execute() {
		boolean notFound = false;
		String[] wordArray = words.split("\\s+");
		String roman = "";
		for (String word : wordArray) {
			String meaning = bank.getAssignment(word);
			if (meaning == null) {
				notFound = true;
				break;
			}
			roman += meaning;
		}

		if (notFound || roman == "") {
			System.out.println(WRONG_COMMAND_MESSAGE);
			return;
		}

		if (RomanNumber.isValidRomanNumber(roman)){
			int arabic = RomanNumber.romanNumberToArabic(roman);
			int creditValue = Integer.parseInt(this.value);
			double finalValue = ((double)creditValue/arabic);
			bank.setCredit(item, Double.valueOf(finalValue));
		}
		else {
			System.out.println(WRONG_COMMAND_MESSAGE);
		}
	}
}
