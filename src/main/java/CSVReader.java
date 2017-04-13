import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVReader 
{
	public static void main(String[] args ) throws IOException, URISyntaxException
	{
	
		//String keyWord = "amarela";
		
		BufferedReader br = new BufferedReader(new FileReader("src//main//resources//CID-10.csv"));
		ArrayList<String> results = new ArrayList<String>();
		Searcher searcher = new Searcher();
		//results = searcher.searchKeyword(br, keyWord);
		results = searcher.search(br, keyWord);
		
		Iterator<String> iterator = results.iterator();
		
		
		while(iterator.hasNext())
		{
			System.out.println( iterator.next());
		}
	
	}
}
