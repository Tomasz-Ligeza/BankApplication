package person.Customer;

import person.Person;

import java.util.Objects;

public class Customer extends Person {
    private String login;
    private String password;
    private String sID;
    private int iPIN;

    public Customer() {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
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
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", sID='" + sID + '\'' +
                ", iPIN=" + iPIN +
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
