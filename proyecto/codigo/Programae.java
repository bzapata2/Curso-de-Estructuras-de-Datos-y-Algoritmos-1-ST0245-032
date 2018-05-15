import java.util.*;

public class Programae {
	public static void main(String [] args){
		long startTime = System.currentTimeMillis();
		//leer TXT y almacena en un arreglo de abejas
				Archivo as = new Archivo();
				ArrayList <Abeja>  ab = as.leerTxt(); 
				
				
				System.out.println("Arreglo original");
				for(int i = 0; i < ab.size(); i++){
					ab.get(i).mostrar();
				}
				System.out.println("");
				
				//ordena el arreglo de abejas
				Ordenador or = new Ordenador();
				ArrayList <Abeja> ab2 = or.ordenarQSX(ab);
				//List<Abeja> lista = ab2.subList(0,3);
				//System.out.println(lista.size());
				//ArrayList <Abeja> ab2 = or.ordenarQSY(ab1);
				
				System.out.println("Arreglo Ordenado: ");
				for(int i= 0; i < ab2.size(); i++){
					ab2.get(i).mostrar(); 
				}
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				
				System.out.println("Abejas en peligro: ");
				Tree choques = new Tree(ab2);
				choques.analizar();
				System.out.println("Numero de bejas en peligro: " + choques.contador);
				
				long estimatedTime = System.currentTimeMillis() - startTime;
				System.out.println("Tiempo total = " + estimatedTime);
	}
}
