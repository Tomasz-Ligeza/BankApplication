package databases;

import address.Address;
import person.Employee.Employee;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeesFromFileReader {
    public static HashSet<Employee> readCustomersDataFromFile() {
        HashSet<Employee> customersSet = new HashSet<Employee>();
        Scanner in;
        try {
            in = new Scanner(Path.of("../../customers.data"), StandardCharsets.UTF_8);
            while(in.hasNext()) {
                Employee employee = readOneEmployeeData(in);
                if(employee != null)
                    customersSet.add(employee);
                else
                    break;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return customersSet;
    }


    private static Employee readOneEmployeeData(Scanner in) {
        Employee employee = new Employee();
        try {
            employee.setsID(in.next());
            employee.setPassword(in.next());
            employee.setFirstName(in.next());
            employee.setLastName(in.next());
            employee.setsPESEL(in.next());

            //localData
            String s = in.next();
            LocalDate bornDate = LocalDate.of(Integer.getInteger(s.substring(0, 3)), Integer.getInteger(s.substring(5, 6)), Integer.getInteger(s.substring(8, 9)));
            employee.setBornDate(bornDate);

            Address a = new Address(in.next(), in.next(), in.next(), in.next(), in.next());
            employee.setAddress(a);
        }
        catch(Exception e) {
            return null;
        }
        return employee;
    }
}
