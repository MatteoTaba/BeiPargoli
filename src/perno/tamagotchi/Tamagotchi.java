package perno.tamagotchi;

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
	 * Costruttore che istanzia un nuovo tamagotchi.
	 * @param nome Nome del tamagotchi.
	 * @param affetto Valore iniziale affetto.
	 * @param cibo Valore iniziale cibo.
	 */
	public Tamagotchi(String nome, int affetto, int cibo){//TODO Controllo valori.
		this.nome=nome;
		this.affetto = affetto;
		this.cibo = cibo;
		this.vivo = true;
		isAlive();
	}
	
	/*
	 * Metodo che va a incrementare l'affetto di 1 per ogni carezza e decrementare il cibo di metà delle carezze ricevute.
	 * Non vengono effettuate ulteriori carezze se il tamagotchi è morto/muore o ha/raggiunge affetto massimo.
	 * @param numeroCarezze Numero di carezze da effettuare.
	 * @return Numero di carezze effettivamente date.
	 * TODO implementare riduzione aumento affetto per un numero elevato di carezze
	 * I conti vengono eseguiti su variabili float e alla fine convertiti in int arrotondando.
	 */
	public int riceviCarezze(int numeroCarezze){		
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
					else
						ciboFloat=0;
				}
				else
					affetto=MAX_AFFETTO;
			}
			cibo=(int)Math.round(ciboFloat);
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
	 * Non vengono dati ulteriori biscotti se il tamagotchi è morto/muore o ha/raggiunge cibo massimo.
	 * @param numeroCarezze Numero di biscotti da dare.
	 * @return Numero di biscotti effettivamente dati.
	 * TODO implementare riduzione aumento cibo per un numero elevato di biscotti
	 * I conti vengono eseguiti su variabili float e alla fine convertiti in int arrotondando.
	 */
	public int riceviBiscotti(int numeroBiscotti){		
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
					else
						affettoFloat=0;
				}
				else
					ciboFloat=MAX_CIBO;
			}
			
			affetto=(int)Math.round(affettoFloat);
			cibo=(int)Math.round(ciboFloat);
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
	 * @return Vero se vivo, falso se morto.
	 */
	public boolean isAlive(){
		if(vivo){
			if(affetto==0||cibo==0||cibo==MAX_CIBO) this.vivo=false;
		}
		return vivo;
	}
	
	/*
	 * Controlla se il tamagotchi è felice.
	 * @return Vero se felice, falso se è triste.
	 */
	public boolean isHappy(){
		if(affetto<SOGLIA_INF_AFFETTO || cibo < SOGLIA_INF_CIBO || SOGLIA_SUP_CIBO < cibo){
			happy=false;
		}
		else
			happy=true;
		return happy;
	}
	
	/*
	 * @return Valore attuale di affetto del tamagotchi.
	 */
	public int getAffetto() {
		return affetto;
	}
	
	/*
	 * @return Valore attuale di cibo del tamagotchi.
	 */
	public int getCibo() {
		return cibo;
	}
	
	/*
	 * @return Nome del tamagotchi.
	 */
	public String getNome() {
		return nome;
	}
	
	/*
	 * @return Breve descrizione dello stato del tamagotchi.
	 */
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
	
	/*
	 * Metodi per adattare l'applicazione al test.
	 */
	public boolean sonoMorto(){
		return !isAlive();
	}
	
	public boolean sonoTriste(){
		return !isHappy();
	}
}