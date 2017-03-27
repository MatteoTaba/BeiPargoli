package lanzi.tamagotchi;

public class Main{
	public static void main(String args[]){
		
		Saluto();
		float fullGrade=Utility.acquireFloat("Inserisci sazieta' iniziale : ");
		float satisfactionGrade=Utility.acquireFloat("Inserisci soddisfazione iniziale : ");
		String name=Utility.acquireString("Inserisci il nome (opzionale) : ");
		Tamagotchi tam;
		if(name.trim().equals(""))
			tam=new Tamagotchi(fullGrade, satisfactionGrade);
		else
			tam=new Tamagotchi(name, fullGrade, satisfactionGrade);
		
		while(!tam.dead()){
			System.out.println("--------------------------------------");
			System.out.println("Grado sazieta' : "+tam.getFullGrade());
			System.out.println("Grado soddisfazione : "+tam.getSatisfactionGrade());
			System.out.println("Infelice : "+tam.unhappy());
			String in;
			do{
				in=Utility.acquireStringNoEmpty("Inserisci comando [Carezza/Biscotto] : ").trim();
				if(in.equalsIgnoreCase("carezza"))
				{
					int quantity=Utility.acquireInt("Inserisci quantita' : ");
					tam.receiveCaress(quantity);
				}
				else if(in.equalsIgnoreCase("biscotto"))
				{
					int quantity=Utility.acquireInt("Inserisci quantita' : ");
					tam.eatBiscuit(quantity);
				}
			}while(!in.equalsIgnoreCase("carezza") && !in.equalsIgnoreCase("biscotto"));
		}
		System.out.println(tam.getName()+" e' morto.");
	}
	
	private static void Saluto(){
		System.out.println("Benvenuto, inizializza il tuo nuovo tamagotchi");
	}
}