package account.savingsAccount;

import account.Account;

public class SavingsAccount extends Account {
    private double targetBalance;

    //ctors

    public boolean getStatusOfTarget() { return targetBalance <= getBalance(); }
    public double getTargetBalance() { return targetBalance; }
    public void setTargetBalance(double targetBalance) { this.targetBalance = targetBalance; }

    @Override
    public String typeOfAccount() {
        return "SA";
    }

    @Override
    public String additionalInfo() {
        return targetBalance + "\n";
    }
}