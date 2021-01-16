package databases;

import person.Employee.Employee;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class EmployeesDatabase {
    private static EmployeesDatabase employeesDatabase = null;
    private final List<Employee> employees;

    public static EmployeesDatabase getInstance() {
        if(employeesDatabase == null)
            employeesDatabase = new EmployeesDatabase();
        return employeesDatabase;
    }

    private EmployeesDatabase() {
        employees = EmployeesFromFileReader.readEmployeesDataFromFile();
    }

    /**
     * probably this function have to be deleted, because it does not match encapsulation
     * why not just "getEmployee(Employee)" or "getEmployee(String ID)" ?
     * have to figure it out after implementing other components of system
     * //check CustomersDataBase also
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * @return amount of employees in database
     */
    public int getAmountOfEmployees() {
        return employees.size();
    }

    /**
     *
     * @param employee is a new employee sent with an intention in adding it to DB
     * @return boolean represents result of function:
     *     *true means employee is succesfully added
     *     *false means employee already exist in database
     */
    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }
}
