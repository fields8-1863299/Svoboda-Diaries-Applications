import java.util.*;
import java.io.*;

//Dictionary object. Reads in a .txt file from the txt folder specified by a passed file name and contructs a map of the unique words
//	with the key being the first letter of the word
public class SvobodaDictionary {
	private Map<Character, TreeSet<String>> SvobodaDictionary;
	
	//Constructor: puts words to lowercase, ignores numbers, strips words of punctuation
	//fileName: Name of the .txt file (include .txt tag) stored in the txt folder
	//To change: Create from dictionary folder, folder to be updated through clients
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
			
			
			String word = input.next().toLowerCase();
			//strip word
			word = word.replaceAll("[^a-zA-Z ]", "");
			
			try {
				char index = word.charAt(0);
				if (!SvobodaDictionary.keySet().contains(index)) {
					SvobodaDictionary.put(index, new TreeSet<String>());
				}
				
				SvobodaDictionary.get(index).add(word);
			} catch(Exception IndexOutOfBoundsException) {
				
			}
		}
		
		input.close();
	}
	
	//Prints to terminal all the words in the dictionary in alphabetical order
	public void printAll() {
		for (char letter: SvobodaDictionary.keySet()) {
			System.out.println(letter +  ":");
			for (String word: SvobodaDictionary.get(letter)) {
				System.out.println("	" + word);
			}
			System.out.println();
		}
	}
	
	//ExportCSV: Exports the current collection to a csv file with letters as rows and the words
	// mapped to those letter as cols
	//filename: Path + name of file, MUST END IN .CSV
	//type: String indicating format of csv file,
	//			v - view, rows a-z, cols words begining with letter in row
	//			r - reading, 1 row containing all the words for fast import reading
	public void exportCSV(String filename, String type) throws IOException {
		if (type.toLowerCase().equals("v")) {
			exportCSVView(filename);
		} else if (type.toLowerCase().equals("r")) {
			exportCSVRead(filename);
		} else {
			System.out.println("Please enter an export type");
		}
	}
	
	//Helper method for viewing
	private void exportCSVView(String filename) throws IOException {
		//try catch might not be necessary
		try (FileWriter writer = new FileWriter(new File("../csv/view/" + filename))) {
			//for correct indexing
			writer.append("0");
			
			for (int i = 1; i <= findMax(); i++) {
				writer.append("," + i);
			}
			
			writer.append("\n");
			
			//writes out for each word that starts with certain letter
			for (char letter: SvobodaDictionary.keySet()) {
				writer.append(letter);
				
				for (String word: SvobodaDictionary.get(letter)) {
					writer.append("," + word);
				}
				
				writer.append("\n");
			}
			
			writer.flush();
			writer.close();
			
			} catch (FileNotFoundException e) {
				
			}
	}
	
	//helper method to reading
	private void exportCSVRead(String filename) throws IOException {
			try (FileWriter writer = new FileWriter(new File("../csv/read/" + filename))) {
			for (char letter: SvobodaDictionary.keySet()) {
				for (String word: SvobodaDictionary.get(letter)) {
					writer.append(word + ",");
				}
			}
			
			writer.flush();
			writer.close();
			
			} catch (FileNotFoundException e) {
				
			}
	}
	
	//Helper method for exportCSV
	//Returns the size of the largest set of words in the dictionary
	private int findMax() {
		int max = 0;
		for (char letter: SvobodaDictionary.keySet()) {
			if (max < SvobodaDictionary.get(letter).size()) {
				max = SvobodaDictionary.get(letter).size();
			}
		}
		return max;
	}
	

	//Finds words with letters in specific order that exist in the dictionary
	// Returns words as Queue of Strings
	public Queue<String> findByLetters(String pattern) {
		Queue<String> words = new LinkedList<>();
		
		for (char letter: SvobodaDictionary.keySet()) {
			for (String word: SvobodaDictionary.get(letter)) {
				if (findByLettersHelper(word, pattern)) {
					words.add(word);
				}
			}
		}
		
		return(words);	
	}
	
	//Finds words with letters in specific order and range of length that exist in dictionary
	public Queue<String> findByLetters(String pattern, int min, int max) {
		Queue<String> words = findByLetters(pattern);
		int size = words.size();
		
		for (int i = 0; i < size; i++) {
			String word = words.remove();
			
			if (word.length() >= min && word.length() <= max) {
				words.add(word);
			}
		}
		
		return words;
	}
	
	// Finds words with letters in specific order and length
	public Queue<String> findByLetters(String pattern, int length) {
		return findByLetters(pattern, length, length);
	}
	
	//Helper method for findByLetters
	//	Takes in word being considered and a sequence of letters its looking for
	//	If the word contains letters in that sequence in the pattern returns true
	private boolean findByLettersHelper(String word, String pattern) {
		if (pattern.length() == 0) {
			return true;
		} else if (word.length() == 0) {
			return false;
		}
		
		if (word.charAt(0) == pattern.charAt(0)) {
			return findByLettersHelper(word.substring(1), pattern.substring(1));
		} else {
			return findByLettersHelper(word.substring(1), pattern);
		}
	}
}