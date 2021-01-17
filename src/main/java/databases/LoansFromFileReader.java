package databases;

import person.Customer.Loan;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LoansFromFileReader {
    public static List<Loan> readLoansDataFromFile() {
        List<Loan> loans = new LinkedList<>();
        Scanner in;
        try {
            in = new Scanner(Path.of(System.getProperty("user.dir"),"\\src\\main\\resources\\loans.data"), StandardCharsets.UTF_8);
            in.useLocale(Locale.US);
            while(in.hasNext()) {
                Loan loan = readOneLoanData(in);
                if(loan != null) {
                    loans.add(loan);
                }
                else
                    break;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }

    private static Loan readOneLoanData(Scanner in) {
        Loan loan = new Loan();
        try
        {
            loan.setAccountNumber(in.next());
            loan.setAmount(in.nextDouble());
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return loan;
    }
}
