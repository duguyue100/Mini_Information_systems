//fileMenu.mdb
//fileInformation Folder
//<fileName>Information.mdb
//fileAttributes Folder
//<fileName>Attributes.mdb (record attributes name and how many lines does table have.
//fileTable Folder
//<fileName>Table.mdb
import java.util.*;
import java.io.*;

public class dbFunction {
	public String fileMainFolder="d:\\mini_db\\";
	public String fileInformation="d:\\mini_db\\fileInformation\\";
	public String fileAttributes="d:\\mini_db\\fileAttributes\\";
	public String fileTable="d:\\mini_db\\fileTable\\";
	public String fileMenu="fileMenu.mdb";
	public String fileNameInformation="Information.mdb";
	public String fileNameAttributes="Attributes.mdb";
	public String fileNameTable="Table.mdb";
	
	public String displayFunctionsMenu()
	{
		Scanner input=new Scanner(System.in);
		
		System.out.println("<------------------------------->" +
				"\n\n" +
				"a. Create a new record" +
				"\n" +
				"b. Enter a existed record" +
				"\n" +
				"c. Display existed record(s) list" +
				"\n" +
				"d. Delete a existed record" +
				"\n" +
				"q. Quit DB" +
				"\n\n" +
				"<------------------------------->\n");
		System.out.println("Please input a, b, c, d or q: ");
		String input_record=input.nextLine();
		
		return input_record;
	}
	
	public void createRecord()
	{
		recordFunctions record=new recordFunctions();
		Scanner getRecordName=new Scanner(System.in);
		
		System.out.print("Please input record's name: ");
		String recordName=getRecordName.nextLine();
		
		this.CreateFile(fileInformation, recordName, fileNameInformation);
		this.CreateFile(fileAttributes, recordName, fileNameAttributes);
		this.CreateFile(fileTable, recordName, fileNameTable);
		
		record.initNewRecord();
	}
	
	public void enterRecord()
	{
		recordFunctions record=new recordFunctions();
		
		record.loadRecord();
		System.out.println("You have already load selected record" +
				"\n" +
				"Here is the function menu:" +
				"\n");
		
		String selectedOptions=record.displayRecordFunctionsMenu();
		
		while (true)
		{
			switch(selectedOptions.charAt(0))
			{
			case 'a' :
			case 'A' :
			{
				break;
			}
			case 'b' :
			case 'B' :
			{
				break;
			}
			case 'c' :
			case 'C' :
			{
				break;
			}
			case 'd' :
			case 'D' :
			{
				break;
			}
			case 'e' :
			case 'E' :
			{
				break;
			}
			case 'f' :
			case 'F' :
			{
				break;
			}
			case 'g' :
			case 'G' :
			{
				break;
			}
			case 'h' :
			case 'H' :
			{
				break;
			}
			case 'q' :
			case 'Q' :
			{
				break;
			}
			default :
			{
				break;
			}
			}
		}
		
	}
	
	public void dispalyRecordMenu()
	{
		//create a file to store menu.
	}
	
	public void deleteExsitedRecord()
	{
		//just delete all related file.
	}
	
	public void quitDb()
	{
		System.out.println("Quit? Really? (Y: Yes; N: No):");
		Scanner input=new Scanner(System.in);
		String input_record=input.nextLine();
		
		if (!input_record.equalsIgnoreCase("Y"))
		{
			return;
		}
		else if (!input_record.equalsIgnoreCase("N"))
		{
			System.out.println("Thank you, good bye!");
			System.exit(0);
		}
	}
	
	public void folderInit()
	{
		File fInformation=new File(fileInformation);
		if (fInformation.exists())
		{
		}
		else
		{
			try
			{
				fInformation.mkdirs();
			}
			catch (Exception e)
			{
				System.out.println("Folder already existed or no enough right to create it");
				System.exit(1);
			}
		}
		
		File fAttributes=new File(fileAttributes);
		if (fAttributes.exists())
		{
		}
		else
		{
			try
			{
				fAttributes.mkdirs();
			}
			catch (Exception e)
			{
				System.out.println("Folder already existed or no enough right to create it");
				System.exit(1);
			}
		}
		
		File fTable=new File(fileTable);
		if (fTable.exists())
		{
		}
		else
		{
			try
			{
				fTable.mkdirs();
			}
			catch (Exception e)
			{
				System.out.println("Folder already existed or no enough right to create it");
				System.exit(1);
			}
		}
		
		File fMenu=new File(fileMainFolder+fileMenu);
		if (fMenu.exists())
		{
		}
		else
		{
			try
			{
				fMenu.createNewFile();
			}
			catch (Exception e)
			{
				System.out.println("Database Menu existed or no enough right to create it");
				System.exit(1);
			}
			
		}
	}
	
	public void CreateFile(String path, String rName, String section)
	{
		File createFile=new File(path+rName+section);
		
		if (createFile.exists())
		{
		}
		try
		{
			createFile.createNewFile();
		}
		catch (Exception e)
		{
			System.out.println("Please check you have righ to write");
			System.exit(1);
		}
	}
}
