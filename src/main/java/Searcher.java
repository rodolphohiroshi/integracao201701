import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Searcher 
{
	public ArrayList<String> search(BufferedReader br, String keyword )
	{
		ArrayList<String> keywordsList = getKeywordsList( keyword );
		
		Iterator<String> iterator = keywordsList.iterator();
		
		while(iterator.hasNext() )
		{
			
		}
		
		
		return null;
	}
	
	public ArrayList<String> getKeywordsList( String keyword )
	{
		String[] keywordsList = keyword.split(" ");
				
		return new ArrayList<String>( Arrays.asList(keywordsList));
	}
	
	public ArrayList<String> searchKeyword(BufferedReader br, String keyword ) throws IOException 
	{
	
		String line = "";
		ArrayList<String> results = new ArrayList<String>();
		
		while ((line = br.readLine()) != null) {
			
			if( line.contains( keyword))
			{
				results.add(line);
			}
		}
		return results;
	}
}