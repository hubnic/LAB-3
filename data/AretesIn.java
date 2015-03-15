package data;

import java.util.ArrayList;
import java.util.List;



public class AretesIn {
	public List<Aretes> AretesIn = new ArrayList<Aretes>();
	public int nbSommets;
	public int sommetDepart;
	List<Integer> tabSommets = new ArrayList<Integer>();
	
	public void addAreteIn(Aretes addAretes){
		AretesIn.add(addAretes);
	}
	
	public List<Integer> calculerNbAretes(){
		for(int i = 0; i < AretesIn.size(); i++){
			if(!tabSommets.contains(AretesIn.get(i).parent)){
				tabSommets.add(AretesIn.get(i).parent);
			}
		}
		return tabSommets;
	}
	
}
