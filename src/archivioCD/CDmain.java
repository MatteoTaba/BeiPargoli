package archivioCD;

public class CDmain {
	
	private static final String MENU_PRIMARY_CHOISE[]={"Esci", "Gestisci archivio", "Gestisci CD"};
	private static final String MENU_ARCHIVE_CHOISE[]={"Indietro", "Visualizza tutti i CD", "Trova CD", "Ottieni CD random", "Inserisci nuovo CD", "Elimina CD"};
	private static final String MENU_CD_CHOISE[]={"Indietro", "Visualizza tracce", "Ottieni traccia", "Ottieni traccia random", "Inserisci nuova traccia", "Elimina traccia"};
	
	public static void main(String args[]){
		
		MyMenu menuPrimary=createMenu(MENU_PRIMARY_CHOISE);
		menuPrimary.selectChoice();
	}
	
	private static MyMenu createMenu(String choises[])
	{
		return new MyMenu("Titolo", choises);
	}
}
