package CuoriSolitari;
import java.util.*;

public class Utility 
{
	private static Scanner keyboard=new Scanner(System.in);
	
	public static String acquireString()
	{
		String stringa;
		stringa=keyboard.nextLine();
		return stringa;
	}
	
	public static String acquireStringNoEmpty(String inputText)
	{
		String stringa;
		do{
			System.out.print(inputText);
			stringa=keyboard.nextLine();
		}while(stringa.trim().equals(""));
		return stringa;
	}
	
	public static char acquireChar()
	{
		char carattere;
		carattere=keyboard.next().charAt(0);
		return carattere;
	}
	
	public static char acquireChar(String inputText)
	{
		char carattere;
		System.out.print(inputText);
		carattere=keyboard.next().charAt(0);
		return carattere;
	}
	
	public static int acquireInt()
	{
		int intero;
		intero=keyboard.nextInt();
		return intero;
	}
	
	public static int acquireInt(String inputText)
	{
		int intero;
		System.out.print(inputText);
		intero=keyboard.nextInt();
		return intero;
	}
	
	//Specified inputs
	public static char acquireGender(String inputText)
	{
		char carattere;
		do{
			carattere=acquireChar(inputText);
			carattere=Character.toUpperCase(carattere);
		}while(carattere!='M' && carattere!='F');
		return carattere;
	}
	
	public static int acquireAge(String inputText)
	{
		int age;
		do{
			age=Utility.acquireInt(inputText);
			if(age>120)
				System.out.println("Eta' non plausibile");
		}while(age>120);
		return age;
	}
	
	public static int acquireAge(String inputText, boolean requiredAdult)
	{
		int age;
		if(requiredAdult)
		{
			do{
				age=Utility.acquireInt(inputText);
				if(age<18)
					System.out.println("E' richiesto essere maggiorenni");
				else if(age>120)
					System.out.println("Eta' non plausibile");
			}while(age<18 || age>120);
			return age;
		}
		else
		{
			return acquireAge(inputText);
		}
	}
	
	/*public static void closeScanner()
	{
		keyboard.close();
	}
	*/
}
