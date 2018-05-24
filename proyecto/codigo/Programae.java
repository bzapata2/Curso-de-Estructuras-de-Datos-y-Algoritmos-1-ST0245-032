import java.util.*;

/**
 * Esta clase lee el archivo txt, ordena las abejas respecto al eje x y analiza las colisiones tomando en cuenta el tiempo
 * @author: Braimer Esteban Zapata
 * @version: 23/05/2018
 */

public class Programae {
    public static void main(String [] args){
        long startTime = System.currentTimeMillis();

        Archivo as = new Archivo();
        ArrayList <Abeja>  ab = as.leerTxt(); 

        Ordenadorc or = new Ordenadorc();
        ArrayList <Abeja> ab2 = or.ordenarQSX(ab);

        System.out.println("Abejas en peligro: ");
        Tree choques = new Tree(ab2);
        choques.analizar();

        System.out.println("Numero de abejas analizadas: " + ab2.size());
        System.out.println("Numero de bejas en peligro: " + choques.contador);

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo total = " + estimatedTime + "milisegundos");

    }
}
