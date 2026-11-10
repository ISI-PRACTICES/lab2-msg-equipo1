package co.edu.unillanos.msg.infrastructure.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyFormatTest {

    @Test
    void testFormatPositiveNumber() {
        String result = MoneyFormat.format(1160);
        assertEquals("$ 1160.00", result);
    }

    @Test
    void testFormatDecimalNumber() {
        String result = MoneyFormat.format(0.5);
        assertEquals("$ 0.50", result);
    }

    @Test
    void testFormatNegativeNumber() {
        String result = MoneyFormat.format(-750);
        assertEquals("$ -750.00", result);
    }
}