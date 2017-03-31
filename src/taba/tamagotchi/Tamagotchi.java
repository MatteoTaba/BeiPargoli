package taba.tamagotchi;

public class Tamagotchi 
{
	private String name;
	private float satisfactionGrade;
	private float fullGrade;
	
	private static final float FULLPERBISCUITPERCENT=10;
	private static final float SATISFACTIONPERCARESS=2;
	private static final float FULLPERCARESS=SATISFACTIONPERCARESS/2;
	
	private static final int MAXIMUM=100;
	private static final int MINIMUM=0;
	
	private static final int SATISFACTIONTHRESHOLD=30;
	private static final int MINIMUMFULLTHRESHOLD=30;
	private static final int MAXIMUMFULLTHRESHOLD=90;
	
	public Tamagotchi() 
	{
		
	}

	public Tamagotchi(String name,float satisfactionGrade, float fullGrade)
	{
		this.name=name;
		this.satisfactionGrade=satisfactionGrade;
		this.fullGrade=fullGrade;
		
	}
	
	public void eatBiscuit(int quantity)
	{
		for(int i=0;i<quantity;i++)
		{
			fullGrade+=((int)fullGrade*(FULLPERBISCUITPERCENT/100));
		}
		satisfactionGrade=((int)satisfactionGrade-(quantity/4));
	}
	
	public void getCaress(int quantity)
	{
		satisfactionGrade=((int)satisfactionGrade-SATISFACTIONPERCARESS);
		fullGrade=((int)fullGrade-FULLPERCARESS);
		
	}
	
	public boolean die()
	{
		if(fullGrade<=MINIMUM || satisfactionGrade<=MINIMUM || fullGrade>=MAXIMUM)
		{
			System.out.println("Hai fatto morire il tuo animaletto, complimenti");
			return true;
		}
		else
			return false;
	}
	
	public boolean unhappy()
	{
		if(satisfactionGrade<=SATISFACTIONTHRESHOLD || fullGrade<=MINIMUMFULLTHRESHOLD || fullGrade>=MAXIMUMFULLTHRESHOLD)
		{
			System.out.println("Il tuo animaletto " +this.getName()+" è infelice");
			return true;
		}
		else 
		{
			System.out.println("Il tuo animaletto " +this.getName()+" è felice");
			return false;
		}
	}
	
	public String getName()
	{
		return name;
	}
	
	public float getFullGrade()
	{
		return fullGrade;
	}
	
	public float getSatisfactionGrade()
	{
		return satisfactionGrade;
	}
	
	public String toString()
	{
		return ("Il tamagotchi " + this.getName() + " ha grado di sazietà " + this.getFullGrade() + " e grado di soddisfazione " + this.getSatisfactionGrade());
	}
	
}
