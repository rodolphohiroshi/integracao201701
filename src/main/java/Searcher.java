import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Searcher 
{
	public ArrayList<String> search(BufferedReader br, String[] keywords ) throws IOException 
	{
		List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords));
		
		String line = "";
		ArrayList<String> results = new ArrayList<String>();
		
		while ((line = br.readLine()) != null) {
			boolean lineMatch = false;
			Iterator<String> iterador = keywordsList.iterator();
			
			while(iterador.hasNext())
			{
				String palavra = iterador.next();
				if( line.contains( palavra ) )
				{
					lineMatch = true;
				}
				else
				{
					lineMatch = false;
				}
			}
			
			if( lineMatch == true )
			{
				results.add(line);
			}
		}
		return results;
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