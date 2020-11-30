package person;

import java.util.Date;
import address.Address;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String sPESEL;

    private int age;
    private Date bornDate;
    private Address address;

    public Person() {
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

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
