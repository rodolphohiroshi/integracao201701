package br.inf.ufg;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.junit.Test;


public class CID10Test {
	CID10 searcher;
	ArrayList<String> results;

	public CID10Test() throws URISyntaxException, IOException
	{
		searcher = new CID10();
		searcher.load();
	}
	
	@Test
	public void doesNotIgnorePrepositionTest() throws IOException
	{
		String[] keyword = {"devida", "a", "Shigella"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 4, results.size() );
	}
	
	@Test
	public void searchForDescriptionTest() throws IOException
	{
		String[] keyword = {"dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 2, results.size() );
	}
	
	@Test
	public void searchForCodeAndDescriptionTest() throws IOException
	{
		String[] keyword = {"90", "dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 1, results.size() );
	}
	
	@Test
	public void returnsNullWhenNoResultsAreFoundTest() throws IOException
	{
		String[] keyword = {"9099", "dengue", "inexistente"};	
		
		results = searcher.search( keyword );
		
		assertEquals( null, results );
	}
	
	@Test
	public void doesNotFindWithCommaBetweenCodeAndDescriptionTest() throws IOException
	{
		String[] keyword = {"90,Dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( null, results );
	}
	
	@Test
	public void searchIsCaseInsensitiveTest() throws IOException
	{
		String[] keyword = {"Dengue"};	
		
		results = searcher.search( keyword );
		
		assertEquals( 2, results.size() );
	}
	
	@Test
	public void searchReturnsCorrectCaseAndAccentTest() throws IOException
	{
		String[] keyword = {"dengue", "classico"};	
		
		results = searcher.search( keyword );
		
		assertNotNull(results);
		assertEquals( 1, results.size() );
		assertEquals( "A90 Dengue [dengue clássico]", results.get(0) );
	}
	
	@Test
	public void multipleSearchsTest() throws IOException
	{
		String[] keyword = {"M9989/1", "Síndrome", "mielodisplásica", "SOE"};	
		
		for( int i = 0; i < 1000; i++ )
		{
			results = searcher.search( keyword );		
			assertTrue( results.contains( "M9989/1 Síndrome mielodisplásica SOE"));
		}
	}
	
	@Test(expected=IllegalStateException.class)
	public void throwsIllegalStateExceptionWithoutLoadTest() throws IOException
	{
		String[] keyword = {"devida", "a", "Shigella"};
		
		CID10 searcherWithoutLoad = new CID10();
		
		results = searcherWithoutLoad.search( keyword );		
	}
	
}
