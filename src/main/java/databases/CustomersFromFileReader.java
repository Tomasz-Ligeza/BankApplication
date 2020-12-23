package databases;

import address.Address;
import person.Customer.Customer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

/*
    if we will change our mind about using databases instead of files, just
 */
public class CustomersFromFileReader {
    public static HashSet<Customer> readCustomersDataFromFile() {
        HashSet<Customer> customersSet = new HashSet<Customer>();
        Scanner in;
        try {
            in = new Scanner(Path.of("../../customers.data"), StandardCharsets.UTF_8);
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
            LocalDate bornDate = LocalDate.of(Integer.getInteger(s.substring(0, 3)), Integer.getInteger(s.substring(5, 6)), Integer.getInteger(s.substring(8, 9)));
            customer.setBornDate(bornDate);

            Address a = new Address(in.next(), in.next(), in.next(), in.next(), in.next());
            customer.setAddress(a);
        }
        catch(Exception e) {
            return null;
        }
        return customer;
    }
}
