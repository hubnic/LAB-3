package gti310.tp3.solver;

import java.util.ArrayList;
import java.util.List;

import gti310.tp3.parser.ConcreteParser;
import data.Aretes;
import data.AretesIn;

public class ConcreteSolver implements Solver {
	
	public ConcreteParser parser;
	public AretesIn listeAretes;
	public int nbAretes;
	public int sommetDepart; 
	
	public int sommetPlusCourt;
	public int[] toutSommets;

	public Object solve(Object input) {
		// TODO Auto-generated method stub
		parser = (ConcreteParser) input;
		listeAretes = parser.getAretesIn();
		InitialiserSource();
		
		// tiré des notes de cours, algorithme de Dijkstra
		
		
		return null;
	}
	/*
	InitialiserSource(G,s)
	S = { } // S = sommets avec chemin plus court
	Q = {tous des sommets de G} // Q = S(G)
	Tant que Q pas vide // Parcours chaque sommet une fois
	u = Extraire-Minimum(Q) // Prend sommet de Q avec plus petite dist
	S = S U {u} // Ajoute u à l’ensemble S
	Pour chaque nœud v dans Adj(u) // Pour seulement les voisins de u
	Relaxer(u,v,poids)*/
	
	
	private void InitialiserSource( ){
		
	}

}