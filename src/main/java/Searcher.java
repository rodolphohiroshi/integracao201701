import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	public void unload() throws Throwable
	{
		br.close();
		finalize();
	}
	
	public ArrayList<String> search(String[] keywords ) throws IOException 
	{
		String line = "";
		ArrayList<String> results = new ArrayList<String>();
		Iterator<String> iteradorLista = listOfCID10Diseases.iterator();
		
		while( iteradorLista.hasNext() )
		{
			line = iteradorLista.next();
			
			boolean lineMatch = false;
			
			for(String word : keywords )
			{
				if( line.contains(word))
				{
					lineMatch = true;
				}
				else
				{
					lineMatch = false;
					break;
				}
			} 
			
			if( lineMatch == true )
			{
				results.add(line);
			}
		}
				
		return results;
	} 
}