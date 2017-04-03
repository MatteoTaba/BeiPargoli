package lanzi.tamagotchi;

public class Tamagotchi{
	private int satisfactionGrade;
	private int fullGrade;
	private String name;
	
	private static final float SATISFACTIONPERCARESS=2;
	private static final float FULLPERCARESSLESS=SATISFACTIONPERCARESS/2;
	
	private static final float FULLPERBISCUITPERCENT=10;
	
	/*
	 * Costruttore di default.
	 * Assegna -nome:Tamagotchi
	 * 		   -grado di soddisfazione:50
	 * 		   -grado di sazieta':50
	 */
	public Tamagotchi(){
		name="Tamagotchi";
		satisfactionGrade=50;
		fullGrade=50;
	}
	
	/*
	 * Costruttore con parametri -grado di soddisfazione
	 * 							 -grado di saziet�
	 * Assegna -nome:Tamagotchi
	 */
	public Tamagotchi(int fullGrade,int satisfactionGrade){
		name="Tamagotchi";
		this.fullGrade=fullGrade;
		this.satisfactionGrade=satisfactionGrade;
	}
	
	/*
	 * Costruttore con parametri -nome
	 * 							 -grado di soddisfazione
	 * 							 -grado di saziet�
	 */
	public Tamagotchi(String name, int fullGrade,int satisfactionGrade){
		this.name=name;
		this.fullGrade=fullGrade;
		this.satisfactionGrade=satisfactionGrade;
	}
	
	/*
	 * Getter grado di soddisfazione
	 * @return  grado di soddisfazione
	 */
	public int getSatisfactionGrade(){
		return satisfactionGrade;
	}
	
	/*
	 * Getter grado di saziet�
	 * @return  grado di saziet�
	 */
	public int getFullGrade(){
		return fullGrade;
	}
	
	/*
	 * Getter nome
	 * @return  nome
	 */
	public String getName(){
		return name;
	}
	
	/*
	 * Setter grado di soddisfazione
	 * @param int  grado di soddisfazione
	 */
	public void setSatisfactionGrade(int satisfactionGrade){
		this.satisfactionGrade=satisfactionGrade;
	}
	
	/*
	 * Getter grado di saziet�
	 * @param int  grado di saziet�
	 */
	public void setFullGrade(int fullGrade){
		this.fullGrade=fullGrade;
	}
	
	/*
	 * Aumenta il grado di saziet� in percentuale rispetto all'attuale livello.
	 * Diminuisce il grado di soddisfazione di quantit�/4 punti.
	 * @param int  quantit� dei biscotti
	 */
	public void eatBiscuit(int quantity){
		for(int i=0;i<quantity;i++){
			fullGrade=Math.round(fullGrade+fullGrade*FULLPERBISCUITPERCENT/100);
		}
		satisfactionGrade=Math.round(satisfactionGrade-(float)quantity/4);
	}
	
	/*
	 * Aumenta il grado di soddisfazione di una certa quantit�.
	 * Diminuisce il grado di saziet� della met� dell'aumento del grado di soddisfazione.
	 * @param int  quantit� delle carezze
	 */
	public void receiveCaress(int quantity){
		satisfactionGrade=Math.round(satisfactionGrade+quantity*SATISFACTIONPERCARESS);
		fullGrade=Math.round(fullGrade-quantity*FULLPERCARESSLESS);
		if(satisfactionGrade>100)
			satisfactionGrade=100;
	}
	
	/*
	 * Verifica lo stato di vita
	 * @return boolean  morto=true / vivo=false
	 */
	public boolean dead(){
		return (satisfactionGrade<=0 || fullGrade<=0 || fullGrade>100);
	}
	
	/*
	 * Verifica lo stato di felicit�
	 * @return boolean  infelice=true / felice=false
	 */
	public boolean unhappy(){
		return (fullGrade<30 || fullGrade>90);
	}
}