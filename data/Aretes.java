package data;

public class Aretes {
	
	int destination;
	int parent;
	int poids;
	
	public Aretes(int parentIn, int destinationIn, int poidsIn){
		destination = destinationIn;
		parent = parentIn;
		poids = poidsIn;
	}
	
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	
	

}
