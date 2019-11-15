import java.io.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws IOException {
		SvobodaDictionary s1 = new SvobodaDictionary("diary.txt");
		Queue<String> wordsTE = s1.findByLetters("the");
		System.out.println(wordsTE);
		wordsTE = s1.findByLetters("the", 4, 5);
		System.out.println(wordsTE);
	}
	
	//updateDictionary(String fileName)
	//Updates dictionary (dictionary folder) with words from passed txt folder
}