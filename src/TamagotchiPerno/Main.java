package TamagotchiPerno;

import java.util.Scanner;

public class Main {
	private static Scanner read = new Scanner(System.in);
	
	public static void main(String[] args) {
		int comando;
		
		
		saluta();
		//String nome, int salute, int affetto, int cibo
		Tamagotchi t = creaTamagotchi();
		do{
			System.out.println("1-Accarezza");
			System.out.println("2-Dai biscotto");
			System.out.println("3-Esci");
			
			comando = read.nextInt();
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
		
		do{
		System.out.println("Quante carezze?");
		numeroCarezze=read.nextInt();
		}while(numeroCarezze <= 0);
		carezzeEffettive=t.carezza(numeroCarezze);
		System.out.println("Carezze effettive:"+ carezzeEffettive+" -- " + t.toString());
	}
	
	private static Tamagotchi creaTamagotchi(){
		Tamagotchi t;
		String nome;
		int salute;
		int affetto;
		int cibo;
		
		System.out.println("Nome:");
		nome=read.next();
		do{
			System.out.println("Salute (0-100):");
			salute=read.nextInt();
		}while(salute < 0 || salute > 100);
		do{
			System.out.println("Affetto (0-100):");
			affetto=read.nextInt();
		}while(affetto < 0 || affetto > 100);
		do{
			System.out.println("Cibo (0-100):");
			cibo=read.nextInt();
		}while(affetto < 0 || affetto > 100);
		
		t = new Tamagotchi(nome,salute,affetto,cibo);
		return t;
	}
	
	private static void daiBiscotto(Tamagotchi t){
		int numeroBiscotti;
		int biscottiEffettivi;
		
		do{
			System.out.println("Quanti biscotti?");
			numeroBiscotti=read.nextInt();
		}while(numeroBiscotti <= 0);
		
		t.biscotto(numeroBiscotti);
		biscottiEffettivi=t.biscotto(numeroBiscotti);
		System.out.println("Carezze effettive:"+ biscottiEffettivi+" -- " + t.toString());
	}

}
