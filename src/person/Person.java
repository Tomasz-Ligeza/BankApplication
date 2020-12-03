package person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import address.Address;
import auto.calculators.AgeCalculator;

import static auto.calculators.AgeCalculator.calculateAge;

/**
 * pola protected sa widzialne w calym pakaiecie
 * jest to jednak jedyne rozwiazanie zeby byly widoczne w podklasach i
 * a nie byly widziane globalnie
 * modyfiator private ogranicza widzialnosc pol jedynie do tej klasy
 */

public abstract class Person {
    private String firstName;
    private String lastName;
    private String sPESEL;

    private int age;
    private LocalDate bornDate;
    private Address address;

    public Person(){
        //default
    }

    public Person(String firstName, String lastName, String sPESEL, LocalDate bornDate, Address address) {
        setAddress(address);
        setBornDate(bornDate);
        setAge(this.bornDate);
        setsPESEL(sPESEL);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getsPESEL() {
        return sPESEL;
    }

    public void setsPESEL(String sPESEL) {
        this.sPESEL = sPESEL;
    }

    public int getAge() {
        return age;
    }

    public void setAge(LocalDate bornDate) {
        int age = calculateAge(bornDate);
        this.age = age;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
