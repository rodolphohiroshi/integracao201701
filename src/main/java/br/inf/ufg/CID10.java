package br.inf.ufg;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.ListIterator;

public class CID10 
{
	private ArrayList<String> listOfCID10Diseases;
	private ArrayList<String> normalizedListOfCID10Diseases;
	
	public ArrayList<String> get() {
		return listOfCID10Diseases;
	}
	
	//Método load carrega arquivo CID10.csv dentro de um arraylist de strings, remove as virgulas e normaliza as linhas.
	public void load() throws IOException, ClassNotFoundException
	{		
		InputStream configStream = getClass().getResourceAsStream("CID-10.java-arraylist-serialized");
		ObjectInputStream ois = new ObjectInputStream(configStream);
		
		listOfCID10Diseases = (ArrayList<String>) ois.readObject();
		normalizedListOfCID10Diseases = normalizeStringArrayList(listOfCID10Diseases);
		configStream.close();
		ois.close();
	}
	
	public void unload() throws Throwable
	{
		finalize();
	}
	
	public ArrayList<String> search(String[] keywords )
	{
		if(listOfCID10Diseases == null) {
			throw new IllegalStateException("Você deve chamar o método load() antes de utilizar o método search.");
		}
		
		ArrayList<String> results = new ArrayList<String>();
		ListIterator<String> iteradorLista = normalizedListOfCID10Diseases.listIterator();
		String line;
		boolean lineMatch = false;
		
		String[] normalizedKeywords = normalizeStringArray(keywords);
		
		while( iteradorLista.hasNext() )
		{
			line = iteradorLista.next();
						
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
				results.add(listOfCID10Diseases.get(iteradorLista.nextIndex() - 1));
			}		
		}
		
		if( results.isEmpty() ) {
			return null;
		}
		else {
			return results;
		}
	}
	
	// Normaliza as strings em um array de Strings
	private static ArrayList<String> normalizeStringArrayList(ArrayList<String> stringArray) {
		ArrayList<String> normalizedStringArrayList = new ArrayList<String>();
		
		for(String word : stringArray )
		{
			normalizedStringArrayList.add(normalizeString(word));
		}
		
		return normalizedStringArrayList;
	}
	
	// Normaliza as strings em um array de Strings
	private static String[] normalizeStringArray(String[] stringArray) {
		String[] normalizedStringArray = new String[stringArray.length];
		int i = 0;
		
		for(String word : stringArray )
		{
			normalizedStringArray[i] = normalizeString(word);
			i++;
		}
		
		return normalizedStringArray;
	}
	
	// Remove acentos e deixa todas as letras em caixa baixa.
	private static String normalizeString(String str) {
		return removeAccent(str).toLowerCase();
	}
	
	// Remove acentos da String
	private static String removeAccent(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}