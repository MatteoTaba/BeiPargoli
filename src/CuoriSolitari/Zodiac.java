package CuoriSolitari;

public enum Zodiac 
{
	Acquario, Pesci, Ariete, Toro, Gemelli, Cancro, Leone, Vergine, Bilancia, Scorpione, Sagittario, Capricorno;
	
	public static Zodiac acquireZodiacSign(String inputText)
	{
		boolean checkSign=false;
		Zodiac insertedSign=null;
		
		
		
		do
		{
			String inputSign=Utility.acquireStringNoEmpty(inputText);
		
			for(Zodiac sign : Zodiac.values())
			{
				if(sign.toString().equalsIgnoreCase(inputSign))
				{
					insertedSign=sign;
					checkSign=true;
					break;
				}
			}
			if(checkSign)
				return insertedSign;
		
		}while(!checkSign);
		
		return null;
	}
}
