package br.ufg.inf;
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
	
	/**
	 * Carrega a lista de doenças do CID10 em memória.
	 * <p>
	 * Carrega a lista de doenças do CID10 em memória, caso a
	 * mesma ainda não tenha sido carregada. Caso o método
	 * seja invocado novamente, nada irá acontecer.
	 */
	public void load() throws IOException, ClassNotFoundException
	{	
		if(listOfCID10Diseases == null) {
			InputStream configStream = getClass().getResourceAsStream("CID-10.java-arraylist-serialized");
			ObjectInputStream ois = new ObjectInputStream(configStream);
			
			listOfCID10Diseases = (ArrayList<String>) ois.readObject();
			normalizedListOfCID10Diseases = normalizeStringArrayList(listOfCID10Diseases);
			configStream.close();
			ois.close();
		}
	}
	
	/**
	 * Executa as operações necessárias para limpar qualquer recurso
	 * utilizado pela classe.
	 */
	public void unload() throws Throwable
	{
		finalize();
	}
	
	/**
	 * Faz uma busca nas doenças do CID 10 baseado nas palavras-chave
	 * fornecidas na entrada.
	 * <p>
	 * Esse método pode retornar uma lista de String contendo
	 * todos os resultados caso contenha algum, ou null caso não encontre
	 * nenhum. A entrada pode ser o código ou a descrição da doença, não
	 * sendo necessário preencher o código ou descrição por completo.
	 * Retorna uma exceção caso esse método seja invocado sem que a 
	 * lista de doenças do CID10 tenha sido carregada.
	 *
	 * @param  keywords  palavras-chave que serão buscadas
	 * @return      Lista de String contendo um resultado em cada linha ou
	 * 				null caso não tenha resultado
	 * @see #load()
	 */
	public ArrayList<String> search(String[] keywords )
	{
		if(listOfCID10Diseases == null) {
			throw new IllegalStateException("Deve chamar o metodo load() antes de utilizar o metodo search.");
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