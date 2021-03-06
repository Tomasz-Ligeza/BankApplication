package person.Customer;

public class Loan {
    private double amount;
    private String accountNumber;

    public Loan() {}

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return accountNumber + " asked for " + amount;
    }
}
