package account.foreignCurrencyAccount;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManager {
    static private Map<Currency, Double> currencyValue;

    static {
        currencyValue = new HashMap<>();
        currencyValue.put(Currency.PLN, 1.d); //komentarzmikiego
        currencyValue.put(Currency.USD, 3.5);
        currencyValue.put(Currency.EUR, 4.50);
        currencyValue.put(Currency.GBP, 4.97);
    }

    public static Currency[] getCurrencies() {       //cos zle tutaj
        return currencyValue.keySet().toArray(new Currency[0]);
    }
    public static double getExchangeRateOf(Currency currency) {
        return currencyValue.get(currency);
    }

    public static Currency parseCurrency(String currencyInString){

        if(currencyInString.toUpperCase() == "EUR"){
            return Currency.EUR;
        }
        if(currencyInString.toUpperCase() == "USD"){
            return Currency.USD;
        }
        if(currencyInString.toUpperCase() == "PLN"){
            return Currency.PLN;
        }
        if(currencyInString.toUpperCase() == "GBP"){
            return Currency.GBP;
        }
        return null;
    }

    public enum Currency {
        PLN,
        USD,
        EUR,
        GBP,
    }

}
