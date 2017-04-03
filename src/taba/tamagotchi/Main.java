package taba.tamagotchi;

import gruppoA.util.*;

public class Main 
{
	public static void Saluto()
	{
		System.out.println("Ciao, benvenuto nel magico mondo di Tamagotchi!");
	}
	
	public static Tamagotchi acquireTamagotchi()
	{
		Tamagotchi t;
		
		String name;
		float satisfaction;
		float full;
		
		
		name=KeyboardInput.acquireString("Battezza il tuo animaletto: ");
		satisfaction=KeyboardInput.acquireFloat("Imposta il grado di soddisfazione iniziale: ");
		full=KeyboardInput.acquireFloat("Imposta il grado di sazietà iniziale: ");
		
		
		t=new Tamagotchi(name, satisfaction, full);
		
		return t;
	}
	
	public static void main (String[] args)
	{
		Saluto();
		String state;
		Tamagotchi t=acquireTamagotchi();
			
			while(t.die()==false)
			{
				String command;
				
				do
				{
					command=KeyboardInput.acquireString("Inserisci il comando[Carezze/Biscotti/Esci]: ");
							
				}while(!command.equalsIgnoreCase("Biscotti") && !command.equalsIgnoreCase("Carezze") && !command.equalsIgnoreCase("Esci"));
				
				int quantity=(int)(Math.random()*10);
				
				if(command.equalsIgnoreCase("Biscotti")||command.equalsIgnoreCase("Carezze"))
				{	
					System.out.println("Il tamagotchi " + t.getName() + " riceve " + quantity + " " + command);
				}
				
				if(command.equalsIgnoreCase("Biscotti"))
					t.eatBiscuit(quantity);
				else if(command.equalsIgnoreCase("Carezze"))
					t.getCaress(quantity);
				else if(command.equalsIgnoreCase("Esci"))
				{
					System.out.println("Adios");
					System.exit(0);
				}
				else
				{
					System.out.println("Comando non valido, reinserisci");
				}
				
				state=t.toString();
				System.out.println(state);
			
				t.unhappy();
			}
		
	}
}
