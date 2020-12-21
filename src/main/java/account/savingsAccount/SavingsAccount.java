package account.savingsAccount;

import account.Account;

public class SavingsAccount extends Account {
    private double targetBalance;

    //ctors

    public boolean getStatusOfTarget() { return targetBalance <= getBalance(); }
    public void setTargetBalance(double targetBalance) { this.targetBalance = targetBalance; }
}