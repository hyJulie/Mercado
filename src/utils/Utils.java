package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * A classe Utils fornece metodos para formatacao de valores Double em moeda brasileira.
 */
public class Utils {
    /**
     * Um objeto NumberFormat para formatacao de moeda brasileira.
     */
    static NumberFormat numberFormat =
            new DecimalFormat("R$ #,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    /**
     * Formata um valor Double em uma String representando a moeda brasileira.
     *
     * @param value O valor Double a ser formatado.
     * @return Uma String contendo o valor formatado como moeda brasileira.
     */
    public static String doubleToString(Double value){
        return numberFormat.format(value);
    }
}
