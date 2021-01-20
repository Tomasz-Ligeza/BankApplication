package account;

public class Account {
    protected String accountNumber;
    protected boolean status;
    protected double balance;

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

    /**
     * Function necessary to save and load accounts from file properly.
     * @return Type of account as a String.
     */
    public String typeOfAccount() { return "ACC"; }

    /**
     * If Account is a SavingsAccount - it means that we have to save/load double value of target.
     */
    public String additionalInfo() { return ""; }

    @Override
    public String toString() {
        return accountNumber + " (" + String.format("%.2f", balance) + ")";
    }
}
