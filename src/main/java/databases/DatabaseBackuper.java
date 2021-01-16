package databases;


import account.Account;
import address.Address;
import person.Customer.Customer;
import person.Employee.Employee;
import transaction.Transaction;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private static TransactionsDatabase transactionsDatabase;

    public static DatabaseBackuper getInstance() {
        if(databaseBackuper == null) {
            databaseBackuper = new DatabaseBackuper();
        }
        return databaseBackuper;

    }

    public void saveApplicationData() {
        saveCustomersData();
        saveEmployeesData();
        saveTransactionsData();
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
        transactionsDatabase = TransactionsDatabase.getInstance();
    }

    private void saveCustomersData() {
        File customersFile;
        File accountsFile;
        try {
            customersFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\customers.data");
            FileWriter customersFileWriter = new FileWriter(customersFile, false);
            accountsFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\accounts.data");
            FileWriter accountsFileWriter = new FileWriter(accountsFile, false);
            customersDatabase.getCustomers().forEach(customer -> {
                saveOneCustomerData(customer, customersFileWriter);
                customer.getAccounts().forEach(account -> saveOneAccountData(account, customer.getsID(), accountsFileWriter));
            });
            customersFileWriter.close();
            accountsFileWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void saveEmployeesData() {
        File file;
        try {
            file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\employees.data");
            FileWriter fileWriter = new FileWriter(file, false);
            employeesDatabase.getEmployees().forEach(employee -> saveOneEmployeeData(employee, fileWriter));
            fileWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    private void saveTransactionsData() {
        File file;
        try {
            file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\transactions.data");
            FileWriter fileWriter = new FileWriter(file, false);
            transactionsDatabase.getTransactions().forEach(transaction -> saveOneTransactionData(transaction, fileWriter));
            fileWriter.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /*
    login	password	sID	9999
    firstName	lastName	sPESEL	2000-04-27
    country	city
    street	houseNr
    postalCode
     */

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

    /*
    ACC
    sID
    accountNumber
    true	7.2

    SA
    sID
    accountNumber
    true	2.0
    3.0

    FCA
    sID
    accountNumber
    true	3.0
    EUR
     */

    private void saveOneAccountData(Account account, String sID, Writer file) {
        try {
            file.write(account.typeOfAccount() + "\n");
            file.write(sID + "\n");
            file.write(account.getAccountNumber() + "\n");
            file.write((account.getStatus() ? "true" : "false") + "\t");
            file.write(account.getBalance() + "\n");
            file.write(account.additionalInfo() + "\n");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    sID	password
    firstName	lastName	sPESEL	2000.04.27
    country	city
    street	houseNr
    postalCode
     */
    private void saveOneEmployeeData(Employee employee, Writer file) {
        try {
            file.write(employee.getsID() + "\t");
            file.write(employee.getPassword() + "\n");
            file.write(employee.getFirstName() + "\t");
            file.write(employee.getLastName() + "\t");
            file.write(employee.getsPESEL() + "\t");
            LocalDate bornDate = employee.getBornDate();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            file.write( formatter.format(bornDate) + "\n");
            Address address = employee.getAddress();
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

    private void saveOneTransactionData(Transaction transaction, Writer file) {
        try {
            file.write(transaction.getReceiverAccountNumber() + "\n");
            file.write(transaction.getSenderAccountNumber() + "\n");
            file.write(transaction.getTransferAmount() + "\n");
            LocalDate sendingDate = transaction.getSendingDate();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            file.write(formatter.format(sendingDate) + ";");
            formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime sendingTime = transaction.getSendingTime();
            file.write(formatter.format(sendingTime) + "\n\n");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
