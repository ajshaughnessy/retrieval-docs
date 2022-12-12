/**
* This is my code! It’s goal is to search through documents and create a map
* CS 312 - Assignment 9
* @author Aidan Shaughnessy
*/

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class SearchEngine
{
	protected HashMap<String, Set<Document>> invertedIndex;
 	protected StopList stop;
  	protected boolean display;

	public SearchEngine(StopList stop)
	{
    		invertedIndex = new HashMap<>();
    		this.stop = stop;
  	}

	/*
	 * purpose: creates index of document
	 * input: document
	 * output: none (creates index)
	 */
  	public void makeIndex(Document doc)
  	{
		Set<String> hold = makeClear(doc);
    		for(String s: hold)
    		{
      			if (invertedIndex.containsKey(s))
				invertedIndex.get(s).add(doc);
			else
			{
				Set<Document> documents = new HashSet<Document>();
				documents.add(doc);
				invertedIndex.put(s, documents);
			}
    		}	
  	}

	/*
	 * purpose: creates query
	 * input: string that will represent query
	 * output: none (prints query)
	 */
  	public void query(String q)
  	{
    		Set<Document> queryDoc = invertedIndex.get(q);
    		for (Document d : queryDoc)
    		{
      			System.out.println(d);
    		}
  	}


	/*
	 * purpose: clears stop words
	 * input: document to clear
	 * output: cleared set
	 */
	public Set<String> makeClear(Document doc)
  	{
		String contains = doc.iterator().toString();
		Set<String> clear = new HashSet<String>();
		for(String s : doc)
		{
			if(!stop.containsStopWord(s) && !clear.contains(s))
				clear.add(s);
		}
		return clear;
  	}

	/*
	 * purpose: displays all in invertedIndex
	 * input: none
	 * output: none (prints invertedIndex)
	 */
  	public void displayAll()
  	{
		System.out.println(invertedIndex.toString());
  	}
}
