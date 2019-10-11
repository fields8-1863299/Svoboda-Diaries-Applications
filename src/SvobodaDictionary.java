import java.util.*;
import java.io.*;

//Dictionary object. Reads in a .txt file from the txt folder specified by a passed file name and contructs a map of the unique words
//	with the key being the first letter of the word
public class SvobodaDictionary {
	private Map<Character, TreeSet<String>> SvobodaDictionary;
	
	//Constructor
	//fileName: Name of the .txt file (include .txt tag) stored in the txt folder
	public SvobodaDictionary(String fileName) {
		SvobodaDictionary = new TreeMap<Character, TreeSet<String>>();
		
		Scanner input = null;
		try {
			input = new Scanner(new File("../txt/" + fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		}
		
		//updates SvobodaDictionary
		while (input.hasNext()) {
			String word = input.next();
			char index = word.charAt(0);
			
			if (!SvobodaDictionary.keySet().contains(index)) {
				SvobodaDictionary.put(index, new TreeSet<String>());
			}
			
			SvobodaDictionary.get(index).add(word);
		}
		
		input.close();
	}
	
	//Prints to terminal all the words in the dictionary in alphabetical order
	public void printAll() {
		for (char letter: SvobodaDictionary.keySet()) {
			System.out.println(letter +  ":");
			for (String word: SvobodaDictionary.get(letter)) {
				System.out.println(word);
			}
			System.out.println();
		}
	}
	
	//findByLetters(String letters)
	//	Finds words with letters in specific order
	
	//findByLetters(String letters, int min, int max)
	// Finds words with letters in specific order and range of length
}