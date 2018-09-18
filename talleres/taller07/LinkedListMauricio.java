// Un nodo para una lista simplemente enlazada

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
private final Node first;
private final int size;
public LinkedListMauricio()
{
	size = 0;
	first = null;	
}

	/**
	 * Returns the node at the specified position in this list.
	 * @param index - index of the node to return
	 * @return the node at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < size) {
			Node temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException
	 */
	public int get(int index) throws IndexOutOfBoundsException {
		Node temp = getNode(index);
		return temp.data;
	}

// Retorna el tamaño actual de la lista
public int size()
{
    Node temp = first;
    int cont = 0;
    while(temp.next!=null){
        cont++;
        temp = temp.next;
    }
    return cont;
}

// Inserta un dato en la posición index
public void insert(Node data, int index)
{
    Node temp = first;
    int cont = 0;
    while(cont!=index){
        cont++;
        temp = temp.next;
    }
    temp = data;
}

// Borra el dato en la posición index
public void remove(int index)
{
    Node temp = first;
    int cont = 0;
    while(cont!=index){
        cont++;
        temp = temp.next;
    }
    temp = null;
}

public boolean containsRec(int data, Node temp) {
    //return temp == null? false: temp.data == data? true : containsRec(data, temp.next);
   if (temp == null)
     
     return false;
   else {
     if (temp.data == data)
       return true;
     else
        return containsRec(data, temp.next);
     }
}

  // Verifica si está un dato en la lista
public boolean containsRec(int data) {
   return containsRec(data, first);
}

// Verifica si está un dato en la lista
public boolean contains(int data) {
   Node nodoQueEstoyVisitando = first;
	 while (nodoQueEstoyVisitando != null) {
     if (nodoQueEstoyVisitando.data == data){
       return true;
     }
     nodoQueEstoyVisitando = nodoQueEstoyVisitando.next;
   }
   return false;
}

}