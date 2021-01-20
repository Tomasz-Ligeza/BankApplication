package auto.calculators;

import java.util.concurrent.ExecutionException;

public class InterestCalculator {
    private static double interest;
    private static double rate; // 0 - 1

    public static double calculateInterestOfLoan(double amount, int time) throws Exception {
        if (amount >= 0 && time > 0) {
            rate = 0.15;    //15%
            interest = ((amount*rate*Math.pow(1+rate, time))/ (Math.pow(1+rate, time-1)));
            return interest;
        }else {
            throw new IllegalArgumentException("Values less than zero");
        }

    }
}
