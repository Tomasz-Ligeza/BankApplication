package account;

import java.util.Random;

public final class AccountNumberGenerator {

    /**
     * Generates 16-digital account number.
     * @return 16-digital String account number.
     */
    public static String nextAccountNumber() {
        StringBuilder accNumber = new StringBuilder();
        for(int i=0 ; i < 16 ; i++) {
            accNumber.append(new Random().nextInt(10));
        }
        return accNumber.toString();
    }
}