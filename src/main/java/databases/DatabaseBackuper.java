package databases;


import address.Address;
import person.Customer.Customer;
import person.Employee.Employee;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * Class that takes care of saving data after closing application.
 *
 */
public class DatabaseBackuper {
    private static DatabaseBackuper databaseBackuper;
    private static CustomersDatabase customersDatabase;
    private static EmployeesDatabase employeesDatabase;

    public static DatabaseBackuper getInstance() {
        if(databaseBackuper == null) {
            databaseBackuper = new DatabaseBackuper();
        }
        return databaseBackuper;

    }

    public void saveApplicationData() {
        saveCustomersData();
        saveEmployeesData();
    }

    /**
     *
     * In constructor we assign already initialized (or not) objects of classes Customers&EmployeesDatabases
     * so every time we use it in our program it has reference to existing data in program.
     *
     */
    private DatabaseBackuper() {
        customersDatabase = CustomersDatabase.getInstance();
        employeesDatabase = EmployeesDatabase.getInstance();
    }

    private void saveCustomersData() {
        File file;
        try {
            file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\customersBackup.data");
            FileWriter fileWriter = new FileWriter(file, false);
            customersDatabase.getCustomers().stream().forEach(customer -> saveOneCustomerData(customer, fileWriter));
            fileWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void saveEmployeesData() {
        File file;
        try {
            file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\employeesBackup.data");
            FileWriter fileWriter = new FileWriter(file, false);
            employeesDatabase.getEmployees().stream().forEach(employee -> saveOneEmployeeData(employee, fileWriter));
            fileWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void saveOneCustomerData(Customer customer, Writer file) {
        try {
            file.write(customer.getLogin() + "\t");
            file.write(customer.getPassword() + "\t");
            file.write(customer.getsID() + "\t");
            file.write(customer.getiPIN() + "\n");
            file.write(customer.getFirstName() + "\t");
            file.write(customer.getLastName() + "\t");
            file.write(customer.getsPESEL() + "\t");
            LocalDate bornDate = customer.getBornDate();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            file.write( formatter.format(bornDate) + "\n");
            Address address = customer.getAddress();
            file.write(address.getCountry() + "\t");
            file.write(address.getCity() + "\n");
            file.write(address.getStreet() + "\t");
            file.write(address.getHouseNr() + "\n");
            file.write(address.getPostalCode() + "\n");
            file.write("\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveOneEmployeeData(Employee employee, Writer writer) {

    }

}
