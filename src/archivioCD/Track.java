package archivioCD;

public class Track 
{
<<<<<<< HEAD
	private String title;
	private int min;
	private int sec;
=======
	private String title; //titolo della traccia	
	private int minutes; //minuti di durata della traccia
	private int seconds; //secondi di durata della traccia
>>>>>>> 3521aa4c63403eda43d106e2d95df8ed4b554eaa
	
	public Track() //costruttore vuoto
	{

	}
<<<<<<< HEAD
	public Track(String title, int min, int sec)
	{
		this.title=title;
		this.min=min;
		this.sec=sec;
=======
	public Track(String title, int minutes, int seconds) //costruttore con parametri
	{
		this.title=title;
		this.minutes=minutes;
>>>>>>> 3521aa4c63403eda43d106e2d95df8ed4b554eaa
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
<<<<<<< HEAD
		return "La traccia " + this.title + " ha durata " + this.min + ":" + this.sec;
=======
		return "La traccia " + this.title + " ha durata " + this.minutes + ":" + this.seconds;
>>>>>>> 3521aa4c63403eda43d106e2d95df8ed4b554eaa
	}
}
