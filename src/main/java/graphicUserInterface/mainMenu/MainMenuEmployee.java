package graphicUserInterface.mainMenu;

import account.Account;
import databases.CustomersDatabase;
import databases.LoansDatabase;
import databases.TransactionsDatabase;
import hardwareSettings.WindowActions;
import person.Customer.Loan;
import person.Employee.Employee;
import transaction.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MainMenuEmployee
        extends JFrame
        implements ActionListener,
        WindowActions {

    private JFormattedTextField accountToBlockNumberTextField;
    private JPanel panel;
    private JButton blockButton;
    private JList loanRequestList;
    private DefaultListModel<Loan> loansModel;
    private JList accountRequestList;
    private DefaultListModel<Account> accountsModel;
    private JButton acceptAccountButton;
    private JButton acceptLoanButton;
    private JPanel panelPicture;
    private JLabel pictureLabel;
    private JLabel employeeHello;

    public MainMenuEmployee(Employee loggedEmployee) throws IOException {
        WindowActions.setUp(this);
        WindowActions.addMenuBar(this);


        accountsModel = new DefaultListModel<>();
        CustomersDatabase.getInstance().getCustomers()
                .forEach(customer -> customer.getAccounts()
                                            .stream()
                                            .filter(account -> !account.getStatus())
                                            .forEach(account -> accountsModel.addElement(account)));
        accountRequestList.setModel(accountsModel);

        loansModel = new DefaultListModel<>();
        loansModel.addAll(LoansDatabase.getInstance().getLoans());
        loanRequestList.setModel(loansModel);

        employeeHello.setText("HELLO " + loggedEmployee.getFirstName() + " " + loggedEmployee.getsID());

        blockButton.setFocusable(false);
        blockButton.addActionListener(this);

        acceptAccountButton.setFocusable(false);
        acceptAccountButton.addActionListener(this);
        acceptLoanButton.setFocusable(false);
        acceptLoanButton.addActionListener(this);


        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == acceptAccountButton) {
            if(!accountRequestList.isSelectionEmpty()) {
                accountsModel.getElementAt(accountRequestList.getSelectedIndex()).setStatus(true);
                accountsModel.remove(accountRequestList.getSelectedIndex());
            }
        }

        if(e.getSource() == acceptLoanButton) {
            if(!loanRequestList.isSelectionEmpty()) {
                Loan loan = loansModel.getElementAt(loanRequestList.getSelectedIndex());
                String accountNumber = loan.getAccountNumber();

                List<Account> accounts = new LinkedList<>();
                CustomersDatabase.getInstance().getCustomers().forEach(customer -> accounts.addAll(customer.getAccounts()));
                Optional<Account> accountOptional = accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber)).findFirst();

                if(accountOptional.isPresent()) {
                    Transaction transaction = new Transaction();
                    transaction.setSenderAccountNumber("BANKPKOBP_NUMBER");
                    transaction.setReceiverAccountNumber(accountOptional.get().getAccountNumber());
                    transaction.setTransferAmount(loan.getAmount());
                    transaction.setSendingDate(LocalDate.now());
                    transaction.setSendingTime(LocalTime.now());
                    TransactionsDatabase.getInstance().makeTransaction(transaction);

                    JOptionPane.showMessageDialog(this, "LOAN GRANTED!", "Loan", JOptionPane.INFORMATION_MESSAGE);
                    loansModel.remove(loanRequestList.getSelectedIndex());
                    LoansDatabase.getInstance().remove(loan);
                }
            }
        }

        if(e.getSource() == blockButton) {
            if(!accountToBlockNumberTextField.getText().isEmpty()) {
                String accountNumber = accountToBlockNumberTextField.getText();
                List<Account> accounts = new LinkedList<>();
                CustomersDatabase.getInstance().getCustomers().forEach(customer -> accounts.addAll(customer.getAccounts()));
                Optional<Account> accountOptional = accounts.stream().filter(account -> account.getAccountNumber().equals(accountNumber) &&
                                                                                        account.getStatus()).findFirst();
                if(accountOptional.isPresent()) {
                    accountOptional.get().setStatus(false);
                    accountsModel.addElement(accountOptional.get());
                    JOptionPane.showMessageDialog(this, "ACCOUNT DISABLED!", "Disabled!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
