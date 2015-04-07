package gti310.tp3;

import gti310.tp3.parser.ConcreteParser;
import gti310.tp3.solver.ConcreteSolver;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is façing.
 * 
 * @author François Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		ConcreteParser concreteParser = new ConcreteParser();
		concreteParser.parse("C:\\Users\\Jean-Theo\\workspace\\LAB-3\\vendeur.txt");
		//concreteParser.parse("C:\\Users\\Nicolas\\Documents\\Universite\\2015\\Hiver\\GTI310\\TP3\\UnrealNetworksSolver\\UnrealNetworksSolver\\gti310\\tp3\\LAB-3\\Vendeur.txt");
		
		ConcreteSolver concreteSolver = new ConcreteSolver();
		concreteSolver.solve(concreteParser);
	}
}
