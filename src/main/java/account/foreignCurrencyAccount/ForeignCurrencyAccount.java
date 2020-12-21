package account.foreignCurrencyAccount;
import account.Account;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ForeignCurrencyAccount extends Account {

    //ctors

    /**
     *
     * @param newCurrency it is a parameter that defines a currency youwant to calculate to
     * @return double value of amount of money in newCurrency
     */
    public double calculateToAnotherCurrency(CurrencyManager.Currency newCurrency) {
        return getBalance() * CurrencyManager.getExchangeRateOf(newCurrency);
    }
}