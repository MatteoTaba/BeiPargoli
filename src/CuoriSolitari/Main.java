package CuoriSolitari;

public class Main 
{
	public static void Saluto()
	{
		System.out.println("Ciao! Questo programma calcola l'affinità tra due persone da te scelte.");
	}
	
	public static Person acquirePerson()
	{
		Person p;
		String name;
		int age;
		char gender;
		
		System.out.println("Inserisci il nome: ");
		name=Utility.acquireString();
		
		System.out.println("Inserisci l'età: ");
		age=Utility.acquireInt();
		
		System.out.println("Inserisci il sesso [M/F]: ");
		gender=Utility.acquireChar();
		
		p=new Person(name, age, gender);
		
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
