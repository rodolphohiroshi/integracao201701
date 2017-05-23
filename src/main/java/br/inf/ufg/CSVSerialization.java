package br.inf.ufg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CSVSerialization {
	 public static void main(String [] args) throws IOException, ClassNotFoundException
	   {
		 	CID10 searcher = new CID10();
		 	searcher.load();
		   ArrayList<String> al= searcher.get();
		
		   try{
		     FileOutputStream fos= new FileOutputStream("CID-10.utf-8.java-arraylist-serialized");
		     ObjectOutputStream oos= new ObjectOutputStream(fos);
		     oos.writeObject(al);
		     oos.close();
		     fos.close();
		   }catch(IOException ioe){
		        ioe.printStackTrace();
		    }
	   }
}
