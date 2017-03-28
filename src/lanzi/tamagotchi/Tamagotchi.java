package lanzi.tamagotchi;

public class Tamagotchi{
	private int satisfactionGrade;
	private int fullGrade;
	private String name;
	
	private static final float SATISFACTIONPERCARESS=2;
	private static final float FULLPERCARESSLESS=SATISFACTIONPERCARESS/2;
	
	private static final float FULLPERBISCUITPERCENT=10;
	//private static final float SATISFACTIONPERBISCUITPERCENTLESS=FULLPERBISCUITPERCENT/4;
	
	private static final String NEWLINE=System.getProperty("line.separator");
	
	public Tamagotchi(){
		name="Nome";
		satisfactionGrade=50;
		fullGrade=50;
	}
	
	public Tamagotchi(int fullGrade,int satisfactionGrade){
		name="Nome";
		this.fullGrade=fullGrade;
		this.satisfactionGrade=satisfactionGrade;
	}
	
	public Tamagotchi(String name, int fullGrade,int satisfactionGrade){
		this.name=name;
		this.fullGrade=fullGrade;
		this.satisfactionGrade=satisfactionGrade;
	}
	
	//Getters
	public int getSatisfactionGrade(){
		return satisfactionGrade;
	}
	
	public int getFullGrade(){
		return fullGrade;
	}
	
	public String getName(){
		return name;
	}
	
	public String getStats(){
		if(!this.dead())
			if(this.unhappy())
				return "Grado sazieta' : "+this.fullGrade+NEWLINE+"Grado soddisfazione : "+this.satisfactionGrade+NEWLINE+this.name+" non e' contento";
			else
				return "Grado sazieta' : "+this.fullGrade+NEWLINE+"Grado soddisfazione : "+this.satisfactionGrade+NEWLINE+this.name+" e' contento";
		else
			return this.name+" e' morto.";
	}
	
	public void eatBiscuit(int quantity){
		for(int i=0;i<quantity;i++){
			fullGrade=Math.round(fullGrade+fullGrade*FULLPERBISCUITPERCENT/100);
			//satisfactionGrade=satisfactionGrade-satisfactionGrade*SATISFACTIONPERBISCUITPERCENTLESS/100;
		}
		satisfactionGrade=Math.round(satisfactionGrade-(float)quantity/4);
	}
	
	public void receiveCaress(int quantity){
		for(int i=0;i<quantity;i++){
			satisfactionGrade=Math.round(satisfactionGrade+SATISFACTIONPERCARESS);
			fullGrade=Math.round(fullGrade-FULLPERCARESSLESS);
		}
	}
	
	public boolean dead(){
		return (satisfactionGrade<=0 || fullGrade<=0 || fullGrade>100);
	}
	
	public boolean unhappy(){
		return (fullGrade<30 || fullGrade>90);
	}
}