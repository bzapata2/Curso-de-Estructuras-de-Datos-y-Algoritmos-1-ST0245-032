
/**
 * Write a description of class Fecha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Fecha
{
    private int dia;
    private int mes;
    private int año;
    
    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    
    public void setDia(int d) { dia = d; }
    
    public void setMes(int m) { mes = m; }
    
    public void setAño(int a) { año = a; }
    
    public int getDia(){ return dia; }
    
    public int getMes(){ return mes; }
    
    public int getAño(){ return año; }
    
    //comprobar fecha
    
    private boolean bisiesto() {
        return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
    }
    
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = año > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 1:
                if (bisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 2:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }
    
    //mostrar fecha
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dia < 10) {
            sb.append("0");
        }
        sb.append(dia);
        sb.append("/");
        if (mes < 10) {
            sb.append("0");
        }
        sb.append(mes);
        sb.append("/");
        sb.append(año);
        return sb.toString();
    }
    
    public String compararFechas(Fecha fecha) {
        StringBuilder sb = new StringBuilder();
        if (año < fecha.getAño()) {
            sb.append(dia + "/" + mes + "/" + año + " Está antes de: " + 
            fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
            return sb.toString();
        }
        
        if (año > fecha.getAño()) {
            sb.append(dia + "/" + mes + "/" + año + " Está despues de: " + 
            fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
            return sb.toString();
        }
        
        if (año == fecha.getAño() && mes < fecha.getMes()) {
            sb.append(dia + "/" + mes + "/" + año + " Está antes de: " + 
            fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
            return sb.toString();
        }
        
        if (año == fecha.getAño() && mes > fecha.getMes()) {
            sb.append(dia + "/" + mes + "/" + año + " Está despues de: " + 
            fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
            return sb.toString();
        }
        
        if (año == fecha.getAño() && mes == fecha.getMes() && dia < fecha.getDia() ){
            sb.append(dia + "/" + mes + "/" + año + " Está antes de: " + 
            fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
            return sb.toString();
        }
        
        if (año == fecha.getAño() && mes == fecha.getMes() && dia > fecha.getDia() ){
            sb.append(dia + "/" + mes + "/" + año + " Está despues de: " + 
            fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
            return sb.toString();
        }
        
        else{
            sb.append(dia + "/" + mes + "/" + año + " Es igual a: " + 
            fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAño());
            return sb.toString();
        }
        
    }
}
   

