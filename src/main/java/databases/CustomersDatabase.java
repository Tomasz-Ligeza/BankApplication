package databases;

import person.Customer.Customer;
import person.Employee.Employee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Scanner;


public class CustomersDatabase {
    private static CustomersDatabase customersDatabase = null;
    private HashSet<Customer> customers;

    public static CustomersDatabase getInstance() {
        if(customersDatabase == null)
            customersDatabase = new CustomersDatabase();
        return customersDatabase;
    }

    private CustomersDatabase() {
        customers = CustomersFromFileReader.readCustomersDataFromFile();
    };

    /**
     * probably this function have to be deleted, because it does not match encapsulation
     * why not just "getCustomer(Customer)" or "getCustomer(String ID)" ?
     * have to figure it out after implementing other components of system
     * //check EmployeesDataBase also
     *
     * @return Iterable<Customer> from Hashset<Customer> customers
     */
    public Iterable<Customer> getEmployees() { return customers; }

    /**
     *
     * @param customer is a new customer sent with an intention in adding it to DB
     * @return boolean represents result of function:
     *     *true means customer is succesfully added
     *     *false means customer already exist in database
     */
    public boolean addCustomer(Customer customer) {
        return customers.add(customer);
    }
}
