package co.edu.unillanos.msg.infrastructure.ui;

import java.util.Locale;

public final class MoneyFormat {

    private MoneyFormat() {
        // Constructor privado para evitar instanciación
    }

    /**
     * Formatea un valor numérico a un formato de moneda con dos decimales y punto decimal.
     * Ejemplo: 1160.0 -> "$ 1160.00"
     *
     * @param amount El monto a formatear.
     * @return Cadena formateada como "$ X.XX".
     */
    public static String format(double amount) {
        return String.format(Locale.ROOT, "$ %.2f", amount);
    }
}