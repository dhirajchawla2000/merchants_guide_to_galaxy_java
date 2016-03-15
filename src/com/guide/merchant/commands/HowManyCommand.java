/*
 * 
 */
package com.guide.merchant.commands;

import com.guide.merchant.databank.DataBank;
import com.guide.merchant.roman.RomanNumber;

/*
 * The HowManyCommand class executes the commands like
 * "how many Credits is pish Iron ?"
 * @author Dhiraj Chawla 
 */
public class HowManyCommand implements ICommand {

	private String words;
	private String item;
	DataBank bank;
	
	public HowManyCommand(DataBank bank, String words, String item) {
		this.words = words;
		this.item = item;
		this.bank = bank;
	}

	@Override
	public void execute() {
		String roman = bank.getRomanFromString(words);

		if (roman == "" || bank.getCredit(item) == null) {
			System.out.println(WRONG_COMMAND_MESSAGE);
			return;
		}

		if (RomanNumber.isValidRomanNumber(roman)){
			int arabic = RomanNumber.romanNumberToArabic(roman);
			double value = Double.valueOf(bank.getCredit(item));
			double finalValue = arabic * value;
			System.out.println(words + " " + item + " is " + finalValue + " Credits");
		}
		else {
			System.out.println(WRONG_COMMAND_MESSAGE);
		}
	}
}
