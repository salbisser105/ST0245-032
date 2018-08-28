/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleres;

/**
 *
 * @author Usuario
 */
public class MiArrayList {
        private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MiArrayList() {
        int [] elements = new int [size];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return size;
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e) {
        int cont=0;
        for (int i=0;i<elements.length;i++){
            if (elements[i]!=0){
                cont++;
            }
        }
        if (cont==elements.length){
            int [] elementsaux = new int [size + 1];
            elementsaux[size + 1]=e;
            elements=elementsaux;
        } else {
            for (int i=0;i<elements.length;i++){
                if (elements[i]==0){
                    elements[i]=e;
                    break;
                }
            }
        }
    }    
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public int get(int i) {
        return elements[i];
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, int e) {
        elements[index]=e;
    } 

    /**
    * @param index es la posicion en la cual se va agregar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index){
        elements[index]=0;
    }
}
