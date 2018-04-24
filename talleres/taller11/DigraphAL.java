import java.util.ArrayList;
public class DigraphAL
{
    ///// listas/////
    int tam = 0;
    ArrayList[]nodo = new ArrayList[tam];
    
    public DigraphAL(int size) {
        this.tam = size;
    }
    
    public void addArc(int source, int destination, int weight){
        nodo[source].add(destination, weight);
    }
    
    public int getWeight(int source, int destination) {
        return (int) this.nodo[source].get(destination);
    }
    
     public ArrayList<Integer> getSuccessors(int vertice){
        return this.nodo[vertice];
    }
}