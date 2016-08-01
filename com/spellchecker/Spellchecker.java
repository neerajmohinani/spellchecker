package com.spellchecker;
import java.io.*;


/**
 * A custom Spell Checker program which uses a Trie as the data structure
 * 
 * The executable builds it's dictionary by reading in a defined dictionary file,
 * or "/usr/share/dict/words" as default, and then prompts the user to type a word.
 * Based on the input word, 3 rules are checked to see if a match is found or a
 * suggestion can be made. If no word is found, then NO SUGGESTION is printed.
 * 
 * The current rules this software checks for are:
 * 1. ImPROper cAPITalIZAioN. The entire dictionary is treated as lower case and all
 *    inputs are suggested as lowercase.
 * 2. Misplacad vuwals. If the input word is not found, the vowels A,E,I,O,U are
 *    substituted until a suggestion is found. Through a brute force method, all
 *    vowel combinations are attempted. For example, in the input "tost", "test",
 *    "tast", "tist", "tust" are all attempted words. While "toast" tries "toest",
 *    "toust", "teost", "teust", etc...
 * 3. Reeeepeeeated Letttters. Any repeated letters are removed and the word is
 *    checked again.
 *    
 * Any combination of these rules is acceptable. Capitalizations can occur on the same
 * section of the string as repeated letters or incorrect vowels.
 * 
 * @author Neeraj Mohinani
 * @version 1.0
 */
public class Spellchecker {
	
	private static Trie dict = new Trie();
	
	private String word = "";
	private String result = null;
	
	/**
	 * constructor to initialize dictionary from default path 
	 */
	public Spellchecker() {
		this("words.txt");
	}
	
	public String createWord(String word) {
		this.word = "";
		return addToWord(word);
	}
	
	public String addToWord(String word) {
		this.word += word;
		this.result = dict.find(this.word);
		return this.result;
	}
	
	public String getResult(){
		return this.result;
	}

	public Spellchecker(String dictonaryFileName){
		try {
			buildDictionary(dictonaryFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Builds a dictionary file into a Trie
	 * @param fileName the dictionary file
	 * @throws IOException 
	 */
	private void buildDictionary(String fileName) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(fileName))));
			String line;
			while ((line = br.readLine()) != null) {
				dict.insert(line.toLowerCase());
			}
		} catch (Exception e) { //File not found, rebuild dictionary with default dictionary file
			System.err.println(e.getMessage());

		}
		finally{
			br.close();
		}
	}
	
	public String getReadableDictionary() {
		return dict.toString();
	}
	
}
