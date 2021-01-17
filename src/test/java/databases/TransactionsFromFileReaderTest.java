package databases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import transaction.Transaction;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsFromFileReaderTest {

    @Test
    void readTransactionsFromFile() {
        List<Transaction> transactions = TransactionsFromFileReader.readTransactionsFromFile();
        Assertions.assertTrue(transactions.size() > 0);
    }
}