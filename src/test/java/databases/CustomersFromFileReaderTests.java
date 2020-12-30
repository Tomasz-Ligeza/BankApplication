package databases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import person.Customer.Customer;

import java.util.List;

public class CustomersFromFileReaderTests {
    @Test
    public void readingFromFileTest() {
        List<Customer> customers = CustomersFromFileReader.readCustomersDataFromFile();
        Assertions.assertFalse(customers.isEmpty());
    }
}
