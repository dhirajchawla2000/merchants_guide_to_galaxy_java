/*
 * 
 */
package com.guide.merchant.commands;

import com.guide.merchant.databank.DataBank;
import com.guide.merchant.roman.RomanNumber;

/*
 * The HowMuchCommand class executes the commands like
 * "how much is pish ?"
 * @author Dhiraj Chawla 
 */
public class HowMuchCommand implements ICommand {

	private String words;
	private DataBank bank;

	public HowMuchCommand(DataBank bank, String words) {
		this.words = words;
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
			System.out.println(words + " is " + arabic);
		}
		else {
			System.out.println(WRONG_COMMAND_MESSAGE);
		}
	}
}
