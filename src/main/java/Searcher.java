import java.io.BufferedReader;
import java.io.File;
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
			String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "CID-10.csv";
			br = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String line = "";
		
		while(( line = br.readLine()) != null )
		{
			line = line.replace(',', ' ');
			listOfCID10Diseases.add( line );
			
		}
		
		br.close();
	}
	
	public void unload() throws Throwable
	{

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