package person;

import java.util.Date;
import address.Address;

/**
 * pola protected sa widzialne w calym pakaiecie
 * jest to jednak jedyne rozwiazanie zeby byly widoczne w podklasach i
 * a nie byly widziane globalnie
 * modyfiator private ogranicza widzialnosc pol jedynie do tej klasy
 */

public abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String sPESEL;

    protected int age;
    protected Date bornDate;
    protected Address address;

    protected Person() {
    }

    protected String getFirstName() {
        return firstName;
    }

    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected String getsPESEL() {
        return sPESEL;
    }

    protected void setsPESEL(String sPESEL) {
        this.sPESEL = sPESEL;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected Date getBornDate() {
        return bornDate;
    }

    protected void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    protected Address getAddress() {
        return address;
    }

    protected void setAddress(Address address) {
        this.address = address;
    }
}
