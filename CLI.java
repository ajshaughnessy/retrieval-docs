/**
* This is my code! It’s goal is to create the CLI
* CS 312 - Assignment 9
* @author Aidan Shaughnessy
*/

import java.util.Scanner;

public class CLI
{
	private String [] args;
	protected Boolean db;

	public CLI(String [] a)
	{
		parse();
		this.args = a;
		this.db = false;
	}
	
	private void usage()
	{
		System.out.println("Usage: [-d] <Path to stoplist> <Path to documents>");
	}

	public void parse()
	{
		int count = 0;
		if(args.length == 0)
		{
			usage();
		}

		if("-d".equals(args[count]))
		{
			this.db = true;
			count++;
		}
		
		if(args.length > count)
		{
			StopList stop = new StopList(args[count]);
			count++;
			System.out.println(stop);
			SearchEngine search = new SearchEngine(stop);
			for(int i = count; i < args.length; i++)
			{
				Document doc = new Document(args[i]);
				//search.makeClear(doc);
				search.makeIndex(doc);
				search.displayAll();
			}
			Scanner scan = new Scanner(System.in);
			while(scan.hasNextLine())
				search.query(scan.nextLine());
		}
	}
	
	public static void main(String [] args)
	{
		CLI cli = new CLI(args);
	}
}	
