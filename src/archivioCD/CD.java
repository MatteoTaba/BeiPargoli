package archivioCD;

import java.util.*;
import gruppoA.util.*;

public class CD 
{
	private String title; //titolo del cd
	private String artist; //artista del cd
	private Vector <Track> tracks= new Vector<Track>(); //vector di tracce del cd
	
	public CD(String title, String artist, Vector<Track> tracks) //costruttore
	{
		this.title=title;
		this.artist=artist;
		this.tracks=tracks;
	}
	
	public String getTitle() //restituisce il titolo
	{
		return title;
	}

	public String getArtist() //restituisce l'artista
	{
		return artist;
	}
	
	public Vector<Track> getTracks() //restituisce le tracce
	{
		return tracks;
	}
	
	public void insertTrack(Track toInsert) //inserimento di una traccia
	{
		tracks.add(toInsert);
	}
	
	public Track randomTrack() //scelta di una traccia casuale
	{
		int i= RandomNumbers.randomInt(0,30);
		Track toPrint=tracks.get(i);
		return toPrint;
	}
	
	public Track specificTrack(int trackNumber) //ricerca di una specifica traccia mediante il numero
	{
		if(trackNumber<tracks.size())
			return tracks.get(trackNumber);	
		else
			return null;
	}
	
	public Track specificTrack(String trackTitle) //ricerca di una specifica traccia mediante titolo o parte di esso
	{
		for(Track i : tracks)
		{
			if(trackTitle.equals(i.getTitle()))
			return i;	
		}
		
		return null;
	}
	
	public void showTracks() //visualizzazione di tutte le tracce di un cd
	{
		for(int i=0;i<tracks.size();i++)
		{
			Track toPrint=tracks.get(i);
			System.out.println(toPrint);
		}
	}
	
	public String toString() //descrizione cd
	{
		return "L'album " + this.getTitle() + " realizzato da " + this.getArtist() + " contiene le seguenti tracce " + this.getTracks();
	}
	
}
