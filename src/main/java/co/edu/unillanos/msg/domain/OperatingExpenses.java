package co.edu.unillanos.msg.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static co.edu.unillanos.msg.domain.Mortgage.WEEKS_PER_YEAR;

/**
 * Gastos operativos anuales estimados de la MSG Foundation.
 * Rol responsable: Inversiones.
 */
public final class OperatingExpenses {

    private final BigDecimal annualAmount;

    public OperatingExpenses(BigDecimal annualAmount) {
        this.annualAmount = Objects.requireNonNull(annualAmount);
    }

    public BigDecimal annualAmount() {
        return annualAmount;
    }

    /** RN7: gasto anual repartido igual entre 52 semanas, con 2 decimales. */
    public BigDecimal weeklyAmount() {
        BigDecimal weeklyAmountCalculated = annualAmount.divide(WEEKS_PER_YEAR, 2, RoundingMode.HALF_EVEN);
        return weeklyAmountCalculated;
        //throw new UnsupportedOperationException("TODO");
    }
}
