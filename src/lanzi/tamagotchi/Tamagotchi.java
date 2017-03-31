package lanzi.tamagotchi;

public class Tamagotchi{
	private int satisfactionGrade;
	private int fullGrade;
	private String name;
	
	private static final float SATISFACTIONPERCARESS=2;
	private static final float FULLPERCARESSLESS=SATISFACTIONPERCARESS/2;
	
	private static final float FULLPERBISCUITPERCENT=10;
	
	
	public Tamagotchi(){
		name="Tamagotchi";
		satisfactionGrade=50;
		fullGrade=50;
	}
	
	public Tamagotchi(int fullGrade,int satisfactionGrade){
		name="Tamagotchi";
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
	
	//Setters
	public void setSatisfactionGrade(int satisfactionGrade){
		this.satisfactionGrade=satisfactionGrade;
	}
	
	public void setFullGrade(int fullGrade){
		this.fullGrade=fullGrade;
	}
	
	public void eatBiscuit(int quantity){
		for(int i=0;i<quantity;i++){
			fullGrade=Math.round(fullGrade+fullGrade*FULLPERBISCUITPERCENT/100);
		}
		satisfactionGrade=Math.round(satisfactionGrade-(float)quantity/4);
	}
	
	public void receiveCaress(int quantity){
		for(int i=0;i<quantity;i++){
			satisfactionGrade=Math.round(satisfactionGrade+SATISFACTIONPERCARESS);
			fullGrade=Math.round(fullGrade-FULLPERCARESSLESS);
		}
		if(satisfactionGrade>100)
			satisfactionGrade=100;
	}
	
	public boolean dead(){
		return (satisfactionGrade<=0 || fullGrade<=0 || fullGrade>100);
	}
	
	public boolean unhappy(){
		return (fullGrade<30 || fullGrade>90);
	}
}