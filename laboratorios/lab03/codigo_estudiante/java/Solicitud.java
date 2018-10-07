/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Solicitud {
    String tienda;
    int cantidad;
    
    public Solicitud(String tienda, int cantidad){
        this.tienda = tienda;
        this.cantidad = cantidad;
    }
    
    public String getTienda(){
        return tienda;
    }
    
    public int getCantidad(){
        return cantidad;
    }
}
