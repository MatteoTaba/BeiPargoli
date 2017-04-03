package archivioCD;

public class Track 
{
	private String title;
	private float lenght;
	
	public Track()
	{

	}
	public Track(String title, float lenght)
	{
		this.title=title;
		this.lenght=lenght;
	}
	
	public String toString()
	{
		return "La traccia " + this.title + " ha durata " + this.lenght;
	}
}
