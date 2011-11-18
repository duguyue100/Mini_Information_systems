import java.util.*;
import java.io.*;

public class recordFunctions {
	public String fileMainFolder="d:\\mini_db\\";
	public String fileInformation="d:\\mini_db\\fileInformation\\";
	public String fileAttributes="d:\\mini_db\\fileAttributes\\";
	public String fileTable="d:\\mini_db\\fileTable\\";
	public String fileMenu="fileMenu.mdb";
	public String fileNameInformation="Information.mdb";
	public String fileNameAttributes="Attributes.mdb";
	public String fileNameTable="Table.mdb";
	public common_functions commonFunctions=new common_functions();
	public record_structure record=new record_structure();
	
	public String displayRecordFunctionsMenu()
	{
		System.out.print("<------------------------------->" +
				"\n\n" +
				"a. Update Record Information" +
				"\n" +
				"b. Add New Attribute" +
				"\n" +
				"c. Delete New Attribute" +
				"\n" +
				"d. Add Data" +
				"\n" +
				"e. Delete Data" +
				"\n" +
				"f. Sort" +
				"\n" +
				"g. Display Record" +
				"\n" +
				"h. Command Line" +
				"\n" +
				"q. Quit" +
				"\n\n" +
				"<------------------------------->" +
				"\n" +
				"Please input a, b, c, d, e, f, g, h or q: ");
		Scanner rInput=new Scanner(System.in);
		String rInputOptions=rInput.nextLine();
		
		return rInputOptions;
	}
	
	public void initNewRecord(String recordName)
	{
		try
		{
			FileWriter initRecord=new FileWriter(new File(fileMainFolder+fileMenu),true);
			initRecord.write(recordName+"\n");
			initRecord.close();
		}
		catch (Exception e)
		{
			System.out.println("File not existed or no enough right to write");
			System.exit(1);
		}
	}
	
	public void updateRecordInformation()
	{
		//rename all related information.
		//include author, company, contact and other information
		//of creator of the record.
		Scanner recordInformationInput=new Scanner(System.in);
		
		System.out.println("<------------------------------->" +
				"Owner's Information");
		System.out.print("Name: ");
		String ownerInformation=recordInformationInput.nextLine();
		System.out.print("Are you sure? (Y: Yes, N: No): ");
		String check=recordInformationInput.nextLine();
		if (check.charAt(0)=='y'||check.charAt(0)=='Y')
		{
			record.recordInformation[0]=ownerInformation;
		}
		
		System.out.print("E-mail Address: ");
		String emailInformation=recordInformationInput.nextLine();
		System.out.print("Are you sure? (Y: Yes, N: No): ");
		check=recordInformationInput.nextLine();
		if (check.charAt(0)=='y'||check.charAt(0)=='Y')
		{
			record.recordInformation[1]=emailInformation;
		}
		System.out.print("Phone Number: ");
		String phoneInformation=recordInformationInput.nextLine();
		System.out.print("Are you sure? (Y: Yes, N: No): ");
		check=recordInformationInput.nextLine();
		if (check.charAt(0)=='y'||check.charAt(0)=='Y')
		{
			record.recordInformation[2]=phoneInformation;
		}
		System.out.print("Homepage: ");
		String homepageInformation=recordInformationInput.nextLine();
		System.out.print("Are you sure? (Y: Yes, N: No): ");
		check=recordInformationInput.nextLine();
		if (check.charAt(0)=='y'||check.charAt(0)=='Y')
		{
			record.recordInformation[3]=homepageInformation;
		}
		System.out.println("<------------------------------->");
		System.out.println("Your information has updated.");
		
		commonFunctions.pressContinue();
		commonFunctions.clearscreen();
	}
	
	public void loadRecord(String recordName)
	{
		
	}
	
	public void addItem()
	{
		
	}
	
	public void sortOptions()
	{
		
	}
	
	public void displayRecord()
	{
		
	}
	
	public void searchOptions()
	{
		
	}
	
	public void deleteItem()
	{
		
	}
}
