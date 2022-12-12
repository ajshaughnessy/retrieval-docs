/**
* This is my code! It’s goal is to index stop words
* CS 312 - Assignment 9
* @author Aidan Shaughnessy
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

public class StopList
{
	protected Set<String> stop;

	public StopList(String path)
	{
		try
		{
			List<String> asRead = Files.readAllLines(Paths.get(path));
			stop = new HashSet<>(asRead);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/*
	 * purpose: checks if stoplist contains stop word
	 * input: string of word
	 * output: boolean if there's stop word
	 */
	public boolean containsStopWord(String s)
	{
		return stop.contains(s);
	}

	public String toString()
	{
		return stop.toString();
	}
}
