package transaction;

import java.util.LinkedList;

public class Transactions {
    private final LinkedList<Transaction> transactions = new LinkedList<>();
    private final LinkedList<PeriodTransaction> periodTransactions = new LinkedList<PeriodTransaction>();

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) { transactions.add(transaction); }
    public void addPeriodTransaction(PeriodTransaction periodTransaction) { periodTransactions.add(periodTransaction); }

    public LinkedList<PeriodTransaction> getPeriodTransactions() {
        return periodTransactions;
    }
}
