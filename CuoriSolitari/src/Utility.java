import java.util.*;

public class Utility 
{
	private static Scanner keyboard=new Scanner(System.in);
	
	public static String acquireString()
	{
		String stringa;
		stringa=keyboard.next();
		return stringa;
	}
	
	public static char acquireChar()
	{
		char carattere;
		carattere=keyboard.next().charAt(0);
		return carattere;
	}
	
	public static int acquireInt()
	{
		int intero;
		intero=keyboard.nextInt();
		return intero;
	}
	
	/*public static void closeScanner()
	{
		keyboard.close();
	}
	*/
}
