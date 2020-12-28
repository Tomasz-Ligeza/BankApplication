package databases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import person.Customer.Customer;

import java.util.HashSet;

public class CustomersFromFileReaderTests {
    @Test
    public void readingFromFileTest() {
        HashSet<Customer> customers = CustomersFromFileReader.readCustomersDataFromFile();
        Assertions.assertFalse(customers.isEmpty());
    }
}
