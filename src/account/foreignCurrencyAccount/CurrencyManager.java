package account.foreignCurrencyAccount;

import java.util.Map;

public class CurrencyManager {
    static private Map<Currency, Double> currencyValue;

    static {
        currencyValue.put(Currency.PLN, 1.d);
        currencyValue.put(Currency.USD, 3.5);
        currencyValue.put(Currency.EUR, 4.20);
    }

    public static Currency[] getCurrencies() {
        return currencyValue.keySet().toArray(new Currency[0]);
    }

    public static double getExchangeRateOf(Currency currency) {
        return currencyValue.get(currency);
    }

    enum Currency {
        PLN,
        USD,
        EUR
    };
}
