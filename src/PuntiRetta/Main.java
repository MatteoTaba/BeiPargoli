package PuntiRetta;

public class Main
{
	public static void main(String[] args)
	{
		Punti punto1=new Punti(2,2);
		Punti punto2=new Punti(3,3);
		Punti punto3=new Punti(0,0);
		
		double distanza;
		
		Rette retta=new Rette(punto1, punto2);
		
		
		
		distanza=punto1.distance(punto2);
		System.out.println(distanza);
		
		String equazione=retta.equazione(punto1, punto2);
		System.out.println(equazione);
		
		String appartiene=retta.appartenenza(punto3);
		System.out.println(appartiene);
		
	}
}
