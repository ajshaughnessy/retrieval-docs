/**
* This is my code! It’s goal is to read documents
* CS 312 - Assignment 9
* @author Aidan Shaughnessy
*/

import java.util.Iterator;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Document implements Iterable<String>
{
	protected static final String DELIMITERPATTERN = "[^a-zA-Z]+";
	protected String name;
	protected String content;

	public Document(String name)
	{
		Path p = Paths.get(name);
		String fileName = p.getFileName().toString(); 
		this.name = fileName;
		readContent(name);
	}

	public Iterator<String> iterator()
	{
		return new Scanner(content).useDelimiter(DELIMITERPATTERN);
	}

	public String toString()
	{
		String ans = "File: " + name + " | Contains: " + content;
		return ans;
	}
	
	/*
	 * purpose: reads content of document
	 * input: name of document
	 * output: none
	 */
	public void readContent(String fileName)
	{
		String asRead = "";
		try
		{
			asRead = new String(Files.readAllBytes(Paths.get(fileName)));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		this.content = asRead;
	}

}
