package account;

public class Account {
    private String accountNumber;
    private boolean status;
    private double balance;

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
}
