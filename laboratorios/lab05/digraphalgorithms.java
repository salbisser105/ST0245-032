/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import java.util.*;
public class DigraphAlgorithms {
    public int moreEdges(Graph d){
	int mayor = 0;
	for(int i = 1; i < d.size(); ++i){
	    ArrayList<Integer> s = d.getSuccessors(i);
	    if(s.size() > d.getSuccessors(mayor).size()){
		mayor = s.size();
	    }
	}
	return mayor;
    }
}
