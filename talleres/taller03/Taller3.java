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
public class Taller3 {
    
	/**
	*
	* El mÃ©todo torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* 
	*/	
	
	public static void torresDeHannoi(int n) {
		torresDeHannoiAux(n, 1, 2, 3);
	}

	/**
	*
	* El mÃ©todo torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* @param origen la torre nÃºmero uno donde se posicionan todos los discos inicialmente
	* @param destino la torre donde deben posicionarse todos los discos terminado el proceso
	* @param intermedio torre auxiliar para que el cambio de torres se haga efectivo
	* 
	* debe devolver la secuencia de pasos en consola de esta manera:
	* System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
	*
	* @see <a href="http://www.uterra.com/juegos/torre_hanoi.php"> SimulaciÃ³n del funcionamiento</a>
	* @see <a href="https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i"> Un poco de historia </a>
	*/	
	
	private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
		if(n==1){
                    System.out.println("Mover el disco "+n+" de la torre "+origen+" a la "+destino);
                } else {
                    torresDeHannoiAux(n-1,origen,destino,intermedio);
                    System.out.println("Mover el disco "+n+" de la torre "+origen+" a la "+destino);
                    torresDeHannoiAux(n-1,intermedio,origen,destino);
                }
	}
        
		
		
	/**
	*
	* El mÃ©todo combinations es un auxiliar del proceso 
	* @param s es la cadena a permutar
	*/
	public static void combinations(String s) { 
		combinationsAux("", s); 
		}

	/**
	*
	* El mÃ©todo combinationsAux es el core del proceso, en el se busca conseguir
	* las posibles permutaciones que puede tener la cadena s 
	* @param s es la cadena a permutar
	* @param prefix cadena auxiliar donde se guarda la cadena de salida
	*
	* Las cadenas de salida tienes una longitud desde 0 hasta el lenght de la cadena s
	* por simplicidad del ejercicio no se repiten letras y el orden de la secuencia 
	* no supone importancia, es decir, la cadena AB es igual a la cadena BA.
	* Ej: para la cadena ABC se tiene la salida: { A, AB, ABC, AC, B, BC, C}
	*
	*/
	private static void combinationsAux(String prefix, String s) {  
		if(s.length()==0){
                    System.out.println(prefix);
                } else {
                    for(int i=0;i<s.length();i++){
                        combinationsAux(prefix+s.charAt(i),s.substring(0,i)+s.substring(i+1));
                    }
                }
	}
		
		
	/**
	*
	* El mÃ©todo permutation es un auxiliar del proceso 
	* @param str es la cadena a permutar
	*/
	public static void permutation(String str) {
		permutationAux("", str); 
	}
	
	/**
	*
	* El mÃ©todo permutationAux es el core del proceso, en el se busca conseguir
	* las posibles permutaciones que puede tener la cadena str 
	* @param str es la cadena a permutar
	* @param prefix cadena auxiliar donde se guarda la cadena de salida
	*
	* Las cadenas de salida tienes una longitud de lenght de la cadena s
	* Ej: para la cadena AB se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
	* donde los caracteres no se repiten pero el orden tiene un papel importante.
	*
	*/
	private static void permutationAux(String prefix, String str) {
		//...
	}
        
        public static void main(String[]args){
            //torresDeHannoi(8);
            combinations("abc");
        }
		

}
