package TamagotchiPerno;

public class Tamagotchi {
	private String nome;
	private int affetto;
	private int cibo;
	private boolean vivo;
	private boolean happy;
	
	private static final int MAX_AFFETTO = 100;
	private static final int MAX_CIBO = 100;
	private static final float PERCENTUALE_BISCOTTI=(float)0.1;
	private static final int SOGLIA_INF_AFFETTO=30;
	private static final int SOGLIA_INF_CIBO=30;
	private static final int SOGLIA_SUP_CIBO=90;
	
	
	public Tamagotchi(String nome, int affetto, int cibo){
		this.nome=nome;
		this.affetto = affetto;
		this.cibo = cibo;
		this.vivo = true;
		isAlive();
	}
	
	public int carezza(int numeroCarezze){//TODO Inserire random
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
		isAlive();
		isHappy();
		return numeroCarezze;
	}
	
	public int biscotto(int numeroBiscotti){//TODO Inserire random
		if(vivo && cibo != MAX_CIBO){
			float ciboParziale;
			float affettoParziale;
			float affettoFloat = (float)affetto;
			float ciboFloat = (float)cibo;
			int i;
			
			for(i=numeroBiscotti;i>0;i--){
				ciboParziale=ciboFloat;
				ciboParziale+=ciboParziale*PERCENTUALE_BISCOTTI;
				affettoParziale=affettoFloat;
				affettoParziale-=0.25;
				
				if(ciboParziale > MAX_CIBO) break;
				if(affettoParziale < 0) break;
				ciboFloat=ciboParziale;
				affettoFloat=affettoParziale;
			}
			affetto=(int)affettoFloat;
			cibo=(int)ciboFloat;
			numeroBiscotti-=i;
		}
		else
			numeroBiscotti=0;
		isAlive();
		isHappy();
		return numeroBiscotti;
	}
	
	public boolean isAlive(){
		if(vivo){
			if(affetto==0||cibo==0||cibo==MAX_CIBO) this.vivo=false;
		}
		return vivo;
	}
		
	public boolean isHappy(){
		if(affetto<SOGLIA_INF_AFFETTO || cibo < SOGLIA_INF_CIBO || SOGLIA_SUP_CIBO < cibo){
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
	
	public String toString(){
		String happy;
		String vivo;
		if(this.happy)
			happy="felice";
		else
			happy="triste";
		if(this.vivo)
			vivo="vivo";
		else
			vivo="morto";
		return nome+ "- Affetto: "+affetto+"; Cibo: "+cibo+"; Stato: "+happy+", "+vivo;
	}
}
