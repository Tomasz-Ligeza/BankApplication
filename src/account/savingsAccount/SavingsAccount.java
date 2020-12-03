package account.savingsAccount;

import account.Account;

public class SavingsAccount extends Account {
    private double targetBalance;

    //ctors

    boolean getStatusOfTarget() { return targetBalance <= getBalance(); }
    void setTargetBalance(double targetBalance) { this.targetBalance = targetBalance; }
}