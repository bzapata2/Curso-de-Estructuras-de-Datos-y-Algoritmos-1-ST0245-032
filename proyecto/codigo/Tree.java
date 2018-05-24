import java.util.*;

public class Tree {
    double radio = 0.005/11;
    ArrayList <Abeja> abejas = new ArrayList<Abeja> ();
    int contador = 0;
        
    public Tree(ArrayList <Abeja> abejas){
        this.abejas = abejas;
    }
    
    public void analizar(){
        analizarAux(abejas);
    }
        
    public void analizarAux(ArrayList <Abeja> abejas2){
        int mitad = abejas2.size()/2;
        int mitadMasUno = (abejas2.size()/2)+1;
        int mitadMenosUno = (abejas2.size()/2)-1;
        
        if(abejas2.size() == 2){ 
            colisionEntre(abejas2.get(0), abejas2.get(1));
        } else if(abejas2.size() > 2 && abejas2.size()%2 == 0){ //Si el numero de abejas es par
            colisionEntre(abejas2.get(mitadMenosUno), abejas2.get(mitad));
            
            ArrayList <Abeja> der = new ArrayList<Abeja> ();
            ArrayList <Abeja> izq = new ArrayList<Abeja> ();
            for(int i = 0; i < mitad; i++){
                der.add(abejas2.get(i));
            }
            for(int i = mitad; i < abejas2.size(); i++){
                izq.add(abejas2.get(i));
            }
            
            analizarAux(der);
            analizarAux(izq);
        } else if(abejas2.size() == 3){
            colisionEntre(abejas2.get(0), abejas2.get(1));
            colisionEntre(abejas2.get(0), abejas2.get(2));
            colisionEntre(abejas2.get(1), abejas2.get(2));
        } else if(abejas2.size() > 3){
            for(int i = mitad-1; i > -1; i--){
                if(!colision(abejas2.get(mitad), abejas2.get(i))){
                    break;
                } else if(colision(abejas2.get(mitad), abejas2.get(i))){
                    choque(abejas2.get(mitad), abejas2.get(i));
                }
            }
            
            for(int i = mitad+1; i < abejas2.size(); i++){
                if(!colision(abejas2.get(mitad), abejas2.get(i))){
                    break;
                } else if(colision(abejas2.get(mitad), abejas2.get(i))){
                    choque(abejas2.get(mitad), abejas2.get(i));
                }
            }
            
            ArrayList <Abeja> der = new ArrayList<Abeja> ();
            ArrayList <Abeja> izq = new ArrayList<Abeja> ();
            for(int i = 0; i < abejas2.size()/2; i++){
                der.add(abejas2.get(i));
            }
            for(int i = mitadMasUno; i < abejas2.size(); i++){
                izq.add(abejas2.get(i));
            }
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
        if((pivote.getX() == b.getX()) && (pivote.getY() == b.getY())){
            choque(pivote, b);
            return true;
        }
        
        double x = pivote.getX() - b.getX();
        
        double y;
        if(pivote.getY() > b.getY()){
            y = pivote.getY() - b.getY();
        } else {
            y = b.getY() - pivote.getY();
        }
        
        double h = Math.sqrt((x*x)+(y*y));
        
        double collision = radio + radio;
        
        if(h <= collision){
            choque(pivote, b);
            return true;
        }
        return false;
    }
    
    public boolean colision(Abeja pivote, Abeja b){
        if((pivote.getX() == b.getX()) && (pivote.getY() == b.getY())){
            return true;
        }
        
        double x = pivote.getX() - b.getX();
        
        double y;
        if(pivote.getY() > b.getY()){
            y = pivote.getY() - b.getY();
        } else {
            y = b.getY() - pivote.getY();
        }
        
        double h = Math.sqrt((x*x)+(y*y));
        
        double collision = radio + radio;
        
        if(h <= collision){
            return true;
        }
        return false;
    }
    
    public void choque(Abeja a, Abeja b){
        a.mostrar();
        b.mostrar();
        contador = contador + 2;
    }
}
