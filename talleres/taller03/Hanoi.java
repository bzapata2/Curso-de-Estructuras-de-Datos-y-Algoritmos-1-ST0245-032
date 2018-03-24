public class Hanoi {
    private static void HanoiAux(int n, char origen, char intermedio, char destino) {
        if(n == 1){
            System.out.println(" Mover disco " + n + ", a torre " + destino + "\n");
        } else {
            HanoiAux(n-1, origen, destino, intermedio);
            System.out.println(" Mover disco " + n + ", a torre " + destino + "\n");
            HanoiAux(n-1, intermedio, origen, destino);
        }
    }   
    public static void Hanoi(int n) {
        HanoiAux(n, 'A', 'B', 'C');
    }
}
