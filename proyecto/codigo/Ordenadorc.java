
/**
 * Write a description of class Ordenadorc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Ordenadorc
{
    public ArrayList<Abeja> ordenarQSX(ArrayList<Abeja> abe){
        return quickSort(abe, 0, abe.size()-1);
    }

    public ArrayList<Abeja> quickSort(ArrayList<Abeja> vec, int inicio, int fin){
        if(inicio>=fin) return vec;
        Abeja pivote=vec.get(inicio);
        int elemIzq=inicio+1;
        int elemDer=fin;
        double temp;
        while(elemIzq<=elemDer){
            while(elemIzq<=fin && vec.get(elemIzq).getX()<pivote.getX()){
                elemIzq++;
            }
            while(elemDer>inicio && vec.get(elemDer).getX()>=pivote.getX()){
                elemDer--;
            }
            if(elemIzq<elemDer){
                temp = vec.get(elemIzq).getX();
                vec.get(elemIzq).setX(vec.get(elemDer).getX());
                vec.get(elemDer).setX(temp);

                temp = vec.get(elemIzq).getY();
                vec.get(elemIzq).setY(vec.get(elemDer).getY());
                vec.get(elemDer).setY(temp);
            }
        }

        if(elemDer>inicio){
            temp = vec.get(inicio).getX();
            vec.get(inicio).setX(vec.get(elemDer).getX());
            vec.get(elemDer).setX(temp);

            temp = vec.get(inicio).getY();
            vec.get(inicio).setY(vec.get(elemDer).getY());
            vec.get(elemDer).setY(temp);

        }
        quickSort(vec, inicio, elemDer-1);
        quickSort(vec, elemDer+1, fin);

        return vec;
    }
}
