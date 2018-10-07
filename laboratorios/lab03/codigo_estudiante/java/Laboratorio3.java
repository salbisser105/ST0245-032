/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Usuario
 */
public class Laboratorio3 {
    
    //Método smartInsert para ArrayList
    public static void smartInsert(ArrayList<Integer>list, int data){
        if(!list.contains(data)){//O(1)
            list.add(data);//O(n)
        }
    }
    
    //Método smartInsert para LinkedList
    public static void smartInserta(LinkedList<Integer>list, int data){
        if(!list.contains(data)){//O(n)
            list.push(data);//O(1)
        }
    }
    
    //Método agregar para ArrayList
    public static void addArray(ArrayList<Integer>list, int pos, int data){
        list.add(pos,data);
    }
    
    //Método agregar para LinkedList
    public static void addLinked(LinkedList<Integer>list, int pos, int data){
        list.add(pos, data);
    }
    
    //Método borrar para ArrayList
    public static void removeArray(ArrayList<Integer>list, int pos){
        list.remove(pos);
    }
    
    //Método borrar para LinkedList
    public static void removeLinked(LinkedList<Integer>list, int pos){
        list.remove(pos);
    }
    
    //Método contains para ArrayList
    public static boolean containsArray(ArrayList<Integer>list, int data){
        if(list.contains(data)){
            return true;
        } else {
            return false;
        }
    }
    
    //Método contains para LinkedList
    public static boolean containsLinked(LinkedList<Integer>list, int data){
        if(list.contains(data)){
            return true;
        } else {
            return false;
        }
    }
    
    //Pivote con ArrayList
    public static void pivoteArrayList(ArrayList<Integer>list){
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<list.size();i++){//O(n)
            sum2 += list.get(i);//O(1)
        }
        int pos = -1;
        int dif = sum2;
        
        for(int i=0;i<list.size();i++){//O(n)
            sum2 -= list.get(i);//O(1)
            sum1 += list.get(i);//O(1)
            
            int dif2=Math.abs(sum1-sum2);
            
            if(dif2<dif){
                dif = dif2;
                pos++;
            }
        }
        System.out.println(pos);
    }
    
    //Pivote con LinkedList
    public static void pivoteLinkedList(LinkedList<Integer>list){
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<list.size();i++){//O(n)
            sum2 += list.get(i);//O(n)
        }
        int pos = -1;
        int dif = sum2;
        
        for(int i=0;i<list.size();i++){//O(n)
            sum2 -= list.get(i);//O(n)
            sum1 += list.get(i);//O(n)
            
            int dif2=Math.abs(sum1-sum2);
            
            if(dif2<dif){
                dif = dif2;
                pos++;
            }
        }
        System.out.println(pos);
    }
    
    //Punto 2.1 
    public static LinkedList<Character> tecladoMalo(String str){
        LinkedList<Character>lista = new LinkedList<>();
        boolean start = false;
        int cont = 0;
        for (int i=0;i<str.length();i++){//O(n)
            if(str.charAt(i)=='['){
                start = true;
                cont = 0;
            } else if (str.charAt(i)==']'){
                start = false;
            }
            if(str.charAt(i)!='['&&str.charAt(i)!=']'){
                if(start){
                    lista.add(cont,str.charAt(i));//O(1)
                    cont++;
                } else {
                    lista.add(str.charAt(i));//O(1)
                }
            }
        }
        return lista;
    }
    
    
    public static void main(String[]args){
        
    }
}
