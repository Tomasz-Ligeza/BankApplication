package auto.calculators;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.aggregator.AggregateWith;

import static org.junit.jupiter.api.Assertions.*;

class InterestCalculatorTest {
    private double amount;
    private int time;

    double result;

    @BeforeEach
    public void setUpClass() {
    }

    @AfterAll
    public static void tearDown() {
    }

    @Test
    void calculateInterestOfLoan_paramsZero_assertZero() throws Exception {
        amount = 0;
        time = 0;

        result = InterestCalculator.calculateInterestOfLoan(amount, time);

        Assertions.assertEquals(0, result);
    }

    @Test
    void calculateInterestOfLoan_amountZero_assertZero() throws Exception {
        amount = 0;
        time = 90;

        result = InterestCalculator.calculateInterestOfLoan(amount, time);

        Assertions.assertEquals(0, result);
    }

    @Test
    void calculateInterestOfLoan_timeZero_assertNotZero() throws Exception {
        amount = 10000;
        time = 0;

        result = InterestCalculator.calculateInterestOfLoan(amount, time);

        Assertions.assertNotEquals(0, result);
    }

    @Test
    void calculateInterestOfLoan_paramsNotZero_resultOverZero() throws Exception {
        amount = 10000;
        time = 10;

        result = InterestCalculator.calculateInterestOfLoan(amount, time);

        Assertions.assertTrue(result > 0);
    }

    @Test
    void calculateInterestOfLoan_amountLessThanZero_throwsIllegalArgumentException() {
        amount = -10;
        time = 60;

        Assertions.assertThrows(IllegalArgumentException.class, () -> InterestCalculator.calculateInterestOfLoan(amount, time));
    }

    @Test
    void calculateInterestOfLoan_timeLessThanZero_throwsIllegalArgumentException() {
        amount = 10000;
        time = -10;

        Assertions.assertThrows(IllegalArgumentException.class, () -> InterestCalculator.calculateInterestOfLoan(amount, time));
    }

    @Test
    void calculateInterestOfLoan_bothArgumentsLessThanZero_throwsIllegalArgumentException() {
        amount = -10000;
        time = -10;

        Assertions.assertThrows(IllegalArgumentException.class, () -> InterestCalculator.calculateInterestOfLoan(amount, time));
    }
}
