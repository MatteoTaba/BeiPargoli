package PuntiRetta;

public class Main
{
	public static void main(String[] args)
	{
		Punti punto1=new Punti(5,3);
		Punti punto2=new Punti(5,2);
		Punti punto3=new Punti(0,2);
		double distanza;
		
		Rette retta=new Rette(punto1, punto2);
		
		distanza=punto1.distance(punto2);
		System.out.println("Distanza tra "+punto1.toString()+" e "+punto2.toString()+" = "+distanza);
		
		String equazione=retta.equazione();
		System.out.println("Equazione retta : "+equazione);
		
		String equazioneFormattata=retta.equazioneFormatted();
		System.out.println("Equazione formattata retta : "+equazioneFormattata);
		
		boolean appartiene=retta.appartenenza(punto3);
		if(appartiene)
			System.out.println("Punto "+punto3.toString()+" appartiene alla retta");
		else
			System.out.println("Punto "+punto3.toString()+" non appartiene alla retta");

	}
}
