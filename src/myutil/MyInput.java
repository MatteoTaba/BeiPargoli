package myutil;

import java.util.Scanner;

public class MyInput {
	private static Scanner keyboard=new Scanner(System.in);
	private static final String NEWLINE=System.getProperty("line.separator");
	
	public static String acquireString()
	{
		String stringa;
		keyboard.useDelimiter(NEWLINE);
		do{
			stringa=keyboard.next();
		}while(stringa.trim().equals(""));
		
		return stringa;
	}
	
	public static String acquireString(String inputText)
	{
		String stringa;
		keyboard.useDelimiter(NEWLINE);
		do{
			System.out.print(inputText);
			stringa=keyboard.next();
		}while(stringa.trim().equals(""));
		
		return stringa;
	}
	
	public static String acquireStringAlsoEmpty()
	{
		String stringa;
		keyboard.useDelimiter(NEWLINE);
		stringa=keyboard.next();
		
		return stringa;
	}
	
	public static String acquireStringAlsoEmpty(String inputText)
	{
		String stringa;
		keyboard.useDelimiter(NEWLINE);
		System.out.print(inputText);
		stringa=keyboard.next();
		
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
	
	public static int acquireInt(int from, int to){
		int intero;
		do{
			intero=keyboard.nextInt();
		}while(intero < from || intero > to);
		
		return intero;
	}
	
	public static int acquireInt(int from, int to, String inputText){
		int intero;
		do{
			System.out.print(inputText);
			intero=keyboard.nextInt();
		}while(intero < from || intero > to);
		
		return intero;
	}

	public static int acquireIntPositive()
	{
		int interopos;
		do{
			interopos=keyboard.nextInt();
		}while(interopos<=0);
		
		return interopos;
	}

	public static int acquireIntPositive(String inputText)
	{
		int interopos;
		do{
			System.out.print(inputText);
			interopos=keyboard.nextInt();
		}while(interopos<=0);
		
		return interopos;
	}
	
	public static float acquireFloat()
	{
		float floatNumber;
		floatNumber=keyboard.nextFloat();
		
		return floatNumber;
	}
	
	public static float acquireFloat(String inputText)
	{
		float floatNumber;
		System.out.print(inputText);
		floatNumber=keyboard.nextFloat();
		
		return floatNumber;
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
			age=MyInput.acquireInt(inputText);
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
				age=MyInput.acquireInt(inputText);
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
}
