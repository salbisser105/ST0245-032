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
import java.util.*;

public class Punto {

    private double x, y;

  
    public Punto(double x, double y) {
        this.x = x;
       this.y = y;

    }


    public double x() {
        return x;
    }

  
    
    public double y() {
        return y;

    }

    
    public double radioPolar() {
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));

    }


    
    public double anguloPolar() {
        return Math.atan2(y,x);
        //return Math.atan(y/x);
    }  
    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow((x-otro.x()),2)+Math.pow((y-otro.y()),2));
    }
}