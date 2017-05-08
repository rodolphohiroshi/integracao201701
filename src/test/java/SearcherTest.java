import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SearcherTest {
	Searcher searcher = new Searcher();
	BufferedReader br;
	ArrayList<String> results;

	public SearcherTest() throws URISyntaxException, IOException
	{
		br = new BufferedReader(new FileReader("src//main//resources//CID-10.csv"));
		searcher.load();
	}
	
	
	@After
	public void setUp()
	{
		results.clear();
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
		
		assertEquals( results.size(), 10943 );
	}
	
	@Test
	public void multipleSearchsTest() throws IOException
	{
		String[] keyword = {"M9989/1", "Síndrome", "mielodisplásica", "SOE"};	
		
		for( int i = 0; i < 1000; i++ )
		{
			results = searcher.search( keyword );		
			assertTrue( results.contains( "M9989/1,Síndrome mielodisplásica SOE"));
		}
	}
	
	/*
	@Test
	public void emptyStringSearch() throws IOException
	{
		String[] keyword = {"", };	
		results = searcher.search(br, keyword );	
		System.out.println( results.size());
		assertTrue( results.isEmpty());
	} */
	
}
