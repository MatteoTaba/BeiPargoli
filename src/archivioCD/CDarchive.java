package archivioCD;

import java.util.*;

public class CDarchive {
	private Vector <CD> CDlist;
	private static int INCREASE_DIMENSION = 10;
	private static int DEFAULT_DIMENSION = 10;
	
	public CDarchive(){
		this.CDlist= new Vector<CD>(DEFAULT_DIMENSION,INCREASE_DIMENSION);
	}
	
	public CDarchive(Vector <CD> CDlist){
		this.CDlist=CDlist;
	}
	
	public void insertCD(CD toInsert){
		CDlist.add(toInsert);
	}
	
	public CD findCD(String title){
		CD found=null;
		int k=CDlist.size();
		for(;k>=0;k--){
			if(CDlist.get(k).getTitle().equals(title))
				found=CDlist.get(k);
		}
		return found;
	}
	
	/*
	 * It shows all the CDs within the archive
	 */
	public void showCD(){
		for(CD element : CDlist){
			System.out.println(element.toString());
		}
	}
	
	public void deleteCD(String title){
		
	}
	
	public CD randomCD(){
		return null;
	}
}

