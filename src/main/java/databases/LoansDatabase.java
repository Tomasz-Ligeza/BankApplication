package databases;

import person.Customer.Loan;

import java.util.LinkedList;
import java.util.List;

public class LoansDatabase {
    private static LoansDatabase loansDatabase;
    List<Loan> loans;

    public static LoansDatabase getInstance() {
        if(loansDatabase == null)
            loansDatabase = new LoansDatabase();
        return loansDatabase;
    }

    private LoansDatabase() {
        loans = LoansFromFileReader.readLoansDataFromFile();
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void remove(Loan loan) {
        loans.remove(loan);
    }
}
