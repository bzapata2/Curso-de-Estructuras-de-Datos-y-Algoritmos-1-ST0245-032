import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Archivo {
	public ArrayList<Abeja> leerTxt(){
		ArrayList <Abeja> abejas = new ArrayList <Abeja> ();
		try{
			BufferedReader bf = new BufferedReader(new FileReader("D:\\Esteban\\Universidad\\DATOS_Y_ALGORITMOS\\PROYECTO\\Hola.txt"));
			String temp = "";
			String bfRead;
			//int temp2 = 0;
			bf.readLine();
			while((bfRead = bf.readLine()) != null){
				temp = bfRead;
				String [] a = temp.split(",");
				double x = Double.parseDouble(a[0]);
				double y = Double.parseDouble(a[1]);
				Abeja ag = new Abeja(x, y);
				abejas.add(ag);
				//temp2 = temp2 + 1;
			}
		} catch (Exception e) {
			System.err.println("No se encontro archivo");
		}
		return abejas;
	}
}
