/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Juan Pablo Leal-Santiago Albisser
 */
public class Laboratory1 {
  
  // Sorts an array using Insertion Sort
  public static void InsertionSort(int[] A)
  {
      long init = System.currentTimeMillis();
       int temp,j;
       for (int i = 0; i < A.length; i++)
       {
         j = i;
         while (j > 0 && A[j-1] > A[j])
           {
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
               j = j-1;
            }           
       }
       long end = System.currentTimeMillis();
       long total = end - init;
       System.out.println("Tiempo transcurrido insertion sort: "+total);
  }

      // Sorts an array using Merge Sort
      // Taken from www.cs.cmu.edu/
	public static void mergeSort(int [ ] a)
	{
                long inicio = System.currentTimeMillis();
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
                long fin = System.currentTimeMillis();
                long ola=fin-inicio;
                System.out.println("Tiempo transcurrido merge sort: "+ola);
	}


	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
  
    private static int[] generarArregloDeTamanoN(int n) 
    {
        int max = 5000;
        int[] array = new int[n];
        Random generator = new Random();
        for (int i = 0; i < n; i++) 
        {
            array[i] = generator.nextInt(max);
        }
        return array;
    }

  public static void main(String[] args)
  {
      int[]A=generarArregloDeTamanoN(19050000);
      /*int[][] Arrays = {A,B,C};  
      for (int[] X : Arrays)
      {        
      Laboratory1.mergeSort(X);
      Laboratory1.InsertionSort(X);
      System.out.println(Laboratory1.ArraySum(X) + " " + Laboratory1.ArrayMax(X) + "\n" );
      mergeSort(X);
      }*/
      mergeSort(A);
      InsertionSort(A);
  }
}

