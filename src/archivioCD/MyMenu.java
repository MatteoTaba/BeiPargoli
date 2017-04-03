package archivioCD;

import gruppoA.util.*;

public class MyMenu {
	private String title;
	private String choises[];
  
	private static final String MSG_INS_CHOICE="Scelta : ";
  
	public MyMenu(String title, String[] choises){
		this.title=title;
		this.choises=choises;
	}
  
	public void showMenu(){
		System.out.println(title);
		int i=0;
		for(String choice : choises)
		{
			System.out.println(i+"\t"+choice);
			i++;
		}
	}
	
	public int selectChoice()
	{
		showMenu();
		int from=0;
		int to=choises.length-1;
		return KeyboardInput.acquireInt(from, to, MSG_INS_CHOICE);
	}
}