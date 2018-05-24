import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Archivo {
    public ArrayList<Abeja> leerTxt(){
        ArrayList <Abeja> abejas = new ArrayList <Abeja> ();
        try{
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\bzapata2\\Downloads\\ConjuntoDeDatosCon10abejas.txt"));
            String temp = "";
            String bfRead;
            bf.readLine();
            while((bfRead = bf.readLine()) != null){
                temp = bfRead;
                String [] a = temp.split(",");
                double x = Double.parseDouble(a[0]);
                double y = Double.parseDouble(a[1]);
                Abeja ag = new Abeja(x, y);
                abejas.add(ag);
            }
        } catch (Exception e) {
            System.err.println("No se encontro archivo");
        }
        return abejas;
    }
}
