package archivioCD;

public class CDmain {
	
	private static final String MENU_PRIMARY_CHOISE[]={"Esci", "Gestisci archivio", "Gestisci CD"};
	private static final String MENU_ARCHIVE_CHOISE[]={"Indietro", "Visualizza tutti i CD", "Trova CD", "Ottieni CD random", "Inserisci nuovo CD", "Elimina CD"};
	private static final String MENU_CD_CHOISE[]={"Indietro", "Visualizza tracce", "Ottieni traccia", "Ottieni traccia random", "Inserisci nuova traccia", "Elimina traccia"};
	
	private static final int MENU_PRIMARY=1;
	private static final int MENU_ARCHIVE=2;
	private static final int MENU_CD=3;
	
	
	public static void main(String args[]){
		int choose=1;
		
		MyMenu menuPrimary=new MyMenu("Libreria Musicale", MENU_PRIMARY_CHOISE);
		MyMenu menuArchive=new MyMenu("Gestisci Archivio", MENU_ARCHIVE_CHOISE);
		MyMenu menuCd=new MyMenu("Gestisci CD", MENU_CD_CHOISE);
		
		int menuState=MENU_PRIMARY;
		
		exit:
		while(true)
		{
			switch(menuState)
			{
				case MENU_PRIMARY:
					choose=menuPrimary.selectChoice();
					if(choose==0)
						break exit;
					menuState=menuPrimaryInput(choose);
					break;
				case MENU_ARCHIVE:
					choose=menuArchive.selectChoice();
					menuState=menuArchiveInput(choose);
					break;
				case MENU_CD:
					choose=menuCd.selectChoice();
					break;
			}
			//call method to manage input (parameter int choise)
		}
		
	}
	
	/**
	 * Manage Primary menu input.
	 * @return menuState:Menu to display next.
	 */
	private static int menuPrimaryInput(int choose){
		switch(choose)
		{
			case 1:
				return MENU_ARCHIVE;
			case 2:
				return MENU_CD;
				
			default:
				return MENU_PRIMARY;
		}
	}
	
	/**
	 * Manage Archive menu input.
	 * @return menuState:Menu to display next.
	 */
	private static int menuArchiveInput(int choose){
		switch(choose)
		{
			case 0:
				return MENU_PRIMARY;
			case 1:
				//TODO something
				return MENU_ARCHIVE;

			//TODO implement cases
				
			default:
				return MENU_PRIMARY;
		}
	}
	//TODO methods to manage input (one for each menu)
	
}
