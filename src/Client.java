import java.io.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws IOException {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter txt file your want to read in: ");
		String txtfile = console.next();
		System.out.println();
		
		SvobodaDictionary dict = new SvobodaDictionary(txtfile);
		
		boolean esc = true;
		
		while (esc) {
			System.out.println("Do you want to:");
			System.out.println("   Export new CSV? (1)");
			System.out.println("   Find words by letters? (2)");
			System.out.println("   Find words by letters and length? (3)");
			System.out.println("   Find words by letters and range? (4)");
			int choice = console.nextInt();
			System.out.println();
			
			if (choice == 1) {
				System.out.print("Enter name for csv file: ");
				String name = console.next();
				System.out.println();
				
				dict.exportCSV(name, "v");
				dict.exportCSV(name, "r");
			} else if (choice == 2) {
				System.out.print("Enter letters you're looking for in the sequence they appear: ");
				String pattern = console.next();
				System.out.println();
				
				System.out.println(dict.findByLetters(pattern));
				
			} else if (choice == 3) {
				System.out.print("Enter letters you're looking for in the sequence they appear: ");
				String pattern = console.next();
				System.out.print("Enter a length: ");
				int length = console.nextInt();
				
				System.out.println(dict.findByLetters(pattern, length));
			} else if (choice == 4) {
				System.out.print("Enter letters you're looking for in the sequence they appear: ");
				String pattern = console.next();
				System.out.print("Smallest word length: ");
				int min = console.nextInt();
				System.out.print("Largest word length: ");
				int max = console.nextInt();
				
				System.out.println(dict.findByLetters(pattern, min, max));
			}
			
			System.out.print("Enter \"Yes\" to Exit: ");
			if (console.next().equals("Yes")) {
				esc = false;
			}
			System.out.println();
		}
	}
}