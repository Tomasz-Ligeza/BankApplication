package person.Customer;

import address.Address;
import auto.Generator;
import person.Person;

import java.security.SecureRandom; //where do we use this
import java.time.LocalDate;
import java.util.Objects; //where do we use this

public class Customer extends Person implements Generator {
    private String login;
    private String password;    //poczatkowe haslo jest generowane automatycznie, mozna zmienic w zmienDane();
    private final String sID;
    private int iPIN;

    public Customer(){
        //default
        this.sID = setsID();
    }
    public Customer(String firstName, String lastName, String sPESEL, int age, LocalDate bornDate, Address address, String login, int pin ) {
        super(firstName, lastName, sPESEL, bornDate, address);
        this.sID = setsID();
        setLogin(login);
        setPassword();
        setiPIN(pin);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword() {
        this.password = setPass();
    }

    public void setPassword(String newPassw){
        this.password = newPassw;
    }

    public String getsID() {
        return sID;
    }

    private String setsID() {
        String uniqueID = setId();
        return uniqueID;
    }

    public int getiPIN() {
        return iPIN;
    }

    public void setiPIN(int iPIN) {
        this.iPIN = iPIN;
    }

    @Override
    public String toString() {
        return "Customer{" +
                //"login='" + login + '\'' +
                //", password='" + password + '\'' +
                "Name='" + getFirstName() + '\'' +
                "Surname='" + getLastName() + '\'' +
                //", sID='" + sID + '\'' +
                //", iPIN=" + iPIN +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return iPIN == customer.iPIN &&
                Objects.equals(login, customer.login) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(sID, customer.sID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, sID, iPIN);
    }
}
