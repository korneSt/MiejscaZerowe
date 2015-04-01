import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.math.BigDecimal;
import static java.lang.Math.*;
/**
 * Created by Kornel on 2015-03-31.
 */
public class Wynik {

    public static void wykonaj(TextField tA, TextField tB, TextField tC, Text wynikObliczen){
        int a=-1, b=-1, c=-1;
        double wynik, wynik1;
        boolean czyOK=false;
        while(!czyOK) {
            try {
                a = Integer.parseInt(tA.getText());
                b = Integer.parseInt(tB.getText());
                c = Integer.parseInt(tC.getText());
            } catch (NumberFormatException e) {
                AlertBox.display("Błąd", "Błąd wprowadzonych danych");

            }
            czyOK = a == -1? false : true;
        }

        double delta;
        double wyOst, wyOst1;
            //if (a == 0 && b == 0 && c == 0) AlertBox.display("Błąd", "To nie jest funkcja kwadratowa");



        delta = pow(b,2) - 4*a*c;
        if (delta == 0){
            wynik = (b*(-1)/(2*a));
            wyOst=new BigDecimal(wynik).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            wynikObliczen.setText("Miejsce zerowe funkcji to: "+
                    String.valueOf(wyOst));
        }
        else if (delta >0){
            wynik = (b*(-1) + sqrt(delta))/(2*a);
            wynik1 = (b*(-1) - sqrt(delta))/(2*a);
            wyOst=new BigDecimal(wynik ).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            wyOst1=new BigDecimal(wynik1).setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            wynikObliczen.setText("Miejsca zerowe funkcji to: "+
                    String.valueOf(wyOst) +
                    ", " + String.valueOf(wyOst1));
        }
        else {
            wynikObliczen.setText("Funkcja nie ma miejsc zerowych");
        }

    }
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
