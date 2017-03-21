package PuntiRetta;

public class Rette 
{
	private double m;
	private double q;
	private boolean verticale;
	
	public Rette(Punti p1, Punti p2)
	{
		if(p1.getX()==p2.getX())
		{
			q=p1.getX();
			verticale=true;
		}
		else
		{
			verticale=false;
			m=(p2.getY() - p1.getY())/(p2.getX() - p1.getX());
			q= p2.getY()-(m*p2.getX());
		}
	}
	
	public String equazione()
	{
		if(verticale==true)
		{
			return "Equazione: x= " + this.q;
		}
		else
		{
			return "Equazione: y= " + this.m + "x + " + this.q;
		}
		
	}
	
	public String appartenenza(Punti p3)
	{
		if(verticale==true)
		{
			if(p3.getX()==this.q)
			{
				return "Il punto è allineato con gli altri";
			}
			else
			{
				return "Il punto non è allineato con gli altri";
			}
		}
		else
		{
			if(p3.getY()==(p3.getX()*this.m + this.q))
			{
				return "Il punto ("+ p3.getX()+","+p3.getY()+") è allineato con gli altri";
			}
			else 
			{
				return "Il punto ("+ p3.getX()+","+p3.getY()+") non è allineato con gli altri";
			}
		}
	}

}
