
public class BinarySearchTree {
    private Nodo raiz;
    private void imprimir(Nodo nodo){
        if (nodo != null){
            imprimir(nodo.izq);
            System.out.println(nodo.dato);
            imprimir(nodo.der);
        }
    }

    public void imprimir(){
        imprimir(raiz);
    }

    private void insertar(Nodo nodo, int n){            
        if (nodo.dato == n)
            return ;
        if (n > nodo.dato)
            if (nodo.der == null)
                nodo.der = new Nodo(n);
            else
                insertar(nodo.der, n);
        else
        if (nodo.izq == null)
            nodo.izq = new Nodo(n);
        else
            insertar(nodo.izq, n);   
    }

    public void insertar(int n){
        if (raiz == null)
            raiz = new Nodo(n);
        else
            insertar(raiz, n);
    }

    private boolean buscar(Nodo nodo, int n){
        if (nodo == null)
            return false;
        if (nodo.dato == n)
            return true;
        if (n > nodo.dato)
            return buscar(nodo.der, n);
        return buscar(nodo.izq, n);             
    }

    public boolean buscar(int n){
        return buscar(raiz,n);
    }
}
