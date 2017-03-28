package lanzi.tamagotchi;

public class Main{
	public static void main(String args[]){
		
		Saluto();
		
		Tamagotchi tam=createTamagotchi();
		
		//Tamagotchi running
		while(!tam.dead()){
			System.out.println("--------------------------------------");
			System.out.println(tam.getStats());
			String in;
			do{
				in=Utility.acquireString("Inserisci comando [Carezze/Biscotti] : ").trim();
			}while(!in.equalsIgnoreCase("carezze") && !in.equalsIgnoreCase("biscotti"));
			int quantity=(int)(Math.random()*10);
			if(in.equalsIgnoreCase("carezze"))
			{
				tam.receiveCaress(quantity);
				System.out.println(tam.getName()+" riceve "+quantity+" carezze.");
			}
			else if(in.equalsIgnoreCase("biscotti"))
			{
				tam.eatBiscuit(quantity);
				System.out.println(tam.getName()+" mangia "+quantity+" biscotti.");
			}
		}
		System.out.println(tam.getName()+" e' morto.");
	}
	
	private static void Saluto(){
		System.out.println("Benvenuto, inizializza il tuo nuovo tamagotchi");
	}
	
	private static Tamagotchi createTamagotchi(){
		int fullGrade=Utility.acquireIntPositive("Inserisci sazieta' iniziale : ");
		int satisfactionGrade=Utility.acquireIntPositive("Inserisci soddisfazione iniziale : ");
		String name=Utility.acquireStringAlsoEmpty("Inserisci il nome (opzionale) : ");
		Tamagotchi tam;
		if(name.trim().equals(""))
			tam=new Tamagotchi(fullGrade, satisfactionGrade);
		else
			tam=new Tamagotchi(name, fullGrade, satisfactionGrade);
		return tam;
	}
}