package perno.tamagotchi;

import java.util.Random;

/*
 * Rappresenta un tamagotchi.
 */
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
	
	/*
	 * Costruttore che istanzia un nuovo tamagotchi dati nome, affetto e cibo.
	 */
	public Tamagotchi(String nome, int affetto, int cibo){
		this.nome=nome;
		this.affetto = affetto;
		this.cibo = cibo;
		this.vivo = true;
		isAlive();
	}
	
	/*
	 * Metodo che va a incrementare l'affetto di 1 per ogni carezza e decrementare il cibo di metà delle carezze ricevute.
	 * Il numero di carezze è casuale.
	 * Non vengono effettuate ulteriori carezze se il tamagotchi è morto/muore o ha/raggiunge affetto massimo.
	 * TODO implementare riduzione aumento affetto per un numero elevato di carezze
	 */
	public int carezza(){
		Random generator = new Random();
		int numeroCarezze = generator.nextInt(100);
		
		if(vivo && affetto != MAX_AFFETTO){
			float ciboFloat = (float)cibo;
			int affettoParziale=affetto;
			float ciboParziale=ciboFloat;
			
			int i;
			
			for(i=numeroCarezze;i>0 && affettoParziale <= MAX_AFFETTO && ciboParziale >= 0 ;i--){
				affettoParziale=affetto;
				affettoParziale++;
				ciboParziale=ciboFloat;
				ciboParziale-=0.50;
				
				if(affettoParziale <= MAX_AFFETTO){
					if(ciboParziale >= 0){
						affetto=affettoParziale;
						ciboFloat = ciboParziale;
					}
				}
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
	
	/*
	 * Metodo che va a incrementare il cibo di 1 per ogni biscotto e decrementare l'affetto di 1/4 dei biscotti ricevuti.
	 * Il numero di biscotti è casuale.
	 * Non vengono dati ulteriori biscotti se il tamagotchi è morto/muore o ha/raggiunge cibo massimo.
	 * TODO implementare riduzione aumento cibo per un numero elevato di biscotti
	 */
	public int biscotto(){
		Random generator = new Random();
		int numeroBiscotti = generator.nextInt(100);
		
		if(vivo){
			float affettoFloat = (float)affetto;
			float ciboFloat = (float)cibo;
			float ciboParziale=ciboFloat;
			float affettoParziale=affettoFloat;
			
			int i;
			
			for(i=numeroBiscotti;i>0 && ciboParziale <= MAX_CIBO && affettoParziale >= 0;i--){
				ciboParziale=ciboFloat;
				ciboParziale+=ciboParziale*PERCENTUALE_BISCOTTI;
				affettoParziale=affettoFloat;
				affettoParziale-=0.25;
				
				if(ciboParziale <= MAX_CIBO){
					if(affettoParziale >= 0){
						ciboFloat=ciboParziale;
						affettoFloat=affettoParziale;
					}
				}
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
	
	/*
	 * Controlla se il tamagotchi è vivo.
	 */
	public boolean isAlive(){
		if(vivo){
			if(affetto==0||cibo==0||cibo==MAX_CIBO) this.vivo=false;
		}
		return vivo;
	}
	
	/*
	 * Controlla se il tamagotchi è felice
	 */
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
