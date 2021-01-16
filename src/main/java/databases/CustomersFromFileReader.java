package databases;

import account.Account;
import address.Address;
import person.Customer.Customer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

/*
    if we will change our mind about using databases instead of files, just
 */
public class CustomersFromFileReader {
    public static List<Customer> readCustomersDataFromFile() {
        List<Customer> customersSet = new LinkedList<Customer>();
        Scanner in;
        try {
            in = new Scanner(Path.of(System.getProperty("user.dir"),"\\src\\main\\resources\\customers.data"), StandardCharsets.UTF_8);
            while(in.hasNext()) {
                Customer customer = readOneCustomersData(in);
                if(customer != null)
                    customersSet.add(customer);
                else
                    break;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return customersSet;
    }


    private static Customer readOneCustomersData(Scanner in) {
        Customer customer = new Customer();
        try {
            customer.setLogin(in.next());
            customer.setPassword(in.next());
            customer.setsID(in.next());
            customer.setiPIN(in.nextInt());
            customer.setFirstName(in.next());
            customer.setLastName(in.next());
            customer.setsPESEL(in.next());

            //localData
            String s = in.next();
            LocalDate bornDate = LocalDate.parse(s);
            customer.setBornDate(bornDate);

            Address a = new Address(in.next(), in.next(), in.next(), in.next(), in.next());
            customer.setAddress(a);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return customer;
    }
}
