package account.foreignCurrencyAccount;
import account.Account;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ForeignCurrencyAccount extends Account {
    CurrencyManager.Currency currency;
    //ctors



    /**
     *
     * @param newCurrency it is a parameter that defines a currency youwant to calculate to
     * @return double value of amount of money in newCurrency
     */
    public double calculateToAnotherCurrency(CurrencyManager.Currency newCurrency) {
        return getBalance() * (CurrencyManager.getExchangeRateOf(currency) / CurrencyManager.getExchangeRateOf(newCurrency));
    }

    public void setCurrency(CurrencyManager.Currency currency) {
        this.currency = currency;
    }
    public CurrencyManager.Currency getCurrency() {return this.currency; }
}