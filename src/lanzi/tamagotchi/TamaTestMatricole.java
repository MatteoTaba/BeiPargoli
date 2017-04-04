package lanzi.tamagotchi;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe JUnit per eseguire dei Test.
 */
public class TamaTestMatricole
{
	@Test
	public void dieForZeroSatisfaction() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 0, 50);
		assertTrue(tama.dead());
	}
	
	@Test
	public void dieForZeroHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 0);
		assertTrue(tama.dead());
	}
	
	@Test
	public void aliveWhenSatisfactionAndHungerAreGood() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.dead());
	}
/****	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeSatisfaction() throws Exception 
	{
		new Tamagotchi("Kira", -10, 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeHunger() throws Exception 
	{
		new Tamagotchi("Kira", 50, -10);
	}
	
	*****/
	@Test
	public void petCanReceivePets() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.receiveCaress(1);
		assertFalse(tama.unhappy());
	}
	
	@Test
	public void petCanReceiveCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.eatBiscuit(1);
		assertFalse(tama.unhappy());
	}
	
	@Test
	public void petIsUnhappyDueToHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 10, 50);
		assertTrue(tama.unhappy());
	}
	
	@Test
	public void petIsUnhappyDueToExtremeRepletion() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 95, 50);
		assertTrue(tama.unhappy());
	}
	
	@Test
	public void petIsHappyInTheMidlleOfTheRange() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.unhappy());
	}
	
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 99);
		tama.eatBiscuit(10);
		boolean res=tama.dead();
		assertTrue(res);
	}
	
	@Test
	public void petAugmentsItsSatisfactionDueToCaresses() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 29);
		tama.receiveCaress(10);
		assertFalse(tama.unhappy());
	}
}

