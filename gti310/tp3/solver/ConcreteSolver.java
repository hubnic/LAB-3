package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.List;

import gti310.tp3.parser.ConcreteParser;
import data.Aretes;
import data.AretesIn;

public class ConcreteSolver implements Solver {
	
	private ConcreteParser parser;
	private List<Aretes> listeAretes;
	private int nbSommets;
	private int sommetDepart; 
	private final int width = 2;
	private AretesIn areteIn;
	
	private int[][] graphe;

	public Object solve(Object input) {
		// TODO Auto-generated method stub
		parser = (ConcreteParser) input;
		areteIn = parser.getAretesIn();
		listeAretes = parser.getAretesIn().AretesIn;
		nbSommets = areteIn.nbSommets;
		InitialiserSource();
		Relaxer();
		return null;
	}
	
	private void InitialiserSource( ){
		graphe = new int[nbSommets][width];
		for(int i = 0; i < nbSommets; i++){
			//distance
			graphe[i][0] = Integer.MAX_VALUE;
		}
	}
	
	private void Relaxer(){
		boolean shortestFound = false;
		int root = Integer.MAX_VALUE;
		 int [][] shortestPath = new int [1][2];
		 //distance
		 shortestPath[0][0] = Integer.MAX_VALUE;
		 // parent
		 shortestPath[0][1] = Integer.MAX_VALUE;
		for(int i = 0; i < listeAretes.size(); i++){
			if(listeAretes.get(i).getParent() == areteIn.sommetDepart){
				setGraphElement(listeAretes.get(i).getDestination(), listeAretes.get(i).getPoids(), listeAretes.get(i).getParent());
			}

			else if(listeAretes.get(i).getParent() > areteIn.sommetDepart)
			{
				shortestPath = calculateShortestForBiggerRoot(shortestPath,i);
				//System.out.println(shortestPath[0][0]+" "+shortestPath[0][1]);
				setGraphElement(listeAretes.get(i).getDestination(), shortestPath[0][0], shortestPath[0][1]);
			}
			
			else{
				shortestPath = calculateShortestForSmallerRoot(shortestPath,i);
				//System.out.println(shortestPath[0][0]+" "+shortestPath[0][1]);
				setGraphElement(listeAretes.get(i).getDestination(), shortestPath[0][0], shortestPath[0][1]);
			}
		}
		displayResults();
	}
	
	private void setGraphElement(int destination, int poids, int parent){
		destination--;
		if(poids < graphe[destination][0]){
			graphe[destination][0] = poids;
			graphe[destination][1] = parent;
		}
	}

	private int[][] calculateShortestForBiggerRoot(int [][] shortestPath, int i){
		int root = listeAretes.get(i).getParent();
		 //Loop sur la liste de toutes les aretes
		 //calcule la distance de tous les chemins possible et garde le plus court
		 for(int j = 0; j < listeAretes.size(); j++){
			 int weight = 0;
			 int directParent = 0;
			 int compteur = 0;
			 //retrace le chemin jusquau sommet de départ en gardant en note la distance
			 while(root != areteIn.sommetDepart){
				 if(listeAretes.get(compteur).getDestination() == root){
					 if(directParent == 0)
						 directParent = listeAretes.get(compteur).getParent();
					 root = listeAretes.get(compteur).getParent();
					 weight +=  listeAretes.get(compteur).getPoids();
					 compteur = 0;
				 }
				 compteur++;
			 }
			 if(weight < shortestPath[0][1] && weight != 0){
				//distance
				 shortestPath[0][1] = directParent;
				 // parent
				 shortestPath[0][0] = weight;
			 }
		 }
		return shortestPath;
	}
	
	private int[][] calculateShortestForSmallerRoot(int [][] shortestPath, int i){
		int root = listeAretes.get(i).getParent();
		 //Loop sur la liste de toutes les aretes
		 //calcule la distance de tous les chemins possible et garde le plus court
		 for(int j = 0; j < listeAretes.size(); j++){
			 int weight = 0;
			 int directParent = 0;
			 int compteur = 0;
			 //retrace le chemin jusquau sommet de départ en gardant en note la distance
			 while(root != areteIn.sommetDepart){
				 if(listeAretes.get(compteur).getParent() == root){
					 if(directParent == 0)
						 directParent = listeAretes.get(compteur).getDestination();
					 root = listeAretes.get(compteur).getDestination();
					 weight +=  listeAretes.get(compteur).getPoids();
					 compteur = 0;
				 }
				 compteur++;
			 }
			 if(weight < shortestPath[0][1] && weight != 0){
				//distance
				 shortestPath[0][1] = directParent;
				 // parent
				 shortestPath[0][0] = weight;
			 }
		 }
		return shortestPath;
	}
	
	private void displayResults(){
		for(int i = 0; i < graphe.length; i++){
			System.out.println(graphe[i][0] + " " + graphe[i][1]);
		}
	}
	
}