package archivioCD;

public class CDmain {
	
	private static final String MENU_PRIMARY_CHOISE[]={"Esci", "Gestisci archivio", "Gestisci CD"};
	private static final String MENU_ARCHIVE_CHOISE[]={"Indietro", "Visualizza tutti i CD", "Trova CD", "Ottieni CD random", "Inserisci nuovo CD", "Elimina CD"};
	private static final String MENU_CD_CHOISE[]={"Indietro", "Visualizza tracce", "Ottieni traccia", "Ottieni traccia random", "Inserisci nuova traccia", "Elimina traccia"};
	
	private static final int MENU_PRIMARY=1;
	private static final int MENU_ARCHIVE=2;
	private static final int MENU_CD=3;
	private static int menuState=MENU_PRIMARY;
	
	public static void main(String args[]){
		int choose=1;
		
		MyMenu menuPrimary=new MyMenu("Titolo", MENU_PRIMARY_CHOISE);
		MyMenu menuArchive=new MyMenu("Titolo", MENU_ARCHIVE_CHOISE);
		MyMenu menuCd=new MyMenu("Titolo", MENU_CD_CHOISE);
		
		while(choose!=0 && menuState==MENU_PRIMARY)
		{
			switch(menuState)
			{
				case MENU_PRIMARY:
					menuPrimary.selectChoice();
					break;
				case MENU_ARCHIVE:
					menuArchive.selectChoice();
					break;
				case MENU_CD:
					menuCd.selectChoice();
					break;
			}
			//call method to manage input (parameter int choise)
		}
		
	}
	
	//TODO method to manage input
	
}
