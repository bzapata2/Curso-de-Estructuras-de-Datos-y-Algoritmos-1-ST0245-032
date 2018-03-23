public class Combination2{
    public static void Combination(String base){
        combinationsAux(base,"");
   }
   static void combinationsAux(String base,String a){
       if(base.length() == 0){
           System.out.println(a);
       } else{
           combinationsAux(base.substring(1),a + base.substring(0,1));
           combinationsAux(base.substring(1),a);
       }
   }
}