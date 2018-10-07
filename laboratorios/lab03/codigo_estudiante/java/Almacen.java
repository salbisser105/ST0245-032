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
public class Almacen {
   //ArrayList<Nevera>neveras = new ArrayList<>();
   //ArrayList<Solicitud>solicitudes = new ArrayList<>();
   LinkedList<Nevera>neveras = new LinkedList<>();
   LinkedList<Solicitud>solicitudes = new LinkedList<>();
   
   public void agregarNevera(Nevera nevera){
       neveras.add(nevera);
   }
   
   public void agregarSolicitud(Solicitud solicitud){
       solicitudes.add(solicitud);
   }
   
   public void administracionAlmacen(){
       int pedidos = solicitudes.size();
       for(int i=0;i<pedidos;i++){
           Solicitud solicitud = solicitudes.remove();
           int tamano = solicitud.getCantidad();
           System.out.println(solicitud.getTienda()+" : ");
           while(tamano != 0 && neveras.size() != 0){
               Nevera temporal = neveras.pop();
               System.out.println(" "+temporal.getCodigo()+"-"+temporal.getDesc());
               tamano--;
           }
           System.out.println();
       }
   }
}
