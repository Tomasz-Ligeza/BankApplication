package graphicUserInterface.mainMenu.customerMainMenuOptions;

import account.Account;
import account.foreignCurrencyAccount.CurrencyManager;
import auto.calculators.InterestCalculator;
import databases.LoansDatabase;
import hardwareSettings.WindowActions;
import person.Customer.Customer;
import person.Customer.Loan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Currency;

public class AskForLoanFrame
    extends JFrame
    implements ActionListener, WindowActions {

    private JPanel panel;
    private JFormattedTextField amountOfLoan;
    private JComboBox months;
    private JComboBox years;
    private JButton ASKButton;
    private double amount;
    private int duration;
    private double EMI;

    public AskForLoanFrame(Customer customer, Account account) throws IOException {
        WindowActions.setBankLogoFrame(this);

        for(int i = 1; i <= 12; i++)
            months.addItem(i);
        for(int i = 1; i <= 10; i++)
            years.addItem(i);

        ASKButton.setFocusable(false);
        ASKButton.addActionListener(
                e -> {
                    String amountString = amountOfLoan.toString().replace(",", ".");
                    amount = Double.parseDouble(amountOfLoan.getText());
                    duration = (int)months.getSelectedItem() + (int)years.getSelectedItem()*12;
                    try {
                        EMI = InterestCalculator.calculateInterestOfLoan(amount, duration);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    String userInput;
                    userInput = JOptionPane.showInputDialog(this, "EMI = " + EMI +
                            "\nEnter your PIN", "Confirm with PIN", JOptionPane.QUESTION_MESSAGE);
                    if(Integer.valueOf(userInput) == customer.getiPIN()) {
                        Loan loan = new Loan();
                        loan.setAccountNumber(account.getAccountNumber());
                        loan.setAmount(amount);
                        LoansDatabase.getInstance().addLoan(loan);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "WRONG DATA", "Wrong data", JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        this.setSize(400,400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
