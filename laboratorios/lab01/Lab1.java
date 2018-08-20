/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Usuario
 */
public class Lab1 {

    /*Punto 1 serie de fibonnacci*/
    public static int Fibonacci(int c){
        
        if(c==0){
            return 0;
        }else if(c==1){
            return 1;
        }else {
            return Fibonacci(c-1)+ Fibonacci(c-2);
        }
    }
    /*Punto 2-Problemas de recursion 1*/
    public int strCount(String str, String sub) {
        if (str.length() < sub.length()){
            return 0;
        }
        if(str.substring(0,sub.length()).equals(sub)){
            return 1+strCount(str.substring(sub.length()),sub);
        }else{
            return strCount(str.substring(1),sub);
        }
    }
    public int countAbc(String str) {
        if(str.length()<3){
            return 0;
        }
        if(str.substring(0,3).equals("abc")||str.substring(0,3).equals("aba")){
            return 1+countAbc(str.substring(1));
        }else{
            return countAbc(str.substring(1));
        }
    }
    public String pairStar(String str) {
        if(str.length()<2){
            return str;
        }
        if(str.charAt(0)==str.charAt(1)){
            return str.charAt(0)+"*"+pairStar(str.substring(1));
        }else{
            return str.charAt(0)+pairStar(str.substring(1));
        }
    }
    public int countX(String str) {
        if (str.length()==0){
            return 0;
        }
        if (str.charAt(0)=='x'){
            return 1+countX(str.substring(1));
        } else {
            return countX(str.substring(1));
        }
    }
    public int count8(int n) {
        if (n==0){
            return 0;
        } else if (n>=88&&n%100==88){
            return 2+count8(n/10);
        } else if (n%10==8){
            return 1+count8(n/10);
        } else {
            return count8(n/10);
        }
    }    
    /*Punto 2-Problemas de recursion 2*/
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>=nums.length){
            return target==0;
        }
        if (nums[start]!=6){
            return groupSum6(start+1,nums,target)||groupSum6(start+1,nums,target-nums[start]);
        } else {
            return groupSum6(start+1,nums,target-nums[start]);
        }
    }
    public boolean groupNoAdj(int start, int[] nums, int target) {
        boolean b=target==0;
        if(start>=nums.length){
            return b;
        } else {
            return groupNoAdj(start+2,nums,target-nums[start])||groupNoAdj(start+1,nums,target);
        }
    }


    public static void main(String[] args) {
        
    }
    
}
