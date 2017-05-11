import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;


public class SearcherTest {
	Searcher searcher = new Searcher();
	ArrayList<String> results;

	public SearcherTest() throws URISyntaxException, IOException
	{
		searcher.load();
	}
	
	@Test
	public void NumberOfResultsFromSearchMethodTest() throws IOException
	{
		String[] keyword = {"Cólera", "devida", "Vibrio", "cholerae"};
		
		results = searcher.search(keyword );		
		assertEquals( results.size(), 2 );

	}
	
	@Test
	public void searchMethodTest1() throws IOException
	{
		String[] keyword = {"Cólera", "devida", "Vibrio", "cholerae"};	
		results = searcher.search( keyword );		
		assertTrue( results.contains( "A000,Cólera devida a Vibrio cholerae 01") && results.contains( "A001,Cólera devida a Vibrio cholerae 01"));
	}
	
	@Test
	public void searchMethodTest2() throws IOException
	{
		String[] keyword = {"M9989/1", "Síndrome", "mielodisplásica", "SOE"};	
		results = searcher.search( keyword );		
		assertTrue( results.contains( "M9989/1,Síndrome mielodisplásica SOE"));
	}
	
	@Test
	public void allLinesAreLoaded() throws IOException
	{
		results = searcher.getListOfDiseases();
		
		assertEquals( results.size(), 10774 );
	}
	
	@Test
	public void multipleSearchsTest() throws IOException
	{
		String[] keyword = {"M9989/1", "Síndrome", "mielodisplásica", "SOE"};	
		
		for( int i = 0; i < 10000; i++ )
		{
			results = searcher.search( keyword );		
			assertTrue( results.contains( "M9989/1,Síndrome mielodisplásica SOE"));
		}
	}
	
	@Test
	public void doesNotIgnorePreposition() throws IOException
	{
		String[] keyword = {"devida", "a", "Shigella"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 4, results.size() );
	}
	
	@Test
	public void searchForDescription() throws IOException
	{
		String[] keyword = {"dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 2, results.size() );
	}
	
	@Test
	public void searchForCodeAndDescription() throws IOException
	{
		String[] keyword = {"90", "dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 1, results.size() );
	}
	
	@Test
	public void returnsNullWhenNoResultsAreFound() throws IOException
	{
		String[] keyword = {"9099", "dengue", "inexistente"};	
		
		results = searcher.search( keyword );
		
		assertEquals( null, results );
	}
	
	@Test
	public void doesNotFindWithCommaBetweenCodeAndDescription() throws IOException
	{
		String[] keyword = {"90,Dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( null, results );
	}
	
	@Test
	public void searchIsCaseInsensitive() throws IOException
	{
		String[] keyword = {"Dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 2, results.size() );
	}
	
	@Test
	public void searchReturnsCorrectCaseAndAccent() throws IOException
	{
		String[] keyword = {"dengue", "classico"};	
		
		results = searcher.search( keyword );
		
		assertNotNull(results);
		assertEquals( 1, results.size() );
		assertEquals( "A90 Dengue [dengue clássico]", results.get(0) );
	}
	
}
