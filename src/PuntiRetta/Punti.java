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
	
	public boolean uguali(Punti p1, Punti p2)
	{
		boolean stato = false;
		if(p1.getX()==p2.getX() && p1.getY()==p2.getY())
		{
			stato = true;
		}
		else
		{
			System.out.println("I due punti sono uguali, reinseriscili");
		}
		
		return stato;
	}
	
		
	
}
