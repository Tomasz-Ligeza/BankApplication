package databases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import person.Customer.Customer;

public class CustomersDatabaseTests {
    @Test
    public void addingToCustomerDataBaseTest() {
        CustomersDatabase db = CustomersDatabase.getInstance();
        int previousSize = db.getEmployees().size();
        db.addCustomer(new Customer());
        Assertions.assertEquals(previousSize + 1, db.getEmployees().size());
    }
}
