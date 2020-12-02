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
    private String firstName;
    private String lastName;
    private String sPESEL;

    private int age;
    private Date bornDate;
    private Address address;

    public Person(){
        //default
    }
    //TODO: nalezy zaimlemetwac liczneie wieku na podstawie daty urodzin

    /**
     *
     * @param firstName
     * @param lastName
     * @param sPESEL
     * @param age - nie mozna przesylac wieku w parametrze
     *            moze dojsc do oszustw i wiek != wiek(wg daty urodzin)
     * @param bornDate
     * @param address
     */
    public Person(String firstName, String lastName, String sPESEL, int age, Date bornDate, Address address) {
        setAddress(address);
        setAge(age);
        setBornDate(bornDate);
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