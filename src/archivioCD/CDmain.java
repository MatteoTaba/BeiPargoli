package archivioCD;

import java.util.*;

import gruppoA.util.*;

public class CDmain {

	private static final String MSG_FOUND="%s trovato.";
	private static final String MSG_NOT_FOUND="%s non trovato.";
	private static final String MSG_ERR="Errore - %s";
	private static final String MSG_INS_TITLE="Inserisci il titolo : ";
	private static final String MSG_INS_TRACKLENGHT_MIN="Inserisci i minuti della traccia : ";
	private static final String MSG_INS_TRACKLENGHT_SEC="Inserisci i secondi rimanenti della traccia : ";
	private static final String MSG_INS_TRACKNUM="Inserisci il numero della traccia : ";
	private static final String MSG_INS_ARTIST="Inserisci il nome dell'artista : ";
	
	private static final String EXIT="exit";
	
	private static final String MENU_PRIMARY_CHOISE[]={"Esci", "Gestisci archivio", "Gestisci CD"};
	private static final String MENU_ARCHIVE_CHOISE[]={"Indietro", "Visualizza tutti i CD", "Trova CD", "Ottieni CD random", "Inserisci nuovo CD", "Elimina CD"};
	private static final String MENU_CD_CHOISE[]={"Indietro", "Visualizza tracce", "Ottieni traccia", "Ottieni traccia random", "Inserisci nuova traccia", "Elimina traccia"};
	
	private static final int MENU_PRIMARY=1;
	private static final int MENU_ARCHIVE=2;
	private static final int MENU_CD=3;
	
	private static CDarchive cdArchive=new CDarchive();
	private static CD cd;
	
	
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
		String title;
		switch(choose)
		{
			case 0:
				return MENU_PRIMARY;
			//Visualizza tutti i cd
			case 1:
				cdArchive.showCD();
				return MENU_ARCHIVE;
			//Trova CD
			case 2:
				title=KeyboardInput.acquireString(MSG_INS_TITLE);
				cd=cdArchive.findCD(title);
				if(cd==null)
					System.out.printf(MSG_NOT_FOUND, "CD");
				else
					System.out.printf(MSG_FOUND, "CD");
				return MENU_CD;
			//Ottieni CD random
			case 3:
				cd=cdArchive.randomCD();
				return MENU_CD;
			//Inserisci CD
			case 4:
				CD cdCreated=createCD();
				cdArchive.insertCD(cdCreated);
				return MENU_ARCHIVE;
			//Elimina CD
			case 5:
				title=KeyboardInput.acquireString(MSG_INS_TITLE);
				cdArchive.deleteCD(title);
				return MENU_ARCHIVE;
				
			default:
				return MENU_PRIMARY;
		}
	}
	
	private static int menuCdInput(int choose)
	{
		Track track;
		//TODO manage cd attribute=null
		switch(choose)
		{
			case 0:
				return MENU_PRIMARY;
			//Visualizza tracce
			case 1:
				cd.showTracks();
				return MENU_CD;
			//Ottieni traccia
			case 2:
				int index=KeyboardInput.acquireInt(MSG_INS_TRACKNUM);
				track=cd.specificTrack(index);
				System.out.println(track.toString());
				return MENU_CD;
			//Ottieni traccia random
			case 3:
				track=cd.randomTrack();
				System.out.println(track.toString());
				return MENU_CD;
			//Inserisci nuova traccia
			case 4:
				track=createTrack();
				if(track==null)
					System.out.printf(MSG_ERR, "Traccia non inserita");
				else
					System.out.println("Traccia inserita");
				cd.insertTrack(track);
				return MENU_CD;
			//Elimina traccia
			case 5:
				//TODO implement into class
				return MENU_CD;
			
			default:
				return MENU_PRIMARY;
		}
	}
	
	/**
	 * Create cd, input from keyboard.
	 * @return  CD inserted by user.
	 */
	private static CD createCD()
	{
		String title=KeyboardInput.acquireString(MSG_INS_TITLE);
		String artist=KeyboardInput.acquireString(MSG_INS_ARTIST);
		Vector<Track> tracks=new Vector<Track>();
		Track tmpTrack;
		tmpTrack=createTrack();
		while(tmpTrack!=null)
		{
			tracks.add(tmpTrack);
			tmpTrack=createTrack();
		}
		return new CD(title, artist, tracks);
	}
	/**
	 * Create track, input from keyboard.
	 * @return  Track inserted by user or null if inserted "Exit" as title.
	 */
	private static Track createTrack()
	{
		String title=KeyboardInput.acquireString(MSG_INS_TITLE);
		int lenghtMin=KeyboardInput.acquireInt(MSG_INS_TRACKLENGHT_MIN);
		int lenghtSec=KeyboardInput.acquireInt(MSG_INS_TRACKLENGHT_SEC);
		if(title.equalsIgnoreCase(EXIT))
			return null;
		return new Track(title, lenghtMin, lenghtSec);
	}
}
