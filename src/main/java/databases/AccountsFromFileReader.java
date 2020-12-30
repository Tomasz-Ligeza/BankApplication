package databases;

import account.Account;
import account.foreignCurrencyAccount.CurrencyManager;
import account.foreignCurrencyAccount.ForeignCurrencyAccount;
import account.savingsAccount.SavingsAccount;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

/*
        accounts.data   FILE FORMAT
        accountType(string: "ACC"/"FCA"/"SA")
        accountNumber(string)
        status(boolean) balance(double)
        <if account type is not ACC>
        targetBalance(double) / currency(string)
 */

public class AccountsFromFileReader {
    public static Map<String, List<Account>> readAccountsDataFromFile() {
        Map<String, List<Account>> accounts = new HashMap<String, List<Account>>();
        Scanner in;
        try {
            in = new Scanner(Path.of(System.getProperty("user.dir"),"\\src\\main\\resources\\accounts.data"), StandardCharsets.UTF_8);
            in.useLocale(Locale.US);
            while(in.hasNext()) {
                String accountType = in.next();
                Map.Entry<String, Account> accountInfo;
                switch(accountType) {
                    case "ACC":
                        accountInfo = readAccountData(in, new Account());
                        break;
                    case "FCA":
                        accountInfo = readForeignCurrencyAccountData(in);
                        break;
                    case "SA":
                        accountInfo = readSavingsAccountData(in);
                        break;
                    default:
                        accountInfo = null;
                        break;
                }
                if(accountInfo != null) {
                    if(accounts.containsKey(accountInfo.getKey()))
                        accounts.get(accountInfo.getKey()).add(accountInfo.getValue());
                    else
                        accounts.put(accountInfo.getKey(), new LinkedList<Account>(List.of(accountInfo.getValue())));
                }
                else
                    break;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    private static Map.Entry<String, Account> readAccountData(Scanner in, Account account) {
        String id;
        try {
            id = in.next();
            account.setAccountNumber(in.next());
            account.setStatus(in.nextBoolean());
            account.setBalance(in.nextDouble());
        }
        catch(Exception e) {
            return null;
        }
        return new AbstractMap.SimpleEntry<> (id, account);
    }

    private static Map.Entry<String, Account> readForeignCurrencyAccountData(Scanner in) {
        Map.Entry<String, Account> accountInfo = readAccountData(in, new ForeignCurrencyAccount());
        try {
            ((ForeignCurrencyAccount) accountInfo.getValue()).setCurrency(CurrencyManager.Currency.valueOf(in.next()));
        }
        catch(Exception e) {
            return null;
        }
        return accountInfo;
    }

    private static Map.Entry<String, Account> readSavingsAccountData(Scanner in) {
        Map.Entry<String, Account> accountInfo = readAccountData(in, new SavingsAccount());
        try {
            ((SavingsAccount) accountInfo.getValue()).setTargetBalance(in.nextDouble());
        }
        catch(Exception e) {
            return null;
        }
        return accountInfo;
    }
}
