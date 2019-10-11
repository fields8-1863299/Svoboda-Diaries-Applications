import java.util.*;
import java.io.*;

public class SvobodaDictionary {
	private Map<Character, TreeSet<String>> SvobodaDictionary;
	
	public SvobodaDictionary(String fileName) {
		SvobodaDictionary = new TreeMap<Character, TreeSet<String>>();
		
		Scanner input = null;
		try {
			input = new Scanner(new File("../txt/" + fileName + ".txt"));
		} catch (FileNotFoundException e) {
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
	
	public void printAll() {
		for (char letter: SvobodaDictionary.keySet()) {
			for (String word: SvobodaDictionary.get(letter)) {
				System.out.println(word);
			}
		}
	}
}