package data;

import java.util.ArrayList;
import java.util.List;



public class PathOut {
	public List<Aretes> PathOut = new ArrayList<Aretes>();
	public int nbAretes;
	public int sommetDepart;
	
	public void addAreteIn(Aretes addAretes){
		PathOut.add(addAretes);
	}
	
}
