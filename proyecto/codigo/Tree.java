import java.util.*;

public class Tree {
	double radio = 0.005/11; //radio en unidades de grados 
	ArrayList <Abeja> abejas = new ArrayList<Abeja> ();
	int contador = 0;
		
	public Tree(ArrayList <Abeja> abejas){
		this.abejas = abejas;
	}
	
	public void analizar(){
		analizarAux(abejas);
	}
		
	public void analizarAux(ArrayList <Abeja> abejas2){
		//Nodo node = new Nodo(abejas2);
		//System.out.println(abejas2.size());
		int mitad = abejas2.size()/2;
		int mitadMasUno = (abejas2.size()/2)+1;
		int mitadMenosUno = (abejas2.size()/2)-1;
		
		if(abejas2.size() == 2){  //Si quedan 2 abejas
			//System.out.println("Choque1 tree quedan 2");
			colisionEntre(abejas2.get(0), abejas2.get(1));
		} else if(abejas2.size() > 2 && abejas2.size()%2 == 0){ //Si el numero de abejas es par
			//System.out.println("Choque2 tree arreglo par");
			//abejas2.get(mitadMenosUno).mostrar();
			//abejas2.get(mitad).mostrar();
			colisionEntre(abejas2.get(mitadMenosUno), abejas2.get(mitad));
			
			ArrayList <Abeja> der = new ArrayList<Abeja> ();
			ArrayList <Abeja> izq = new ArrayList<Abeja> ();
			for(int i = 0; i < mitad; i++){
				der.add(abejas2.get(i));
			}
			for(int i = mitad; i < abejas2.size(); i++){
				izq.add(abejas2.get(i));
			}
			/*
			//System.out.println("der");
			for(int i = 0; i < der.size(); i++){
				der.get(i).mostrar();
			}
			
			//System.out.println("izq");
			for(int i = 0; i < izq.size(); i++){
				izq.get(i).mostrar();
			}*/
			
			analizarAux(der);
			analizarAux(izq);
		} else if(abejas2.size() == 3){
			//System.out.println("Choque3 tree arreglo con 3");
			//abejas2.get(0).mostrar();
			//abejas2.get(1).mostrar();
			//abejas2.get(2).mostrar();
			colisionEntre(abejas2.get(0), abejas2.get(1));
			colisionEntre(abejas2.get(0), abejas2.get(2));
			colisionEntre(abejas2.get(1), abejas2.get(2));
		} else if(abejas2.size() > 3){
			//System.out.println("Choque4 tree arrego mayor a 3 e impar");
			///
			// for desde la mitad hacia la izquierda
			for(int i = mitad-1; i > -1; i--){
				//System.out.println("Estoy en el ford izq");
				if(!colision(abejas2.get(mitad), abejas2.get(i))){
					break;
				} else if(colision(abejas2.get(mitad), abejas2.get(i))){
					choque(abejas2.get(mitad), abejas2.get(i));
				}
				//colisionEntre(abejas2.get(mitad), abejas2.get(i));
			}
			
			//hacia la derecha
			for(int i = mitad+1; i < abejas2.size(); i++){
				//System.out.println("Estoy en el ford der");
				if(!colision(abejas2.get(mitad), abejas2.get(i))){
					break;
				} else if(colision(abejas2.get(mitad), abejas2.get(i))){
					choque(abejas2.get(mitad), abejas2.get(i));
				}
				
				
				//colisionEntre(abejas2.get(mitad), abejas2.get(i));
				
			}
			///
			//colisionEntre(abejas2.get(mitadMenosUno), abejas2.get(mitad));
			//colisionEntre(abejas2.get(mitad), abejas2.get(mitadMasUno));
			ArrayList <Abeja> der = new ArrayList<Abeja> ();
			ArrayList <Abeja> izq = new ArrayList<Abeja> ();
			for(int i = 0; i < abejas2.size()/2; i++){
				der.add(abejas2.get(i));
			}
			for(int i = mitadMasUno; i < abejas2.size(); i++){
				izq.add(abejas2.get(i));
			}
			
			//node.der = new Nodo(der);
			//node.izq = new Nodo(izq);
			analizarAux(der);
			analizarAux(izq);
		}		
	}
	
	public boolean hayDosAbejas(ArrayList <Abeja> abr){
		if(abr.size() == 2){
			return true;
		}
		return false;
	}
	
	public boolean colisionEntre(Abeja pivote, Abeja b){
		
		
		//este analiza si son iguales
		if((pivote.getX() == b.getX()) && (pivote.getY() == b.getY())){
			//System.out.println("Coque iguales: ");
			choque(pivote, b);
			return true;
		}
		
		//como se sabe el orden de la x se hace la resta normal
		double x = pivote.getX() - b.getX();
		//System.out.println("cateto x: " +  x);
		//se analiza si la abeja b esta mas arriba o abajo de la abeja pivote respecto al eje y y se hace la resta
		double y;
		if(pivote.getY() > b.getY()){
			y = pivote.getY() - b.getY();
		} else {
			y = b.getY() - pivote.getY();
		}
		//System.out.println("cateto y: " +  y);
		//raiz cuadrada de el cateto1 + cateto2 los 2 al cuadrado (pitagoras) para hayar distancia(hipotenusa) entre las abjeas
		double h = Math.sqrt((x*x)+(y*y));
		//System.out.println("hipotenusa h: " +  h);
		
		//distancia para que haya colision
		double collision = radio + radio;
		
		//si h(hiponesuna) es menor a la suma de los radios entonces colision
		if(h <= collision){
			//System.out.println("Choque sin ser igual");
			choque(pivote, b);
			return true;
		}
		return false;
	}
	
	public boolean colision(Abeja pivote, Abeja b){
		
		
		//este analiza si son iguales
		if((pivote.getX() == b.getX()) && (pivote.getY() == b.getY())){
			//System.out.println("Coque iguales: ");
			return true;
		}
		
		//como se sabe el orden de la x se hace la resta normal
		double x = pivote.getX() - b.getX();
		//System.out.println("cateto x: " +  x);
		//se analiza si la abeja b esta mas arriba o abajo de la abeja pivote respecto al eje y y se hace la resta
		double y;
		if(pivote.getY() > b.getY()){
			y = pivote.getY() - b.getY();
		} else {
			y = b.getY() - pivote.getY();
		}
		//System.out.println("cateto y: " +  y);
		//raiz cuadrada de el cateto1 + cateto2 los 2 al cuadrado (pitagoras) para hayar distancia(hipotenusa) entre las abjeas
		double h = Math.sqrt((x*x)+(y*y));
		//System.out.println("hipotenusa h: " +  h);
		
		//distancia para que haya colision
		double collision = radio + radio;
		
		//si h(hiponesuna) es menor a la suma de los radios entonces colision
		if(h <= collision){
			//System.out.println("Choque sin ser igual");
			return true;
		}
		return false;
	}
	
	
	public void choque(Abeja a, Abeja b){
		a.mostrar();
		contador++;
		//System.out.println("Abeja en la posicion: " + a.getX() + "," + a.getY() + 
		//			" con abeja en la poscion: " + b.getX() + "," + b.getY());
	}
}
