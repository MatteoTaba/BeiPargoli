package gruppoA.util;

import java.util.Random;

public class RandomNumbers {
	private static Random generator = new Random();
	
	public static int randomInt(int from, int to){
		int a;
		if(from > to){//Inverte i valori
			a=from;
			from=to;
			to=a;
		}
		return from + generator.nextInt(to-from);
	}
}
