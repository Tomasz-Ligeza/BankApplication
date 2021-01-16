package databases;

import transaction.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionsDatabase {
    private static TransactionsDatabase transactionsDatabase;
    private List<Transaction> transactions;

    public static TransactionsDatabase getInstance() {
        if(transactionsDatabase == null)
            transactionsDatabase = new TransactionsDatabase();
        return transactionsDatabase;
    }

    private TransactionsDatabase() {
        transactions = TransactionsFromFileReader.readTransactionsFromFile();
    }

    public List<Transaction> getTransactions() { return transactions; }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

}
