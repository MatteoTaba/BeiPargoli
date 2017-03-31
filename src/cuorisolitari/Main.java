package cuorisolitari;

public class Main 
{
	public static void Saluto()
	{
		System.out.println("Ciao! Questo programma calcola l'affinita' tra due persone da te scelte.");
	}
	
	public static Person acquirePerson()
	{
		Person p;
		String name;
		int age;
		char gender;
		Zodiac mySign;
		Zodiac addictedSign;
		
		name=Utility.acquireStringNoEmpty("Inserisci il nome : ");

		age=Utility.acquireAge("Inserisci l'eta': ", true);
		
		gender=Utility.acquireGender("Inserisci il sesso [M/F]: ");
		
		mySign=Zodiac.acquireZodiacSign("Inserisci il tuo segno zodiacale: ");
		
		addictedSign=Zodiac.acquireZodiacSign("Inserisci il segno del partner ideale: ");
		
		p=new Person(name, age, gender, mySign, addictedSign);
		
		return p;
		
	}
	
	public static void main (String[] args)
	{
		Saluto();
		
		Person subject=acquirePerson();
		Person subject1=acquirePerson();
		
		if(subject.affinityCalculation(subject1)==true)
		{
			System.out.println("I soggetti "+subject.getName()+" e "+subject1.getName()+" risultano essere affini" );
		}
		else
		{
			System.out.println("I soggetti "+subject.getName()+" e "+subject1.getName()+" risultano non essere affini");
		}
		
	}
}
