package gti310.tp3.parser;

import data.Aretes;
import data.AretesIn;

public class ConcreteParser implements Parser{
	private AretesIn aretesIn = new AretesIn();
	public Object parse(String filename) {
		// TODO Auto-generated method stub
		return null;
	}
	public void addAretes(int destination, int parent, int poids){
		aretesIn.addAreteIn(new Aretes(destination, parent, poids));
	}

}
