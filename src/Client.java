import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException {
		SvobodaDictionary s1 = new SvobodaDictionary("test1.txt");
		s1.exportCSV("test1.csv", "v");
	}
	
	//updateDictionary(String fileName)
	//Updates dictionary (dictionary folder) with words from passed txt folder
}