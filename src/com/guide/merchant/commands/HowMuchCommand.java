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
		String roman = bank.getRomanFromString(words);

		if (roman == "") {
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
