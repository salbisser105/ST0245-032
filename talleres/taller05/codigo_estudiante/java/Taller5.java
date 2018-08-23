/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5;

/**
 *
 * @author Santiago_Albisser
Juan pablo leal
 */
public class Taller5 {

    /**
     * @param args the command line arguments
     */
    public static int sumaArr ( int[]arr){
     int sum=0;
     for (int i = 0; i < arr.length; i++){
         sum +=arr[i];
     }
     return sum;
    }
    public static int[] insertioNsort (int []arr){
     int var=0;
     for (int i=0; i<arr.length;i++){
         for(int j=i; j<arr.length; j++){
             if(arr[i]>arr[j]){
                 var=arr[j];
                 arr[j]=arr[i];
                 arr[i]=var;
                 
             }
         }
     }
        return arr;
    }
    
    public static void main(String[] args) {
     for (int i = 10000000; i <= 200000000; i = i + 10000000){
        int[] a = new int[i];
        for (int j = 0; j < i; j++ ){
          a[j] = j;
        }
        long start = System.currentTimeMillis();
          sumaArr(a);
        long fin = System.currentTimeMillis();       
        System.out.println(fin-start);
      }
    }

    
}

