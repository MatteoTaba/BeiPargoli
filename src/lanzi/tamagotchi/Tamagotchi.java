package lanzi.tamagotchi;

public class Tamagotchi{
	private float satisfactionGrade;
	private float fullGrade;
	private String name;
	
	private static final float satisfactionPerCaress=2;
	private static final float fullPerCaressLess=satisfactionPerCaress/2;
	
	private static final float fullPerBiscuitPercent=10;
	//private static final float satisfactionPerBiscuitPercentLess=fullPerBiscuitPercent/4;
	
	public Tamagotchi(){
		name="Nome";
		satisfactionGrade=50;
		fullGrade=50;
	}
	
	public Tamagotchi(float fullGrade,float satisfactionGrade){
		name="Nome";
		this.fullGrade=fullGrade;
		this.satisfactionGrade=satisfactionGrade;
	}
	
	public Tamagotchi(String name, float fullGrade,float satisfactionGrade){
		this.name=name;
		this.fullGrade=fullGrade;
		this.satisfactionGrade=satisfactionGrade;
	}
	
	//Getters
	public float getSatisfactionGrade(){
		return satisfactionGrade;
	}
	
	public float getFullGrade(){
		return fullGrade;
	}
	
	public String getName(){
		return name;
	}
	
	public String getStats(){
		if(!this.dead())
			if(this.unhappy())
				return "Grado sazieta' : "+this.fullGrade+"\nGrado soddisfazione : "+this.satisfactionGrade+"\n"+this.name+" non e' contento";
			else
				return "Grado sazieta' : "+this.fullGrade+"\nGrado soddisfazione : "+this.satisfactionGrade+"\n"+this.name+" e' contento";
		else
			return this.name+" e' morto.";
	}
	
	public void eatBiscuit(int quantity){
		for(int i=0;i<quantity;i++){
			fullGrade=fullGrade+fullGrade*fullPerBiscuitPercent/100;
			//satisfactionGrade=satisfactionGrade-satisfactionGrade*satisfactionPerBiscuitPercentLess/100;
			satisfactionGrade=satisfactionGrade-(float)quantity/4;
		}
	}
	
	public void receiveCaress(int quantity){
		for(int i=0;i<quantity;i++){
			satisfactionGrade=satisfactionGrade+satisfactionPerCaress;
			fullGrade=fullGrade-fullPerCaressLess;
		}
	}
	
	public boolean dead(){
		return (satisfactionGrade<=0 || fullGrade<=0 || fullGrade>100);
	}
	
	public boolean unhappy(){
		return (fullGrade<30 || fullGrade>90);
	}
}