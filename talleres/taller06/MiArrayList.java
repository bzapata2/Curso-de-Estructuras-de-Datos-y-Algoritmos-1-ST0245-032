 
import java.util.Arrays;
/**
 *
 * @author 
 */
public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[]; 
    
    // Inicializa los atributos size en cero y elements como un arreglo de tamaño  DEFAULT_CAPACITY. No, no recibe parámetros. public MiArrayList() {}          
    // Retorna el tamaño de la lista public int size() {}          
    // Agrega un elemento e a la última posición de la lista public void add(int e) {}          
    // Retorna el elemento que se encuentra en la posición i de la lista public int get(int i) {}          
    // Agrega un elemento e en la posición index de la lista
    public MiArrayList() {
        size = 0;
        elements = new  int[DEFAULT_CAPACITY];
    }     

    
    // Retorna el tamaño de la lista 
    public int size() {
        return this.size;
    }   
    
    // Agrega un elemento e a la última posición de la lista
    public void add(int e) {
        if(size == elements.length){
            int [] elements2 = new  int[elements.length*2];
            for(int i = 0; i < size; i++){
                elements2[i] = elements[i];
            }
            elements2[size] = e;
            elements = elements2;
        } else if (size == 0){
            elements[0] = e;
        } else {
           elements[size] = e;
        }
        size = size+1;
    }    
    
    
    // Retorna el elemento que se encuentra en la posición i de la lista 
    public int get(int i) {
        return elements[i];
    }
    
    
    // Agrega un elemento e en la posición index de la lista
    public void add(int index, int e) {
      if(index >= 0 && index <= size){
        if(size == elements.length){
            int [] elements2 = new  int[elements.length*2];
            for(int i = 0; i < size; i++){
                elements2[i] = elements[i];
            }
            elements = elements2;
        } 
         for(int i = size; i>=index+1; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
      }
    }
    
}