package databases;

import transaction.Transaction;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TransactionsFromFileReader {
    public static List<Transaction> readTransactionsFromFile() {
        List<Transaction> transactions = new LinkedList<>();
        Scanner in;
        try {
            in = new Scanner(Path.of(System.getProperty("user.dir"),"\\src\\main\\resources\\transactions.data"), StandardCharsets.UTF_8);
            in.useLocale(Locale.US);
            while(in.hasNext()) {
                Transaction transaction = readOneTransactionData(in);
                if(transaction != null)
                    transactions.add(transaction);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    private static Transaction readOneTransactionData(Scanner in) {
        Transaction transaction = new Transaction();
        try {
            transaction.setReceiverAccountNumber(in.next());
            transaction.setSenderAccountNumber(in.next());
            transaction.setTransferAmount(in.nextDouble());
            String sendingDate = in.next();
            LocalDate date = LocalDate.parse(sendingDate.substring(0, 10));
            LocalTime time = LocalTime.parse(sendingDate.substring(11));
            transaction.setSendingDate(date);
            transaction.setSendingTime(time);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return transaction;
    }
}
