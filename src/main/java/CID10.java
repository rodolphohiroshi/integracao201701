import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;

public class CID10 
{
	private BufferedReader br;
	private ArrayList<String> listOfCID10Diseases = new ArrayList<String>();
	private ArrayList<String> normalizedListOfCID10Diseases = new ArrayList<String>();
	
	public ArrayList<String> getListOfDiseases()
	{
		return listOfCID10Diseases;
	}
	
	//Método load carrega arquivo CID10.csv dentro de um arraylist de strings e remove as virgulas.
	public void load() throws IOException
	{
		//Path.separator utiliza o separador de caminhos de diretório apropriado para cada sistema.
		InputStream configStream = getClass().getResourceAsStream("CID-10.csv");
		br = new BufferedReader(new InputStreamReader(configStream));
		
		String line = "";
		
		while(( line = br.readLine()) != null )
		{
			//Elimina a virgula que separa o código e a descrição da doença no arquivo csv
			line = line.replace(',', ' ');
			normalizedListOfCID10Diseases.add(removeAccent(line).toLowerCase());
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
		Iterator<String> iteradorLista = normalizedListOfCID10Diseases.iterator();
		int index = 0;
		
		String[] normalizedKeywords = new String[keywords.length];
		int i = 0;
		
		for(String word : keywords )
		{
			normalizedKeywords[i] = removeAccent(word).toLowerCase();
			i++;
		}
		
		while( iteradorLista.hasNext() )
		{
			line = iteradorLista.next();
			
			boolean lineMatch = false;
			
			for(String word : normalizedKeywords )
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
				results.add(listOfCID10Diseases.get(index));
			}
			
			index++;
		}
		
		if( results.isEmpty() )
			return null;
		else
			return results;
	}
	
	private static String removeAccent(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}