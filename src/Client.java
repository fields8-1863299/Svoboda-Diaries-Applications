import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException {
		SvobodaDictionary s1 = new SvobodaDictionary("Nowf_D38.txt");
		s1.exportCSV("Nowf_D38.csv", "r");
		s1.exportCSV("Nowf_D38.csv", "v");
	}
	
	//updateDictionary(String fileName)
	//Updates dictionary (dictionary folder) with words from passed txt folder
}