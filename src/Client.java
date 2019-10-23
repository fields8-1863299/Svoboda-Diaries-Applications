import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException {
		SvobodaDictionary s1 = new SvobodaDictionary("diary.txt");
		s1.exportCSV("diary.csv");
	}
	
	//updateDictionary(String fileName)
	//Updates dictionary (dictionary folder) with words from passed txt folder
}