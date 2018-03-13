
import java.util.*;
import java.util.Stack;

/**
 *
 * @author 
 */
public class Taller8
 {

    //Punto 1
    public static Stack <Integer> inversa (){
        Stack <Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Stack <Integer> stackTemp = new Stack<Integer>();
        stackTemp.push(stack.pop());
        stackTemp.push(stack.pop());
        stackTemp.push(stack.pop());
        return stackTemp;
    }

    //Punto 2
    public static void cola (){
        Queue <String> queue = new LinkedList <String> ();
        queue.add("Juan");
        queue.add("María");
        queue.add("Pedro");
        //for que vaya hasta que la cola este vacia
        System.out.println("Atendiendo a: " + queue.remove());
    }

    //notacion polaca
    public static void punto3(String str){
        Stack<Integer> pila = new Stack();
        str.split(" ");
        for(String x: str.split(" ")){
            if (x.equals("+"))
                pila.push(pila.pop() + pila.pop());
            else if (x.equals("*"))
                pila.push(pila.pop() * pila.pop());
            else if (x.equals("/")){
                int b = pila.pop();
                int a = pila.pop();
                pila.push( a / b);
            }
            else if (x.equals("-")){
                int b = pila.pop();
                int a = pila.pop();
                pila.push( a - b);
            }
            else
                pila.push(Integer.parseInt(x));
        }
        System.out.println(pila.pop());
    }
}
