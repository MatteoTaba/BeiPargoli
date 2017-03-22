package PuntiRetta;

import java.text.DecimalFormat;

public class Rette 
{
	private double m;
	private double q;
	private boolean verticale;
	private final String FORMATO_DECIMALE = "#.##";
	
	public Rette(Punti p1, Punti p2) //costruttore con compito di calcolare m e q, verificare la diversità e la verticalità dei punti
	{
		if(p1.equals(p2)==false)
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
		else
		{
			throw new IllegalArgumentException("Punti Uguali");//I due punti coincidono: la retta non pu� essere definita
		}
	}
	
	public String equazione() //elaborazione dell'equazione
	{
		if(verticale==true)
		{
			return "x = " + this.q;
		}
		else
		{
			if(this.m==0.0)
				return "y = " + this.q;
			else if(this.q > 0)
			{
				return "y = " + this.m + "x+" + this.q;
			}
			else
			{
				return "y = " + this.m + "x" + this.q;
			}
		}		
	}
	
	public String equazioneFormatted() //elaborazione dell'equazione
	{
		DecimalFormat numero = new DecimalFormat(FORMATO_DECIMALE);
		if(verticale==true)
		{
			return "x = " + numero.format(this.q);
		}
		else
		{
			if(this.m==0.0)
				return "y = " + numero.format(this.q);
			else if(this.q > 0)
			{
				return "y = " + numero.format(this.m) + "x+" + numero.format(this.q);
			}
			else
			{
				return "y = " + numero.format(this.m) + "x" + numero.format(this.q);
			}
		}		
	}
	
	public boolean appartenenza(Punti p3) //verifica se il terzo punto appartiene alla retta
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
