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
public class DigraphAL extends Graph {
    ArrayList<LinkedList<Pareja>> lista = new ArrayList();
    
    public DigraphAL(int size){
        super(size);
        for(int i=0; i<size; i++){
            lista.add(new LinkedList());
        }
    }
    
    public void addArc(int source, int destination, int weight){
        lista.get(source).add(new Pareja(destination,weight));
    }
    
    public int getWeight(int source, int destination){
        LinkedList<Pareja>linked = lista.get(source);
        for(int i=0; i<linked.size(); i++){
            if(linked.get(i).vertice==destination){
                return linked.get(i).peso;
            }
        }
        return 0;
    }
    
    public ArrayList<Integer> getSuccessors(int vertice){
        LinkedList<Pareja>linked = lista.get(vertice);
        ArrayList<Integer>successors = new ArrayList<>();
        for(int i=0;i<linked.size();i++){
            if(linked.get(i).peso!=0){
                successors.add(linked.get(i).vertice);
            }
        }
        return successors;
    }
}
