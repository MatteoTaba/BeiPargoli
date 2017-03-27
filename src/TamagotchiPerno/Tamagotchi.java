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
	private static final int INCREMENTO_AFFETTO=1;
	
	
	public Tamagotchi(String nome, int salute, int affetto, int cibo){
		this.nome=nome;
		this.salute = salute;
		this.affetto = affetto;
		this.cibo = cibo;
		this.vivo = isDead();
	}
	
	public int carezza(int numeroCarezze){
		if(vivo && affetto != MAX_AFFETTO){
			int affettoParziale;
			float ciboParziale;
			float ciboFloat = (float)cibo;
			
			int i;
			for(i=numeroCarezze;i>0;i--){
				affettoParziale=affetto;
				affettoParziale++;
				ciboParziale=ciboFloat;
				ciboParziale-=0.50;
				
				if(affettoParziale > MAX_AFFETTO) break;
				if(ciboParziale < 0) break;
				affetto=affettoParziale;
				ciboFloat = ciboParziale;
			}
			cibo=(int)ciboFloat;
			numeroCarezze-=i;
		}
		else
			numeroCarezze=0;
		isDead();
		return numeroCarezze;
	}
	
	public boolean isDead(){
		if(vivo){
			if(salute==0||affetto==0||cibo==0) this.vivo=false;
		}
		return !vivo;
	}
	
	/*public int biscotto(int numeroBiscotti){
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
	}*/
	public int biscotto(int numeroBiscotti){//TODO Sistemare come da consegna
		if(vivo && cibo != MAX_CIBO){
			int ciboParziale;
			float affettoParziale;
			float affettoFloat = (float)affetto;
			
			int i;
			for(i=numeroBiscotti;i>0;i--){
				ciboParziale=cibo;
				ciboParziale++;
				affettoParziale=affettoFloat;
				ciboParziale-=0.25;
				
				if(affettoParziale > MAX_AFFETTO) break;
				if(ciboParziale < 0) break;
				cibo=ciboParziale;
				affettoFloat=affettoParziale;
			}
			affetto=(int)affettoFloat;
			numeroBiscotti-=i;
		}
		else
			numeroBiscotti=0;
		isDead();
		return numeroBiscotti;
	}
	
	public boolean isHappy(){
		if(affetto<SOGLIA_AFFETTO||SOGLIA_INF_CIBO < cibo || cibo < SOGLIA_SUP_CIBO){
			happy=false;
		}
		else
			happy=true;
		return happy;
	}
	
	public int getAffetto() {
		return affetto;
	}
	
	public int getCibo() {
		return cibo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getSalute() {
		return salute;
	}
	
	public String toString(){
		return nome+ "-Salute: "+salute+"; Affetto: "+affetto+"; Cibo: "+cibo;
	}
}
