package people;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import person.Customer.Customer;
import person.Employee.Employee;
import person.Person;

public class InstanceOfTest {
    private static Customer customer;
    private static Person person;
    private static Employee employee;

    @BeforeAll
    static void setUpClass(){
        customer = new Customer();
        employee = new Employee();
    }

    @Test
    void isCustomerInstanceOfPerson(){
        Assertions.assertTrue(customer instanceof Person);
    }

    @Test
    void isEmployeeInstanceOfPerson(){
        Assertions.assertTrue(employee instanceof Person);
    }

    @Test
    void isCustomerInstanceOfCustomer(){
        Assertions.assertTrue(customer instanceof Customer);
    }

    @Test
    void isEmployeeInstanceOfEmployee(){
        Assertions.assertTrue(customer instanceof Person);
    }
}
