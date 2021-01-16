package account;

import java.util.Random;

public final class AccountNumberGenerator {
    public static String nextAccountNumber() {
        StringBuilder accNumber = new StringBuilder();
        for(int i=0 ; i < 16 ; i++) {
            accNumber.append(new Random().nextInt(10));
        }
        return accNumber.toString();
    }
}
