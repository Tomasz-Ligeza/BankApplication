package person.Employee;

import address.Address;
import auto.Generator;
import person.Person;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Employee extends Person implements Generator {
    private final String sID;
    private String password;

    public Employee(String sID) {
        //default
        this.sID = setsID();
    }

    public Employee(String firstName, String lastName, String sPESEL, LocalDate bornDate, Address address){
        super(firstName, lastName, sPESEL, bornDate, address);
        this.sID = setsID();
        setPassword();
    }
    public String getsID() {
        return sID;
    }

    public String setsID() {
        String uniqueID = setId();
        return uniqueID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = setPass();
    }
    public void setPassword(String newPass){
        this.password = newPass;
    }

    @Override
    public String toString() {
        return "Employee{" +
                //"sID='" + sID + '\'' +
                "Name='" + getFirstName() + '\'' +
                "Surname='" + getLastName() + '\'' +
                //", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(sID, employee.sID) &&
                Objects.equals(password, employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sID, password);
    }
}
