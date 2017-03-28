package TamagotchiPerno;

import java.util.Random;
import myUtil.MyInput;

public class Main {
	
	public static void main(String[] args) {
		int comando;
		
		saluta();
		
		Tamagotchi t = creaTamagotchi();
		do{
			if(!t.isAlive()){
				System.out.println(t.getNome() + " è morto.");
				break;
			}
			if(t.isHappy())
				System.out.println(t.getNome() + " è felice!");
			else
				System.out.println(t.getNome() + " è triste!");
			
			System.out.println("1-Accarezza");
			System.out.println("2-Dai biscotto");
			System.out.println("3-Esci");
			
			comando = MyInput.acquireInt();
			
			switch (comando){
			case 1: accarezza(t);
				break;
			case 2: daiBiscotto(t);
				break;
			}			
		}while(comando!=3);
		System.exit(0);
	}
	
	public static void saluta(){
		System.out.println("Ciao");
	}
	
	private static void accarezza(Tamagotchi t){
		int numeroCarezze;
		int carezzeEffettive;
		String useRandom;
		
		do{
			useRandom=MyInput.acquireString("Random? (yes/no)");
		}while(!useRandom.equals("yes") && !useRandom.equals("no"));
		
		if(useRandom.equals("no")){
			do{
			numeroCarezze=MyInput.acquireIntPositive("Quante carezze?");
			}while(numeroCarezze <= 0);
		}
		else{
			numeroCarezze=randomInt(0,100);
		}
		
		carezzeEffettive=t.carezza(numeroCarezze);
		System.out.println("Carezze effettive:"+ carezzeEffettive+" |" + t.toString());
	}
	
	private static Tamagotchi creaTamagotchi(){
		Tamagotchi t;
		String nome;
		int affetto;
		int cibo;
		
		nome=MyInput.acquireString("Nome:");
		
		do{
			affetto=MyInput.acquireInt(0,100,"Affetto (0-100):");
		}while(affetto < 0 || affetto > 100);
		
		do{
			cibo=MyInput.acquireInt(0,100,"Cibo (0-100):");
		}while(affetto < 0 || affetto > 100);
		
		t = new Tamagotchi(nome,affetto,cibo);
		return t;
	}
	
	private static void daiBiscotto(Tamagotchi t){
		int numeroBiscotti;
		int biscottiEffettivi;
		String useRandom;
		
		do{
			useRandom=MyInput.acquireString("Random? (yes/no)");
		}while(!useRandom.equals("yes") && !useRandom.equals("no"));
		
		if(useRandom.equals("no")){
			do{
				System.out.println("Quanti biscotti?");
				numeroBiscotti=MyInput.acquireIntPositive("Quanti biscotti?");
			}while(numeroBiscotti <= 0);
		}
		else{
			numeroBiscotti=randomInt(0,100);
		}
		
		t.biscotto(numeroBiscotti);
		biscottiEffettivi=t.biscotto(numeroBiscotti);
		System.out.println("Carezze effettive:"+ biscottiEffettivi+" |" + t.toString());
	}
	
	private static int randomInt(int from, int to){//TODO Rimuovere random
		Random generator = new Random();
		int randomNumber = from + generator.nextInt(to+1);
		return randomNumber;
	}
}
