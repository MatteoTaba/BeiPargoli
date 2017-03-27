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
				in=Utility.acquireStringNoEmpty("Inserisci comando [Carezze/Biscotti] : ").trim();
				int quantity=(int)(Math.random()*10);
				if(in.equalsIgnoreCase("carezze"))
					tam.receiveCaress(quantity);
				else if(in.equalsIgnoreCase("biscotti"))
					tam.eatBiscuit(quantity);
			}while(!in.equalsIgnoreCase("carezze") && !in.equalsIgnoreCase("biscotti"));
		}
		System.out.println(tam.getName()+" e' morto.");
	}
	
	private static void Saluto(){
		System.out.println("Benvenuto, inizializza il tuo nuovo tamagotchi");
	}
	
	private static Tamagotchi createTamagotchi(){
		float fullGrade=Utility.acquireFloat("Inserisci sazieta' iniziale : ");
		float satisfactionGrade=Utility.acquireFloat("Inserisci soddisfazione iniziale : ");
		String name=Utility.acquireString("Inserisci il nome (opzionale) : ");
		Tamagotchi tam;
		if(name.trim().equals(""))
			tam=new Tamagotchi(fullGrade, satisfactionGrade);
		else
			tam=new Tamagotchi(name, fullGrade, satisfactionGrade);
		return tam;
	}
}