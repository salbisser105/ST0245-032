/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller01;

/**
 *
 * @author Santiago_Albisser
 */
    public class Fecha {
    private  int dia;
    private int mes;
    private  int año;


    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     * @param dia
     * @param mes
     * @param año
     */
    public Fecha(int dia, int mes, int año) {
        dia=this.dia;
        mes=this.mes;
        año=this.año;
    }

    /**
     * Método para obtener la variable global dia.
     *
     * @return el dia
     */
    public int dia() {
        return dia;

    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes
     */
    public int mes() {
        return mes;

    }

    /**
     * Método para obtener la variable global anio.
     *
     * @return el año
     */
    public int año() {
        return año;

    }

    /**
    * @param otra representa la fecha con la culase va a comparar.
    *
    * El método comprar se encarga de devolvernos respuesta a tres posibilidades.
    * 1: si la fecha es menor que la otra retorna -1.
    * 2: si la fecha es igual que la otra retorna 0.
    * 3: si la fecha es mayor que la otra retorna 1.
    *
    * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
    *
    */

    public int comparar(Fecha otra) {
       
        if(año==otra.año &&mes==otra.mes && dia==otra.dia){
            return 0;
            
    }else if(año<otra.año||mes<otra.mes||dia<otra.dia){
        return -1;
    } else {
        return 1;
    }
        }


     /**
    * toString se encargará de convertir el tipo abstracto fecha en un tipo cadena
    * para su posterior visualización
    *
    * @return una cadena que contiene la fecha
    */
    public String toString() {
        String dia="";
        String mes="";
        String año="";
        dia=Integer.toString(dia());
        mes=Integer.toString(mes());
        año=Integer.toString(año());
        return (año+mes+dia);
    }
}
