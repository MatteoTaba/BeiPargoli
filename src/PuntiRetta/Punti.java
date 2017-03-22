package PuntiRetta;

public class Punti 
{
	private double x;
	private double y;
	
	public Punti(double x, double y) //costruttore che inizializza gli attributi
	{
		this.x=x;
		this.y=y;
	}
	
	public double getX() //legge la x del punto
	{
		return x;
	}
	
	public double getY() //legge la y del punto
	{
		return y;
	}
	
	public double distance(Punti punto2) //calcola la distanza
	{
		return  Math.sqrt (Math.pow ( (x-punto2.getX() ), 2) + Math.pow( (y-punto2.getY() ), 2) );
	}
	
	public boolean equals(Punti p2) //verifica dell'uguaglianza dei punti
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
}
