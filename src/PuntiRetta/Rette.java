package PuntiRetta;

import java.text.DecimalFormat;

public class Rette 
{
	private double m;
	private double q;
	private boolean verticale;//Indica se la retta è verticale o meno
	private final String FORMATO_DECIMALE = "#.##";
	
	public Rette(Punti p1, Punti p2) //costruttore della retta dati i due punti (a patto che non coincidano)
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
			throw new IllegalArgumentException("Punti Uguali");//I due punti coincidono: la retta non può essere definita
		}
	}
	
	public String equazione() //restituisce l'equazione della retta
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
	
	public String equazioneFormatted() //restituisce l'equazione della retta con due cifre decimali
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
	
	public boolean appartenenza(Punti p3) //verifica se il punto p3 ricevuto come parametro appartiene alla retta
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
