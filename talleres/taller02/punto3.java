
/**
 * Write a description of class punto3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class punto3
{
    public static void combinations(int i, String p, String w){
        if(i == w.length()){
            System.out.println(p);
            return;
        }
        combinations(i + 1, p + w.charAt(i), w);
        combinations(i + 1, p, w);
    }
}
