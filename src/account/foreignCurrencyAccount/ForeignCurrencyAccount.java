package account.foreignCurrencyAccount;
import account.Account;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ForeignCurrencyAccount extends Account {

    //ctors

    public double calculateToAnotherCurrency(CurrencyManager.Currency newCurrency) {
        return getBalance() * CurrencyManager.getExchangeRateOf(newCurrency);
    }
}