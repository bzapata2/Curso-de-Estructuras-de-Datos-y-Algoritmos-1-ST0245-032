import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
    private Node first;
    private int size;
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
     */
    public int get(int index) {
        Node temp = null;
        try {
            temp = getNode(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.exit(0);
        }

        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {
        return this.size;
        /*
        Node temp = first;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        return size;
        */
    }

    // Inserta un dato en la posición index
    public void insert(int data, int index)
    {
        Node nuevo = new Node(data);
        if(index == 0){
            nuevo.next = first;
            first = nuevo;  
        } else if (index > 0 && index <= size) {
            Node temp = first;
            for (int i = 0; i < index-1; i++) {
                temp = temp.next;
            }
            nuevo.next = temp.next;
            temp.next = nuevo;
        } else {
            throw new IndexOutOfBoundsException();
        }
        size++;
    }

    // Borra el dato en la posición index
    public void remove(int index)
    {
        if(index == 0){
            first = first.next;
        } else if (index > 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index-1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        } else {
            throw new IndexOutOfBoundsException();
        }
        size--;
    }

    // Verifica si está un dato en la lista
    public boolean contains(int data)
    {
       Node dato = new Node(data);
       if(size != 0){
           Node temp = first;
           for (int i = 0; i <= size; i++) {
              if(temp == dato){
                  return true;
              }
              temp = temp.next;
           }
       }
       return false;
    }
}
