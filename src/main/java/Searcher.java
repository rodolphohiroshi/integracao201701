import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Searcher 
{
	private BufferedReader br;
	private ArrayList<String> listOfCID10Diseases = new ArrayList<String>();
	
	public ArrayList<String> getListOfDiseases()
	{
		return listOfCID10Diseases;
	}
	
	public void load() throws IOException
	{
		try 
		{
			br = new BufferedReader(new FileReader("src//main//resources//CID-10.csv"));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String line = "";
		
		while(( line = br.readLine()) != null )
		{
			listOfCID10Diseases.add( line );
			
		}	
	}
	
	public ArrayList<String> search(String[] keywords ) throws IOException 
	{
		List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords));
		
		String line = "";
		ArrayList<String> results = new ArrayList<String>();
		Iterator<String> iteradorLista = listOfCID10Diseases.iterator();
		
		while( iteradorLista.hasNext() )
		{
			line = iteradorLista.next();
			
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