package databases;

import account.Account;
import transaction.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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


    /**
     * Function that takes care about making transactions.
     * It adds amount of balance to receiver account if it exists.
     * and subtracts it from senders account.
     * @param transaction
     */
    public void makeTransaction(Transaction transaction) {
        List<Account> accounts = new LinkedList<>();
        CustomersDatabase.getInstance().getCustomers()
                .forEach(customer -> accounts.addAll(customer.getAccounts()));
        Optional<Account> receiverAccountOptional = accounts.stream().filter(account -> account.getAccountNumber().equals(transaction.getReceiverAccountNumber())).findFirst();
        Optional<Account> senderAccountOptional = accounts.stream().filter(account -> account.getAccountNumber().equals(transaction.getSenderAccountNumber())).findFirst();

        if(senderAccountOptional.isPresent()) {
            Account sender = senderAccountOptional.get();
            sender.setBalance(sender.getBalance() - transaction.getTransferAmount());
        }

        if(receiverAccountOptional.isPresent()) {
            Account receiver = receiverAccountOptional.get();
            receiver.setBalance(receiver.getBalance() + transaction.getTransferAmount());
        }
        this.transactions.add(transaction);
    }
}
