package gruppoA.util;

import java.util.*;

public class KeyboardInput 
{
	private static Scanner keyboard=new Scanner(System.in);
	private static final String NEWLINE=System.getProperty("line.separator");
	
	public static String acquireString()
	{
		String stringa;
		keyboard.useDelimiter(NEWLINE);
		stringa=keyboard.next();
		
		return stringa;
	}
	
	public static String acquireStringNoEmpty(String inputText)
	{
		String stringa;
		keyboard.useDelimiter(NEWLINE);
		do{
			System.out.print(inputText);
			stringa=keyboard.next();
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
	
	public static float acquireFloat(String inputText)
	{
		int virgola;
		System.out.print(inputText);
		virgola=keyboard.nextInt();
		
		return virgola;
	}
	
	public static float acquireFloat()
	{
		int virgola;
		virgola=keyboard.nextInt();
		
		return virgola;
	}
	
}