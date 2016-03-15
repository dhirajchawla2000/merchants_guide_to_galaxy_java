/*
 * 
 */
package com.guide.merchant.databank;

import java.util.HashMap;

/*
 * The DataBank class keeps information about the mapping of word with Roman Numeral
 * and the mapping of item to it's credit value
 * @author Dhiraj Chawla 
 */
public class DataBank {

	/*
	 * Mapping of Roman Numeral to word that signifies them and
	 * mapping of item to it's credit value
	 */
	private HashMap<String, String> assignmentMap;
	private HashMap<String, Double> creditMap;
	
	public DataBank() {
		assignmentMap = new HashMap<String, String>();
		creditMap = new HashMap<String, Double>();
	}

	/*
	 * This method stores the mapping of word to Roman Numeral
	 * @param word
	 * @param meaning
	 */
	public void setAssignment(String word, String meaning){
		assignmentMap.put(word, meaning);
	}

	/*
	 * This method returns the Roman Numeral mapped to a given word
	 * @param word
	 */
	public String getAssignment(String word){
		return assignmentMap.get(word);
	}

	/*
	 * This method parses the words in the string and returns the
	 * equivalent Roman Numeral based information stored in the bank
	 */
	public String getRomanFromString(String words){
		String[] wordArray = words.split("\\s+");
		String roman = "";
		for (String word : wordArray) {
			String meaning = assignmentMap.get(word);
			if (meaning == null) {
				// One of the word was invalid in the string of words
				return "";
			}
			roman += meaning;
		}
		return roman;
	}

	/*
	 * This method stores the mapping of item to it's credit value
	 * @param item
	 * @param value
	 */
	public void setCredit(String item, Double value){
		creditMap.put(item, value);
	}

	/*
	 * This method returns the credit value mapped to a given item
	 * @param item
	 */
	public Double getCredit(String item){
		return creditMap.get(item);
	}
}
