package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import data.Aretes;
import data.AretesIn;

public class ConcreteParser implements Parser{
	
	private AretesIn aretesIn = new AretesIn();
	
	public Object parse(String filename) {
		//http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(filename));
			int index = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.toString().equalsIgnoreCase("$"))
					break;
				else if(index == 0)
					aretesIn.nbAretes = Integer.parseInt(sCurrentLine);
				else if(index == 1)
					aretesIn.sommetDepart = Integer.parseInt(sCurrentLine);
				else{
					String [] tab = sCurrentLine.split("\t", 3);
					addAretes(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]),Integer.parseInt(tab[2]));
				}

				index++;
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		return null;
	}
	public void addAretes(int destination, int parent, int poids){
		//System.out.println(destination + " " + parent + " " + poids);
		aretesIn.addAreteIn(new Aretes(destination, parent, poids));
	}

}
