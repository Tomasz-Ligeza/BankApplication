package databases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import person.Customer.Customer;
import person.Employee.Employee;

import java.util.HashSet;

public class EmployeesFromFileReaderTests {
    @Test
    public void readingFromFileTest() {
        HashSet<Employee> employees = EmployeesFromFileReader.readEmployeesDataFromFile();
        Assertions.assertFalse(employees.isEmpty());
    }
}
