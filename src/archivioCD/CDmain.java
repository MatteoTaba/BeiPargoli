package archivioCD;

public class CDmain {
	public static void main(String args[]){
		
		MyMenu menu1=createMenu();
		menu1.selectChoice();
	}
	
	private static MyMenu createMenu()
	{
		String ma[]={"Esci", "bo", "acas", "asdasd"};
		return new MyMenu("Titolo", ma);
	}
}
