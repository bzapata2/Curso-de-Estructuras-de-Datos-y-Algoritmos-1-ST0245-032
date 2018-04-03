 
import java.util.HashMap;

/**
 *
 * @author 
 */
public class Taller9{
    
    //pedrito 2
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key, value);
    }
    
    //pedrito 3
    public static void buscar(HashMap empresas,String key){
        empresas.get(key);
    }
    //pedrito 4
    public static boolean contienekey(HashMap empresas,String value){
        return empresas.containsValue(value);
    }
    
    public static void main (String [ ] args) {
        String key1 = "Google";
        String key2 = "La locura";
        String key3 = "Nokia";
        String key4 = "Sony";
        String value1 = "Estados Unidos";
        String value2 = "Colombia";
        String value3 = "Finlandia";
        String value4 = "Japon";
       // HashMap <String, String> pedrito = new HasMap();
        //agregar(pedrito2, key1, value1);
        //agregar(pedrito2, key2, value2);
        //agregar(pedrito2, key3, value3);
        //agregar(pedrito2, key4, value4);
        
        //buscar(pedrito, key1);
        
        
        
    }
        
}
