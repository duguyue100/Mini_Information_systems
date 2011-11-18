//Main structure of this Relational Database.
//Author: Hu Yuhuang.
//E-mail: duguyue@gmail.com
//Website: http://www.dgyblog.com/
//If you find any bug or any problem, please connect me with above ways.


public class Information_system_main {
	public static void main(String args[])
	{
		WelcomeMessage welcome=new WelcomeMessage();
		dbFunction function = new dbFunction();
		String return_record="";
		
		welcome.displayWelcome();
		function.folderInit();
		return_record=function.displayFunctionsMenu();
		
		while (true)
		{
			switch(return_record.charAt(0))
			{
			case 'a' :
			case 'A' :
			{
				function.createRecord();
				break;
			}
			case 'b' :
			case 'B' :
			{
				function.enterRecord();
				break;
			}
			case 'c' :
			case 'C' :
			{
				function.displayRecordMenu();
				break;
			}
			case 'd' :
			case 'D' :
			{
				function.deleteExsitedRecord();
				break;
			}
			case 'q' :
			case 'Q' :
			{
				function.quitDb();
				break;
			}
			default  :
			{
				System.out.println("Illgeal input, try again.");
				break;
			}
			}
			return_record=function.displayFunctionsMenu();
		}
		
	}
}
