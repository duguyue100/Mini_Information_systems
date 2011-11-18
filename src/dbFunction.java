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
	public String[] records=new String[1000];
	public common_functions commonFunctions=new common_functions();
	
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
		System.out.print("Please input a, b, c, d or q: ");
		String input_record=input.nextLine();
		
		return input_record;
	}
	
	public void createRecord()
	{
		recordFunctions record=new recordFunctions();
		Scanner getRecordName=new Scanner(System.in);
		
		System.out.print("Please input record's name: ");
		String recordName=getRecordName.nextLine();
		File checkexists=new File(fileInformation+recordName+fileNameInformation);
		
		if (!checkexists.exists())
		{	
			record.initNewRecord(recordName);
			this.CreateFile(fileInformation, recordName, fileNameInformation);
			this.CreateFile(fileAttributes, recordName, fileNameAttributes);
			this.CreateFile(fileTable, recordName, fileNameTable);
			record.loadRecord(recordName);
			record.updateRecordInformation();
		}
		
		commonFunctions.clearscreen();
	}
	
	public void enterRecord()
	{
		recordFunctions record=new recordFunctions();
		
		System.out.print("Please enter record's name: ");
		Scanner enterRecordInput=new Scanner(System.in);
		String enterrecordInput=enterRecordInput.nextLine();
		record.loadRecord(enterrecordInput);
		
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
				record.updateRecordInformation();
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
				commonFunctions.clearscreen();
				return;
			}
			default :
			{
				break;
			}
			}
		}
		
	}
	
	public void displayRecordMenu()
	{
		Scanner displayRecord=null;
		
		try
		{
			displayRecord=new Scanner(new File(fileMainFolder+fileMenu));
		}
		catch (Exception e)
		{
			System.out.println("File not existed or no enough right to read!");
			System.exit(1);
		}
		
		while (displayRecord.hasNextLine())
		{
			System.out.println(displayRecord.nextLine());
		}
		
		commonFunctions.pressContinue();
		commonFunctions.clearscreen();
		
	}
	
	public void deleteExsitedRecord()
	{
		//just delete all related file.
		Scanner existedRecordInput=new Scanner(System.in);
		System.out.print("Please input the records name you want to delete: ");
		String existedRecordName=existedRecordInput.nextLine();
		System.out.print("Are you sure? (Yes: Y; No: N): ");
		String yesno=existedRecordInput.nextLine();
		
		if (yesno.equalsIgnoreCase("N"))
		{
		}
		else if (yesno.equalsIgnoreCase("Y"))
		{
			String existedRecordAttributes=fileAttributes+existedRecordName+fileNameAttributes;
			String existedRecordInformation=fileInformation+existedRecordName+fileNameInformation;
			String existedRecordTable=fileTable+existedRecordName+fileNameTable;
			
			File eRAttributes=new File(existedRecordAttributes);
			File eRInformation=new File(existedRecordInformation);
			File eRTable=new File(existedRecordTable);
			
			try
			{
				eRAttributes.delete();
				eRInformation.delete();
				eRTable.delete();
			}
			catch (Exception e)
			{
				System.out.println("No enough right to delete");
				System.exit(1);
			}
			deleteRecordfromMenu(existedRecordName);
			System.out.println("Record is deleted successfully.");
		}
		else System.out.println("Illegal input.");
		
		commonFunctions.pressContinue();
		commonFunctions.clearscreen();
	}
	
	public void deleteRecordfromMenu(String recordName)
	{
		Scanner recordsRead=null;
		PrintWriter recordsWrite=null;
		
		try
		{
			recordsRead=new Scanner(new File(fileMainFolder+fileMenu));
		}
		catch (Exception e)
		{
			System.out.println("No such file or no enough right to read.");
			System.exit(1);
		}
		
		int n=0;
		while (recordsRead.hasNextLine())
		{
			String r=recordsRead.nextLine();
			if (!r.equals(recordName))
			{
				records[n]=r;
				n++;
			}
		}
		recordsRead.close();
		
		try
		{
			recordsWrite=new PrintWriter(new File(fileMainFolder+fileMenu));
		}
		catch (Exception e)
		{
			System.out.println("No enough right to write.");
			System.exit(1);
		}
		
		for (int i=0;records[i]!=null;i++)
		{
			recordsWrite.println(records[i]);
		}
		recordsWrite.close();
	}
	
	public void quitDb()
	{
		System.out.print("Quit? Really? (Y: Yes; N: No): ");
		Scanner input=new Scanner(System.in);
		String input_record=input.nextLine();
		
		if (!input_record.equalsIgnoreCase("Y"))
		{
			commonFunctions.clearscreen();
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
		else
		{
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
}
