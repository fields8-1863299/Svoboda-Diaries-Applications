import java.util.*;
import java.io.*;

public class svobodaClass {
	private Map<Character, TreeSet<String>> svobodaDictionary;
	
	public svobodaClass(String fileName) {
		svobodaDictionary = new TreeMap<Character, TreeSet<String>>();
		
		Scanner input = null;
		try {
			input = new Scanner(new File("../txt/" + fileName + ".txt"));
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
		
		//updates svobodaDictionary
		while (input.hasNext()) {
			String word = input.next();
			char index = word.charAt(0);
			
			if (!svobodaDictionary.keySet().contains(index)) {
				svobodaDictionary.put(index, new TreeSet<String>());
			}
			
			svobodaDictionary.get(index).add(word);
		}
		
		input.close();
	}
	
	public void printAll() {
		for (char letter: svobodaDictionary.keySet()) {
			for (String word: svobodaDictionary.get(letter)) {
				System.out.println(word);
			}
		}
	}
}
