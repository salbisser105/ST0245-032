/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prevencioncolisiones;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import javafx.geometry.Point3D;
import java.util.ArrayList;
import java.lang.Math;
import java.util.LinkedList;
/**
 *
 * @author Juan Pablo Leal-Santiago Albisser
 * Basados en el código creado por Mauricio Toro
 */
public class PrevencionColisiones {
        /**
    * Metodo para aproximar la distancia entre dos abejas roboticas
    *
    * @param  abeja1  la primera abeja
    * @param  abeja2  la segunda abeja
    * @return la distancia aproximada entre las dos abejas, aproximando 1 grado como 111111 metros
    */
    public static double distancia(Point3D abeja1, Point3D abeja2){
        return Math.sqrt(  Math.pow((abeja1.getX() - abeja2.getX())*111111,2) +
                           Math.pow((abeja1.getY() - abeja2.getY())*111111,2) +
                           Math.pow(abeja1.getZ() - abeja2.getZ(),2)
                        );
    }

    /**
    * Metodo para leer un archivo de abejas y almacenarlas en un arreglo de puntos en 3D
    *
    * @param  numeroDeAbejas  El numero de abejas a leer
    * @return un arreglo de puntos 3D donde cada elemento representa las coordenadas de una abeja
    */
    public static Point3D[] leerArchivo(int numeroDeAbejas){
          final String nombreDelArchivo = "ConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";
          Point3D[] arregloDeAbejas = new Point3D[numeroDeAbejas];
          try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); // Descarta la primera linea
            int index = 0;
            while (lineaActual != null){ // Mientras no llegue al fin del archivo
                String [] cadenaParticionada = lineaActual.split(",");
                Point3D abeja = new Point3D(Double.parseDouble(cadenaParticionada[0]),
                                            Double.parseDouble(cadenaParticionada[1]),
                                            Double.parseDouble(cadenaParticionada[2]));
                arregloDeAbejas[index++] = abeja;
                lineaActual = br.readLine();
            }
          }
          catch(IOException ioe) {
              System.out.println("Error leyendo el archivo de entrada");
          }
          return arregloDeAbejas;
    }
    
    /**
    * Algoritmo para prevenir colisiones (genera muchas respuestas repetidas)
    *
    * @param  arregloDeAbejas  Un arreglo con coordenadas de las abejas
    * @return una lista definida con arreglos con las abejas que tienen riesgo de colision
    */
    public static LinkedList<Point3D> detectarColisioness(Point3D[] arregloDeAbejas){
        LinkedList<Point3D> abejasConRiesgoDeColision = new LinkedList();
        for (int i = 0; i<arregloDeAbejas.length; i++){
            for (int j = i+1; j<arregloDeAbejas.length; j++){
                if(distancia(arregloDeAbejas[i],arregloDeAbejas[j]) <= 100){
                    abejasConRiesgoDeColision.add(arregloDeAbejas[i]);
                    abejasConRiesgoDeColision.add(arregloDeAbejas[j]);
                }
            }
        }
        return abejasConRiesgoDeColision;
    }
        
    /**
    * Metodo para escribir un archivo con la respuesta
    *
    * @param  abejasConRiesgoDeColision  Lista definida con arreglos con las abejas con riesgo de colision
    * @param  numeroDeAbejas  Numero de abejas del conjunto de datos original
    */
    public static void guardarArchivoo(LinkedList<Point3D> abejasConRiesgoDeColision, int numeroDeAbejas){
          final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";  
          try {
             PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
             for (Point3D abeja : abejasConRiesgoDeColision)
                escritor.println(abeja.getX()+","+abeja.getY()+","+abeja.getZ());
             escritor.close();
          }
          catch(IOException ioe) {
              System.out.println("Error escribiendo el archivo de salida");
          }  
    }
    
    public static void main(String[] args){
          // Recibir el numero de abejas como parametro
          final int numeroDeAbejas = args.length == 0 ? 10000 : Integer.parseInt(args[0]);
          // Leer el archivo con las coordenadas de las abejas
          Point3D[] arregloDeAbejas = leerArchivo(numeroDeAbejas);
          // Prevenir las colisiones revisando todas con todas
          long startTime = System.currentTimeMillis();
          LinkedList<Point3D> abejasConRiesgoDeColision = detectarColisioness(arregloDeAbejas);
          // Guardar en un archivo las abejas con riesgo de colision   
          long estimatedTime = System.currentTimeMillis() - startTime;
          guardarArchivoo(abejasConRiesgoDeColision, numeroDeAbejas);
          System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
          
        
   }
}
