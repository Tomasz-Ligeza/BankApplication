package account.foreignCurrencyAccount;
import account.Account;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class ForeignCurrencyAccount extends Account {
    CurrencyManager.Currency currency;

    public void setCurrency(CurrencyManager.Currency currency) {
        this.currency = currency;
    }

    public CurrencyManager.Currency getCurrency() {return this.currency; }

    @Override
    public String typeOfAccount() {
        return "FCA";
    }

    @Override
    public String additionalInfo() {
        return getCurrency() + "\n";
    }
}