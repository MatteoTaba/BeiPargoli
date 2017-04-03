package archivioCD;

import java.util.*;
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
      System.out.println(i+choice);
      i++;
    }
  }
  
  public int selectChoice()
  {
    showMenu();
    return KeyboardInput.acquireInt(0, choises.size()-1, MSG_INS_CHOICE);
  }
}