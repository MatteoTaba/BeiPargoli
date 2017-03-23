package PuntiRetta;

import java.text.DecimalFormat;

public class Punti 
{
	private double x;
	private double y;
	private final String FORMATO_DECIMALE = "#.##";
	
	public Punti(double x, double y) //costruttore date le coordinate del punto
	{
		this.x=x;
		this.y=y;
	}
	
	public double getX() //restituisce la x del punto
	{
		return x;
	}
	
	public double getY() //restituisce la y del punto
	{
		return y;
	}
	
	public double distance(Punti punto2) //calcola la distanza del punto dal punto2 ricevuto come parametro
	{
		return  Math.sqrt (Math.pow ( (x-punto2.getX() ), 2) + Math.pow( (y-punto2.getY() ), 2) );
	}
	
	public boolean equals(Punti p2) //verifica se il punto p2 ricevuto come parametro coincide con il punto
	{
		boolean stato = false;
		if(this.x==p2.x && this.y==p2.y)
		{
			stato = true;
		}		
		return stato;
	}
	
	public String toString() //traduzione delle coordinate del punto in stringa
	{
		return "("+this.x+","+this.y+")";
	}
	
	public String toStringFormatted() //traduzione delle coordinate del punto in stringa con due cifre decimali
	{
		DecimalFormat numero = new DecimalFormat(FORMATO_DECIMALE);
		return "("+numero.format(this.x)+","+numero.format(this.y)+")";
	}
}
