package co.edu.unillanos.msg.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static co.edu.unillanos.msg.domain.Mortgage.WEEKS_PER_YEAR;

/**
 * Inversión de la MSG Foundation.
 * Rol responsable: Inversiones.
 *
 * Decisión D3 (tomada, revisable): la clase está declarada final.
 * ¿La mantienen así? Anoten en la hoja una ventaja y un riesgo.
 */
public final class Investment {

    private final String investmentId;
    private final String description;
    private final BigDecimal annualExpectedReturn;

    public Investment(String investmentId, String description, BigDecimal annualExpectedReturn) {
        this.investmentId = Objects.requireNonNull(investmentId);
        this.description = Objects.requireNonNull(description);
        this.annualExpectedReturn = Objects.requireNonNull(annualExpectedReturn);
    }

    public String investmentId() {
        return investmentId;
    }

    public String description() {
        return description;
    }

    public BigDecimal annualExpectedReturn() {
        return annualExpectedReturn;
    }

    /** RN6: rendimiento anual esperado / 52, en dólares con 2 decimales. */
    public BigDecimal weeklyReturn() {
        BigDecimal weeklyReturnCalculated = annualExpectedReturn.divide(WEEKS_PER_YEAR, 2, RoundingMode.HALF_EVEN);
        return weeklyReturnCalculated;
    }
}
