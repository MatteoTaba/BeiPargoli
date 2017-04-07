package archivioCD;

public class Track 
{
	private String title;
	private int min;
	private int sec;
	
	public Track()
	{

	}
	public Track(String title, int min, int sec)
	{
		this.title=title;
		this.min=min;
		this.sec=sec;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String toString()
	{
		return "La traccia " + this.title + " ha durata " + this.min + ":" + this.sec;
	}
}
