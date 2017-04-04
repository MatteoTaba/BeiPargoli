package perno.tamagotchi;

import gruppoA.util.*;

/*
 * Contiene il metodo main.
 */
public class Main {
	private static final String SALUTO="Benvenuto!";
	
	/*
	 * Richiede la creazione di un tamagotchi e in seguito permette di interagire con esso.
	 */
	public static void main(String[] args) {
		int comando=0;
		
		saluta();
		
		Tamagotchi t = creaTamagotchi();
		
		for(;comando!=3 && t.isAlive();){
			if(t.isHappy())
				System.out.println(t.getNome() + " è felice!");
			else
				System.out.println(t.getNome() + " è triste!");
			
			System.out.println("1-Accarezza");
			System.out.println("2-Dai biscotto");
			System.out.println("3-Esci");
			
			comando = KeyboardInput.acquireInt();
			
			switch (comando){
			case 1: accarezza(t);
				break;
			case 2: daiBiscotto(t);
				break;
			}
			if(!t.isAlive())
				System.out.println(t.getNome() + " è morto.");
		}
		System.exit(0);
	}
	
	/*
	 * Saluto iniziale all'utente.
	 */
	public static void saluta(){
		System.out.println(SALUTO);
	}
	
	/*
	 * Accarezza il tamagotchi selezionato.
	 */
	private static void accarezza(Tamagotchi t){
		int carezzeEffettive;
		
		carezzeEffettive=t.riceviCarezze(RandomNumbers.randomInt(0, 100));//TODO Definire ostanti
		System.out.println("Carezze effettive:"+ carezzeEffettive+" | " + t.toString());
	}
	
	/*
	 * Da un biscotto al tamagotchi selezionato.
	 */
	private static void daiBiscotto(Tamagotchi t){
		int biscottiEffettivi;
		
		biscottiEffettivi=t.riceviBiscotti(RandomNumbers.randomInt(0, 100));//TODO Definire costanti
		System.out.println("Biscotti effettivi:"+ biscottiEffettivi+" | " + t.toString());
	}
	
	/*
	 * Crea un nuovo tamagotchi.
	 */
	private static Tamagotchi creaTamagotchi(){
		Tamagotchi t;
		String nome;
		int affetto;
		int cibo;
		
		nome=KeyboardInput.acquireString("Nome:");
		
		do{
			affetto=KeyboardInput.acquireInt(0,100,"Affetto (0-100):");
		}while(affetto < 0 || affetto > 100);
		
		do{
			cibo=KeyboardInput.acquireInt(0,100,"Cibo (0-100):");
		}while(affetto < 0 || affetto > 100);
		
		t = new Tamagotchi(nome,affetto,cibo);
		return t;
	}
}
