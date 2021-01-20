package account.foreignCurrencyAccount;

import java.util.HashMap;
import java.util.Map;


/**
 * CurrencyManager is a class that provides currencies and their values.
 * In ForeignCurrencyAccount class we keep an enum of Currency.
 */
public class CurrencyManager {
    static private Map<Currency, Double> currencyValue;

    /**
     * adding currencyValues
     */
    static {
        currencyValue = new HashMap<>();
        currencyValue.put(Currency.PLN, 1.d); //komentarzmikiego
        currencyValue.put(Currency.USD, 3.5);
        currencyValue.put(Currency.EUR, 4.50);
        currencyValue.put(Currency.GBP, 4.97);
    }

    /**
     * Function used to get all possible enum values as Array.
     * @return currency values.
     */
    public static Currency[] getCurrencies() {
        return currencyValue.keySet().toArray(new Currency[0]);
    }

    /**
     * Function that maps CurrencyManager.Currency to double value of that currency.
     * @param currency is a currency of which u want to take value.
     * @return value of a currency.
     */
    public static double getExchangeRateOf(Currency currency) {
        return currencyValue.get(currency);
    }

    /**
     *
     * @param currencyInString
     * @return Currency that was sent here in enum or null if sent String was wrong.
     */
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
