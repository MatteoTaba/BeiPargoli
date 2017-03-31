package lanzi.tamagotchi;

public class Main{
	
	private static final String NEWLINE=System.getProperty("line.separator");
	private static final String MSG_BENVENUTO="Benvenuto, inizializza il tuo nuovo tamagotchi";
	private static final String MSG_INS_FULLGRADE="Inserisci sazieta' iniziale : ";
	private static final String MSG_INS_SATISFACTIONGRADE="Inserisci soddisfazione iniziale : ";
	private static final String MSG_INS_NAME="Inserisci il nome (opzionale) : ";
	private static final String MSG_INS_COMMAND="Inserisci comando [Carezze/Biscotti] : ";
	private static final String MSG_RECEIVE_CARESS="%s riceve %d carezze."+NEWLINE;
	private static final String MSG_EAT_BISCUIT="%s mangia %d biscotti."+NEWLINE;
	private static final String MSG_DEAD="%s e' morto."+NEWLINE;
	private static final String MSG_SEPARATOR="------------------------------";
	private static final String MSG_STATS="Grado sazieta' : %d"+NEWLINE+"Grado felicita' : %d"+NEWLINE;
	private static final String MSG_HAPPY="%s e' felice."+NEWLINE;
	private static final String MSG_UNHAPPY="%s NON e' felice."+NEWLINE;
	
	private static final String BISCUIT="biscotti";
	private static final String CARESS="carezze";
	private static final String SECRET_COMMAND="AVADA KEDAVRA";
	
	private static final int MAX_RAND=5;
	
	public static void main(String args[]){
		
		System.out.println(MSG_BENVENUTO);
		
		Tamagotchi tam=createTamagotchi();
		
		//Tamagotchi running
		while(!tam.dead()){
			sendCommand(tam);
			
			printStats(tam);
			System.out.println(MSG_SEPARATOR);
		}
		System.out.printf(MSG_DEAD, tam.getName());
	}

	
	private static Tamagotchi createTamagotchi(){
		int fullGrade=Utility.acquireIntPositive(MSG_INS_FULLGRADE);
		int satisfactionGrade=Utility.acquireIntPositive(MSG_INS_SATISFACTIONGRADE);
		String name=Utility.acquireStringAlsoEmpty(MSG_INS_NAME);
		Tamagotchi tam;
		if(name.trim().equals(""))
			tam=new Tamagotchi(fullGrade, satisfactionGrade);
		else
			tam=new Tamagotchi(name, fullGrade, satisfactionGrade);
		return tam;
	}
	
	private static void printStats(Tamagotchi tamagotchi){
		System.out.printf(MSG_STATS, tamagotchi.getFullGrade(), tamagotchi.getSatisfactionGrade());
		if(tamagotchi.unhappy())
			System.out.printf(MSG_UNHAPPY, tamagotchi.getName());
		else
			System.out.printf(MSG_HAPPY, tamagotchi.getName());
	}
	
	private static void sendCommand(Tamagotchi tamagotchi){
		String in;
		do{
			in=Utility.acquireString(MSG_INS_COMMAND).trim();
		}while(!in.equalsIgnoreCase(CARESS) && !in.equalsIgnoreCase(BISCUIT) && !in.equals(SECRET_COMMAND));

		int quantity=(int)(Math.random()*MAX_RAND)+1;
		if(in.equalsIgnoreCase(CARESS))
		{
			tamagotchi.receiveCaress(quantity);
			System.out.printf(MSG_RECEIVE_CARESS, tamagotchi.getName(), quantity);
		}
		else if(in.equalsIgnoreCase(BISCUIT))
		{
			tamagotchi.eatBiscuit(quantity);
			System.out.printf(MSG_EAT_BISCUIT, tamagotchi.getName(), quantity);
		}
		else
		{
			tamagotchi.setSatisfactionGrade(0);
			tamagotchi.setFullGrade(0);
		}
	}
}