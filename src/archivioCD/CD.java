package archivioCD;

import java.util.*;
import gruppoA.util.*;

public class CD 
{
	private String title;
	private String artist;
	private Vector <Track> tracks= new Vector<Track>();
	
	public CD(String title, String artist, Vector tracks)
	{
		this.title=title;
		this.artist=artist;
		this.tracks=tracks;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getArtist()
	{
		return artist;
	}
	
	public Vector getTracks()
	{
		return tracks;
	}
	
	public void insertTrack(Track toInsert)
	{
		tracks.add(toInsert);
	}
	
	public Track randomTrack()
	{
		int i= RandomNumbers.randomInt(0,30);
		Track toPrint=tracks.get(i);
		return toPrint;
	}
	
	public Track specificTrack(int trackNumber)
	{
		for(int i=0;i<tracks.size();i++)
		{
			Track toPrint=tracks.get(i);
			System.out.println(toPrint);
		}
		Track toFind=new Track();
		=KeyboardInput.acquireString("Inserisci la traccia desiderata: ");
		if()
	}
	
	public String toString()
	{
		return "L'album " + this.getTitle() + " realizzato da " + this.getArtist() + " contiene le seguenti tracce " + this.getTracks();
	}
	
}
