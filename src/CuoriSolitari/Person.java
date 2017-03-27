package CuoriSolitari;

public class Person 
{
	private String name;
	private int age;
	private char gender;
	private Zodiac zodiacSign;
	private Zodiac addictedSign;
/*	private static final char MALE='M';
	private static final char FEMALE='F';
*/
	private static final short THRESHOLD=5;
	
	public Person(){
	}
	
	public Person(String name, int age, char gender, Zodiac zodiacSign, Zodiac addictedSign)
	{
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.zodiacSign=zodiacSign;
		this.addictedSign=addictedSign;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public char getGender()
	{
		return gender;
	}
	public boolean affinityCalculation(Person subject2)
	{
		if(this.gender != subject2.gender && this.age-subject2.age<=THRESHOLD && this.age-subject2.age>=-THRESHOLD && this.zodiacSign==subject2.addictedSign)
		{
			return true;
		}
		
		return false;
	}
	
	
	
}
