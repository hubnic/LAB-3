package gti310.tp3.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConcreteWriter {
	private int[][] graphe;
	
	public ConcreteWriter(int[][] graphe){
		this.graphe = graphe;
	}
	
	public void writeTextFile(){http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/
		
		try {
			 
			String content = "This is the content to write into file";
 
			File file = new File("solution.txt");
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i = 0; i < graphe.length; i++){
		        bw.write((i + 1) + " " + graphe[i][0] + " " + graphe[i][1]);
		        bw.write(System.lineSeparator());
			}
			bw.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		}		
    }
}
