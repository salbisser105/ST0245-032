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
    
    static LinkedList[][][] abejitas;
    static int longiX = 0;
    static int longiY = 0;
    static int longiZ = 0;
    static double minX = 0;
    static double minY = 0;
    static double minZ = 0;
    
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
    * Algoritmo para llenar la matriz
    *
    * @param  arregloDeAbejas  Un arreglo con coordenadas de las abejas
    */
    public static void llenarMatriz(Point3D[] arregloDeAbejas){
        minX = arregloDeAbejas[0].getX();
        double maxX = arregloDeAbejas[0].getX();
        minY = arregloDeAbejas[0].getY();
        double maxY = arregloDeAbejas[0].getY();
        minZ = arregloDeAbejas[0].getZ();
        double maxZ = arregloDeAbejas[0].getZ();
        for(int i=0; i<arregloDeAbejas.length-1; i++){
            if(arregloDeAbejas[i].getX()<arregloDeAbejas[i+1].getX()) minX=arregloDeAbejas[i].getX();
            if(arregloDeAbejas[i].getX()>=arregloDeAbejas[i+1].getX()) maxX=arregloDeAbejas[i].getX();
            if(arregloDeAbejas[i].getY()<arregloDeAbejas[i+1].getY()) minY=arregloDeAbejas[i].getY();
            if(arregloDeAbejas[i].getY()>=arregloDeAbejas[i+1].getY()) maxY=arregloDeAbejas[i].getY();
            if(arregloDeAbejas[i].getZ()<arregloDeAbejas[i+1].getZ()) minZ=arregloDeAbejas[i].getZ();
            if(arregloDeAbejas[i].getZ()>=arregloDeAbejas[i+1].getZ()) maxZ=arregloDeAbejas[i].getZ();
        }
        double lX = ((maxX - minX)*1000000) / 57.73;
        double lY = ((maxY - minY)*1000000) / 57.73;//57.73
        double lZ = ((maxZ - minZ)*100) / 57.73;
        longiX = Math.abs((int)lX);
        longiY = Math.abs((int)lY);
        longiZ = Math.abs((int)lZ);
        abejitas = new LinkedList[longiX][longiY][longiZ];
    }
    
    /**
    * Algoritmo para detectar colisiones
    *
    * @param  arregloDeAbejas  Un arreglo con coordenadas de las abejas
    * @param  abejitas Una matriz tridimensional en las que se almacenan las abejas que colisionan
    * @return una matriz tridimensional con el tamaño de sus lados
    */
    public static LinkedList[][][] detectarColisiones(LinkedList[][][]abejitas, Point3D[] arregloDeAbejas){
        for(int i=0;i<arregloDeAbejas.length-1;i++){
            int posX1 = Math.abs((int)((arregloDeAbejas[i].getX()-minX)*1000000/57.73));
            int posY1 = Math.abs((int)((arregloDeAbejas[i].getY()-minY)*1000000/57.73));
            int posZ1 = Math.abs((int)((arregloDeAbejas[i].getZ()-minZ)*100/57.73));
            int posX2 = Math.abs((int)((arregloDeAbejas[i+1].getX()-minX)*1000000/57.73));
            int posY2 = Math.abs((int)((arregloDeAbejas[i+1].getY()-minY)*1000000/57.73));
            int posZ2 = Math.abs((int)((arregloDeAbejas[i+1].getZ()-minZ)*100/57.73));
            if((posX1/longiX==posX2/longiX)&&(posY1/longiY==posY2/longiY)&&(posZ1/longiZ==posZ2/longiZ)){
                if(abejitas[posX1/longiX][posY1/longiY][posZ1/longiZ]==null){
                    LinkedList<Point3D>x=new LinkedList();
                    x.add(arregloDeAbejas[i]);
                    x.add(arregloDeAbejas[i+1]);
                    abejitas[posX1/longiX][posY1/longiY][posZ1/longiZ] = x;   
                } else {
                    abejitas[posX1/longiX][posY1/longiY][posZ1/longiZ].add(arregloDeAbejas[i]);
                    abejitas[posX1/longiX][posY1/longiY][posZ1/longiZ].add(arregloDeAbejas[i+1]);
                }
            }
        }
        return abejitas;
        
    }
    
    /**
    * Metodo para escribir un archivo con la respuesta
    *
    * @param  abejasConRiesgoDeColision  Lista definida con arreglos con las abejas con riesgo de colision
    * @param  numeroDeAbejas  Numero de abejas del conjunto de datos original
    */
    public static void guardarArchivoo(LinkedList[][][] abejasConRiesgoDeColision, int numeroDeAbejas){
          final String nombreDelArchivo = "respuestaConjuntoDeDatosCon"+numeroDeAbejas+"abejas.txt";  
          try {
             PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
             for (int i=0;i<abejasConRiesgoDeColision.length;i++){
                 for (int j=0;j<abejasConRiesgoDeColision[i].length;j++){
                     for (int k=0;k<abejasConRiesgoDeColision[i][j].length;k++){
                         escritor.println(abejasConRiesgoDeColision[i][j][k].get(i));
                     }
                 }
             }
             /*escritor.println(abeja.getX()+","+abeja.getY()+","+abeja.getZ());
             escritor.close();*/
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
          //Llenar la matriz
          llenarMatriz(arregloDeAbejas);
          // Prevenir las colisiones revisando todas con todas
          long startTime = System.currentTimeMillis();
          LinkedList[][][] abejasConRiesgoDeColision = detectarColisiones(abejitas,arregloDeAbejas);
          long estimatedTime = System.currentTimeMillis() - startTime;
          // Guardar en un archivo las abejas con riesgo de colision
          //guardarArchivoo(abejasConRiesgoDeColision, numeroDeAbejas);
          System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
          
   }
}
