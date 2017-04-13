import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SearcherTest {

	Searcher searcher = new Searcher();
	BufferedReader br;
	ArrayList<String> results;

	public SearcherTest() throws FileNotFoundException, URISyntaxException
	{
		br = new BufferedReader(new FileReader("src//main//resources//CID-10.csv"));
	}
	
	@After
	public void setUp()
	{
		results.clear();
	}
	
	@Test
	public void testResultNotNull() throws IOException 
	{		
		results = searcher.searchKeyword(br, "Macumba");
		assertNotNull( results );
	}
	
	@Test
	public void testNumberOfResultsIsRight() throws IOException
	{
		results = searcher.searchKeyword(br, "dengue");
		
		assertEquals(results.size(), 4);
	}
	
	@Test
	public void StringResultIsRight() throws IOException
	{
		results = searcher.searchKeyword(br, "dengue");
		
		String result = results.get(0);
		
		assertTrue( result.contains( "dengue"));
	}
	
	@Test
	public void getKeywordsListNumberOfResultsIsRight() throws Exception
	{
		ArrayList<String> results = searcher.getKeywordsList( "Eu sou um cachorro");
		
		System.out.println( results.size());
		
		assertTrue( 4 == 4 ); 
	}

}
