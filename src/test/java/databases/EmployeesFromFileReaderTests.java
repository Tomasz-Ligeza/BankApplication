package databases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import person.Customer.Customer;
import person.Employee.Employee;

import java.util.HashSet;
import java.util.List;

public class EmployeesFromFileReaderTests {
    @Test
    public void readingFromFileTest() {
        List<Employee> employees = EmployeesFromFileReader.readEmployeesDataFromFile();
        Assertions.assertFalse(employees.isEmpty());
    }
}
