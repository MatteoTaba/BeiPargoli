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
			return "x = " + this.q;
		}
		else
		{
			if(this.m==0.0)
				return "y = " + this.q;
			else
				return "y = " + this.m + "x + " + this.q;
		}
		
	}
	
	//TODO metodo equazioneFormatted con DecimalFormatter come parametro
	
	public boolean appartenenza(Punti p3)
	{
		if(verticale==true)
		{
			if(p3.getX()==this.q)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(p3.getY()==(p3.getX()*this.m + this.q))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
	}

}
