package data;



public class AretesIn {
	public Aretes[] AretesIn;
	
	public void setLength(int length){
		AretesIn = new Aretes[length];
	}
	
	public void addAreteIn(Aretes addAretes){
		for (int i=0; i<AretesIn.length; i++){
			if(AretesIn[i]==null){
				AretesIn[i]=addAretes;
				break;
			}
		}
	}
	
}
