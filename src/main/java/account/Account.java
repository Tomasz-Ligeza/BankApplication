package account;

public class Account {
    protected String accountNumber;
    protected boolean status;
    protected double balance;

    //ctors


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getStatus() { return status; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public String typeOfAccount() { return "ACC"; }
    public String additionalInfo() { return ""; }

    @Override
    public String toString() {
        return accountNumber + " (" + String.format("%.2f", balance) + ")";
    }
}
