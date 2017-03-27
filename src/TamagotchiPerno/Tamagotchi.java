package TamagotchiPerno;

public class Tamagotchi {
	private String nome;
	private int salute;
	private int affetto;
	private int cibo;
	private boolean vivo;
	private boolean happy;
	
	private static final int MAX_SALUTE = 100;
	private static final int MAX_AFFETTO = 100;
	private static final int MAX_CIBO = 100;
	private static final int DEFAULT_SALUTE = 20;
	private static final int DEFAULT_AFFETTO = 20;
	private static final int DEFAULT_CIBO = 20;
	private static final double PERCENTUALE_BISCOTTI=0.1;
	private static final int SOGLIA_AFFETTO=30;
	private static final int SOGLIA_INF_CIBO=30;
	private static final int SOGLIA_SUP_CIBO=90;
	
	
	public Tamagotchi(String nome){
		this.nome=nome;
		this.salute = DEFAULT_SALUTE;
		this.affetto = DEFAULT_AFFETTO;
		this.cibo = DEFAULT_CIBO;
		this.vivo = true;
	}
	
	/*
	 * Restituisce il numero di carezze effettuate
	 */
	public int carezza(int numeroCarezze){
		int carezzeEffettive;
		
		if(vivo && affetto!=MAX_AFFETTO){
			int caloCibo;
			caloCibo = numeroCarezze/2;
			if(cibo-caloCibo <= 0){
				this.cibo=0;
				carezzeEffettive=0;
			}
			else if(affetto > MAX_AFFETTO){
				carezzeEffettive=MAX_AFFETTO-affetto;
				affetto=MAX_AFFETTO;
				cibo-=caloCibo;
			}
			else{
				carezzeEffettive=numeroCarezze;
				cibo-=caloCibo;
			}
		}
		else
			carezzeEffettive=0;
		isDead();
		return carezzeEffettive;
	}
	
	public boolean isDead(){
		if(vivo){
			if(salute==0||affetto==0||cibo==0) this.vivo=false;
		}
		return vivo;
	}
	
	public int biscotto(int numeroBiscotti){
		int biscottiEffettivi;
		
			if(cibo != MAX_CIBO && vivo){
				double ciboAttuale = cibo;
				double aumentoCibo;
				int caloAffetto;
				
				for(int k=numeroBiscotti;k>0;k--){
					aumentoCibo=ciboAttuale*PERCENTUALE_BISCOTTI;
					if((ciboAttuale+aumentoCibo)>MAX_CIBO)
						break;
					else
						ciboAttuale+=aumentoCibo;						
				}
				biscottiEffettivi=(int)ciboAttuale-cibo;
				this.cibo=(int)ciboAttuale;
				
				caloAffetto=biscottiEffettivi/4;
				if(affetto-caloAffetto < 0){//Affetto negativo
					affetto=0;
					biscottiEffettivi=0;
				}
			}
			else
				biscottiEffettivi=0;
			isDead();
			return biscottiEffettivi;
	}
	
	public boolean isHappy(){
		if(affetto<SOGLIA_AFFETTO||SOGLIA_INF_CIBO < cibo || cibo < SOGLIA_SUP_CIBO){
			happy=false;
		}
		else
			happy=true;
		return happy;
	}
}
