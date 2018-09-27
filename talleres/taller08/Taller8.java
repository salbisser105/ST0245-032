/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class Taller8 {
    
    //notacion polaca inversa
    public static int polaca  (String string){
        String[]arr = string.split(" ");
        Stack<Integer> pila= new Stack<Integer>();
        int calc = 0;
        for(int i=0; i<arr.length; i++){
            if(!(arr[i].equals("+"))&&!(arr[i].equals("-"))&&!(arr[i].equals("*"))&&!(arr[i].equals("/"))){
                pila.push(Integer.parseInt(arr[i]));
            } else if (arr[i].equals("+")){
                calc = pila.pop() + pila.pop();
                pila.push(calc);
            } else if (arr[i].equals("-")){
                calc = Math.abs(pila.pop() - pila.pop());
                pila.push(calc);
            } else if (arr[i].equals("*")){
                calc = pila.pop() * pila.pop();
                pila.push(calc);
            } else if (arr[i].equals("/")){
                calc = pila.pop() / pila.pop();
                pila.push(calc);
            }
        }
        return pila.pop();
    }
    
    public static void main (String[]args){
        System.out.println(polaca("3 5 * 2 -"));
    }
}
