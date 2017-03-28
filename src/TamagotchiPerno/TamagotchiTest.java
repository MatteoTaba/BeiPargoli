package TamagotchiPerno;

import static org.junit.Assert.*;

import org.junit.Test;

public class TamagotchiTest {

	@Test
	public void testTamagotchi() {
		//String nome, int affetto, int cibo
		String nome="prova";
		int affetto=50;
		int cibo=40;
		Tamagotchi t = new Tamagotchi(nome,affetto,cibo);
		assert t.getNome().equals(nome);
		assert t.getAffetto() == affetto;
		assert t.getCibo() == cibo;
	}

	@Test
	public void testCarezza() {
		String nome="prova";
		int affetto=50;
		int cibo=40;
		float ciboFloat=cibo;
		Tamagotchi t = new Tamagotchi(nome,affetto,cibo);
		t.carezza(5);
		affetto+=5;
		ciboFloat -= 5*0.5;
		cibo = (int)ciboFloat;
		assert t.getAffetto() == affetto;
		assert t.getCibo() == cibo;
	}

	@Test
	public void testIsDead() {
		String nome1="prova1";
		int affetto=50;
		int cibo1=0;
		Tamagotchi t1 = new Tamagotchi(nome1,affetto,cibo1);
		String nome2="prova2";
		int cibo2=40;
		Tamagotchi t2 = new Tamagotchi(nome2,affetto,cibo2);
		
		assert !t1.isAlive();
		assert t2.isAlive();
	}

	@Test
	public void testBiscotto() {
		String nome="prova";
		float affetto=50;
		float cibo=40;
		Tamagotchi t = new Tamagotchi(nome,(int)affetto,(int)cibo);
		t.biscotto(5);

		fail("Not yet implemented");
	}

	@Test
	public void testIsHappy() {
		String nome1="prova1";
		int affetto=50;
		int cibo1=20;
		Tamagotchi t1 = new Tamagotchi(nome1,affetto,cibo1);
		
		String nome2="prova2";
		int cibo2=40;
		Tamagotchi t2 = new Tamagotchi(nome2,affetto,cibo2);
		
		String nome3="prova3";
		int cibo3=95;
		Tamagotchi t3 = new Tamagotchi(nome3,affetto,cibo3);
		
		String nome4="prova4";
		int affetto4=20;
		int cibo4=40;
		Tamagotchi t4 = new Tamagotchi(nome4,affetto4,cibo4);
		
		assert !t1.isHappy();
		assert t2.isHappy();
		assert !t3.isHappy();
		assert !t4.isHappy();
	}

	@Test
	public void testToString() {
		String nome="prova";
		int affetto=50;
		int cibo=40;
		Tamagotchi t = new Tamagotchi(nome,affetto,cibo);
		
		String stringa = t.toString();
		assert stringa.equals("prova- Affetto: 50; Cibo: 40; Stato: felice, vivo");
		//nome+ "- Affetto: "+affetto+"; Cibo: "+cibo+"; Stato: "+happy+", "+vivo;
	}

}
