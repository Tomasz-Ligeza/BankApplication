package person;

import databases.CustomersDatabase;
import databases.EmployeesDatabase;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class IDGenerator {
    private static String characters;
    private static String lastCustomerID;
    private static String lastEmployeeID;
    private static IDGenerator idGenerator;

    /**
     * Costructor finds last ids for both coustomers and employees.
     * And then it is able to provide .next'People'ID() functionality
     */
    public IDGenerator() {
        characters = "0123456789abcdefghijklmnopqrstuvwxyz";
        CustomersDatabase customersDatabase = CustomersDatabase.getInstance();
        List<String> IDs = new LinkedList<>();
        findLastCustomerID(customersDatabase.getCustomers().stream().map(customer -> customer.getsID()).collect(Collectors.toList()));
        EmployeesDatabase employeesDatabase = EmployeesDatabase.getInstance();
        findLastEmployeeID(employeesDatabase.getEmployees().stream().map(employee -> employee.getsID()).collect(Collectors.toList()));
    }

    public static IDGenerator getInstance() {
        if(idGenerator == null) {
            idGenerator = new IDGenerator();
        }
        return idGenerator;
    }

    public String getLastCustomerID() {
        return lastCustomerID;
    }

    public String getLastEmployeeID() {
        return lastEmployeeID;
    }

    private void findLastCustomerID(List<String> IDs) {
        var optID = IDs.stream().max(String::compareTo);
        optID.ifPresent(s -> lastCustomerID = s);
    }

    private void findLastEmployeeID(List<String> IDs) {
        var optID = IDs.stream().max(String::compareTo);
        optID.ifPresent(s -> lastEmployeeID = s);
    }

    public String generateCustomerID() {
        StringBuilder generated = new StringBuilder(lastCustomerID);
        boolean over = true;
        int pos = lastCustomerID.length() - 1;
        do {
            if (characters.indexOf(generated.charAt(pos)) + 1 >= characters.length()) {
                generated.setCharAt(pos, '0');
                over = true;
                pos--;
            } else {
                generated.setCharAt(pos, characters.charAt(characters.indexOf(generated.charAt(pos)) + 1));
                over = false;
            }
        } while(over && pos >= 0);
        return lastCustomerID = generated.toString();
    }

    public String generateEmployeeID() {
        StringBuilder generated = new StringBuilder(lastEmployeeID);
        int over = 0;
        int pos = 0;
        do {
            if(generated.charAt(pos) + 1 > characters.length()) {
                generated.setCharAt(pos, '0');
                over = 1;
                pos++;
            }
        } while(over > 0);
        return lastEmployeeID = generated.toString();
    }
}
