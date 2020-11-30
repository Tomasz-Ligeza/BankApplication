package person.Employee;

import person.Person;

public class Employee extends Person {
    private String sID;
    private String password;

    public Employee() {
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
