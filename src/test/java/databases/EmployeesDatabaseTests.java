package databases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import person.Employee.Employee;

public class EmployeesDatabaseTests {
    @Test
    public void addingToCustomerDataBaseTest() {
        EmployeesDatabase db = EmployeesDatabase.getInstance();
        int previousSize = db.getEmployees().size();
        db.addEmployee(new Employee());
        Assertions.assertEquals(previousSize + 1, db.getEmployees().size());
    }
}
