package archivioCD;

public class Track 
{
	private String title; //titolo della traccia	
	private int minutes; //minuti di durata della traccia
	private int seconds; //secondi di durata della traccia
	
	public Track() //costruttore vuoto
	{

	}
	public Track(String title, int minutes, int seconds) //costruttore con parametri
	{
		this.title=title;
		this.minutes=minutes;
	}
	
	public String getTitle() //restituisce il titolo della traccia
	{
		return title;
	}
	
	public int getMinutes() //restituisce i minuti della traccia
	{
		return minutes;
	}
	
	public int getSeconds() //restituisce i secondi della traccia
	{
		return seconds;
	}
	
	public String toString() //descrizione della traccia
	{
		return "La traccia " + this.title + " ha durata " + this.minutes + ":" + this.seconds;
	}
}
