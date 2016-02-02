/*
 * 
 */
package com.guide.merchant.roman;

/*
 * This class provides a set of methods to convert and validate Roman number to Arabic number
 * @author Dhiraj Chawla 
 */
public class RomanNumber {

	/*
	 * The regex string for validating if the given input string is a valid Roman number or not
	 */
	private static String romanNumberValidator = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

	/*
	 * This enum has integer value corresponding to the given roman value
	 */
	enum Roman{

		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

		private int value;

		Roman(int value)
		{
			this.value = value;
		}

		public int getValue()
		{
			return this.value;
		}
	}

	/*
	 * This method validates if given input string is a valid Roman number
	 * @param roman
	 */
	public static boolean isValidRomanNumber(String roman) {
		if (roman.matches(romanNumberValidator)) {
			return true;
		}
		return false;
	}

	/*
	 * This method converts a Roman number to Arabic number
	 * @param roman
	 */
	public static int romanNumberToArabic(String roman) {
		if (isValidRomanNumber(roman)) {
			int result = 0;
			int lastRomanValue = 0;
			for (int i=roman.length()-1; i>=0; i--){
				char ch=roman.charAt(i);
				result = calculateValue(getIntValueFromRoman(ch), lastRomanValue, result);
				lastRomanValue = getIntValueFromRoman(ch);
			}
			return result;
		}
		else {
			return -1;
		}
	}

	/*
	 * This method calculates a partial value of Arabic number
	 * @param currentRomanValue
	 * @param lastRomanValue
	 * @param lastArabicValue
	 */
	private static int calculateValue(int currentRomanValue, int lastRomanValue, int lastArabicValue) {
		if (lastRomanValue > currentRomanValue){
			return lastArabicValue - currentRomanValue;
		}
		else {
			return lastArabicValue + currentRomanValue;
		}
	}

	/*
	 * This method returns Arabic value for given Roman character
	 * @param roman
	 */
	private static int getIntValueFromRoman(char roman) {
		int value = -1;
		switch(roman) {
			case 'I' : value = Roman.I.getValue(); break;
			case 'V' : value = Roman.V.getValue(); break;
			case 'X' : value = Roman.X.getValue(); break;
			case 'L' : value = Roman.L.getValue(); break;
			case 'C' : value = Roman.C.getValue(); break;
			case 'D' : value = Roman.D.getValue(); break;
			case 'M' : value = Roman.M.getValue(); break;
		}
		return value;
	}
}
