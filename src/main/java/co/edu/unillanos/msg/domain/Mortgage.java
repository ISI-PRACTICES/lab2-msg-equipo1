package co.edu.unillanos.msg.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Hipoteca otorgada por la MSG Foundation a una pareja.
 * Rol responsable: Hipotecas.
 */
public final class Mortgage {

    static final BigDecimal WEEKS_PER_YEAR = new BigDecimal("52");
    private static final double MAX_INCOME_ALLOWED = 0.28;
    // TODO (RN4): declare aquí, una sola vez y con nombre, el porcentaje máximo
    //             del ingreso que aporta la pareja (28 %).

    private final String mortgageNumber;
    private final BigDecimal weeklyPrincipalAndInterest;
    private final BigDecimal annualPropertyTax;
    private final BigDecimal annualInsurancePremium;
    private final BigDecimal coupleWeeklyIncome;

    // Decisión D2 (abierta): ¿el subsidio y el aporte de la pareja se guardan como
    // atributos al construir la hipoteca, o se calculan cada vez que se piden?

    public Mortgage(String mortgageNumber, BigDecimal weeklyPrincipalAndInterest,
                    BigDecimal annualPropertyTax, BigDecimal annualInsurancePremium,
                    BigDecimal coupleWeeklyIncome) {
        this.mortgageNumber = Objects.requireNonNull(mortgageNumber);
        this.weeklyPrincipalAndInterest = Objects.requireNonNull(weeklyPrincipalAndInterest);
        this.annualPropertyTax = Objects.requireNonNull(annualPropertyTax);
        this.annualInsurancePremium = Objects.requireNonNull(annualInsurancePremium);
        this.coupleWeeklyIncome = Objects.requireNonNull(coupleWeeklyIncome);
        if (coupleWeeklyIncome.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("El ingreso semanal de la pareja debe ser mayor a 0. Actualmente es " + coupleWeeklyIncome.toString());
        // TODO (R6): rechazar con IllegalArgumentException un ingreso semanal
        //            de la pareja menor o igual a cero.
    }

    public String mortgageNumber() {
        return mortgageNumber;
    }

    /** RN2: costo semanal de impuesto predial y seguro. Ejemplo resuelto. */
    public BigDecimal weeklyEscrow() {
        return annualPropertyTax.add(annualInsurancePremium)
                .divide(WEEKS_PER_YEAR, 2, RoundingMode.HALF_EVEN);
    }

    /** RN3: capital e intereses más el costo semanal de impuesto y seguro. */
    public BigDecimal totalWeeklyPayment() {
        BigDecimal totalWeeklyPaymentPaar = BigDecimal.ZERO;
        totalWeeklyPaymentPaar= weeklyPrincipalAndInterest.add(weeklyEscrow());
        return totalWeeklyPaymentPaar;
//        throw new UnsupportedOperationException("TODO");
    }

    /** RN4: lo máximo que la pareja aporta por semana. */
    public BigDecimal maxCoupleContribution() {
        BigDecimal maxContribution = coupleWeeklyIncome;
        maxContribution= maxContribution.multiply(BigDecimal.valueOf(MAX_INCOME_ALLOWED));
        return maxContribution;
//        throw new UnsupportedOperationException("TODO");
    }

    /** RN5: lo que cubre la fundación; nunca es negativo. */
    public BigDecimal weeklyGrant() {
        BigDecimal grant = BigDecimal.ZERO;
        if (maxCoupleContribution().compareTo(totalWeeklyPayment()) < 0) {
            grant = grant.add(totalWeeklyPayment());
            grant = grant.subtract(maxCoupleContribution());
        }
        return grant;
//        throw new UnsupportedOperationException("TODO");
    }

    /** Lo que paga la pareja: cuota total menos subsidio. */
    public BigDecimal weeklyCoupleContribution() {
        BigDecimal coupleContribution = totalWeeklyPayment();
        coupleContribution = coupleContribution.subtract( weeklyGrant());
        return coupleContribution;
//        throw new UnsupportedOperationException("TODO");
    }
}
