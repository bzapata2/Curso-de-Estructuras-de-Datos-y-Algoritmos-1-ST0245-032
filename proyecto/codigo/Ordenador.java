import java.util.ArrayList;

public class Ordenador {
	
	public ArrayList<Abeja> ordenarQSX(ArrayList<Abeja> abe){
		return ordenarQS2X(abe, 0, abe.size()-1);
	}
	
	public ArrayList<Abeja> ordenarQS2X(ArrayList<Abeja> abbe, int izq, int der){
		if(izq >= der)
			return abbe;
		int i = izq;
		int d = der;
		if(izq != der){
			int pivote;
			double aux;
			double aux2;
			pivote = izq;
			while(izq != der){
					//while(((abbe.get(der).getX()+abbe.get(der).getY()) >= (abbe.get(pivote).getX()+abbe.get(pivote).getY())) && izq < der)
					while((abbe.get(der).getX() >= abbe.get(pivote).getX()) && izq < der)	
							der--;
						while((abbe.get(izq).getX() < abbe.get(pivote).getX()) && izq < der)
							izq++;
					
					if(der != izq){
						aux = abbe.get(der).getX();
						abbe.get(der).setX((abbe.get(izq).getX()));
						abbe.get(izq).setX(aux);
						aux2 = abbe.get(der).getY();
						abbe.get(der).setY((abbe.get(izq).getY()));
						abbe.get(izq).setY(aux2);
					}
		    }
			if(izq == der){
				ordenarQS2X(abbe, i, izq-1);
				ordenarQS2X(abbe, izq+1, d);
			}
		} else {
			return abbe;
		}
		return abbe;
	}
	
}
