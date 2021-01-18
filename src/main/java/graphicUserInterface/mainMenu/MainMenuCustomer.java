package graphicUserInterface.mainMenu;

import account.Account;
import graphicUserInterface.mainMenu.customerMainMenuOptions.*;
import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class MainMenuCustomer
        extends JFrame
        implements WindowActions {

    private JLabel customerHello;
    private JPanel panel;
    private JButton makeTransferButton;
    private JButton checkHistoryButton;
    private JButton askForALoanButton;
    private JButton createNewAccountButton;
    private JButton changeDataButton;
    private JLabel balanceDisplay;
    private JComboBox<Account> chooseAccount;
    private JPanel balancePanel;

    public MainMenuCustomer(Customer loggedCustomer) throws IOException {

        WindowActions.setUp(this);
        WindowActions.addMenuBar(this);

        for(var acc : loggedCustomer.getAccounts()) {
            if(acc.getStatus())
                chooseAccount.addItem(acc);
        }

        customerHello.setText("HELLO " + loggedCustomer.getFirstName() + " " + loggedCustomer.getLastName());
        if(chooseAccount.getSelectedItem() != null)
            balanceDisplay.setText(String.format("%.2f", ((Account)chooseAccount.getSelectedItem()).getBalance()));
        else {
            balanceDisplay.setText("NO ACCOUNT!");
            makeTransferButton.setEnabled(false);
            askForALoanButton.setEnabled(false);
            checkHistoryButton.setEnabled(false);
        }
        makeTransferButton.setFocusable(false);
        makeTransferButton.addActionListener(
                e -> {
                    try {
                        if(chooseAccount.getSelectedItem() != null)
                            new MakeTransactionFrame(loggedCustomer);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        checkHistoryButton.setFocusable(false);
        checkHistoryButton.addActionListener(
                e -> {
                    try {
                        if(chooseAccount.getSelectedItem() != null)
                            new CheckHistoryFrame((Account)chooseAccount.getSelectedItem());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        askForALoanButton.setFocusable(false);
        askForALoanButton.addActionListener(
                e -> {
                    try {
                        if(chooseAccount.getSelectedItem() != null)
                            new AskForLoanFrame(loggedCustomer, (Account)chooseAccount.getSelectedItem());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        changeDataButton.setFocusable(false);
        changeDataButton.addActionListener(
                e -> {
                    try {
                        new ChangeDataFrame(loggedCustomer);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        createNewAccountButton.setFocusable(false);
        createNewAccountButton.addActionListener(
                e -> {
                    try {
                        new CreateNewAccountFrame(loggedCustomer);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        chooseAccount.setFocusable(false);
        chooseAccount.addActionListener(
                e -> {
                    if(chooseAccount.getSelectedItem() != null) {
                        balanceDisplay.setText(String.format("%.2f", ((Account) chooseAccount.getSelectedItem()).getBalance()));
                        makeTransferButton.setEnabled(true);
                        askForALoanButton.setEnabled(true);
                        checkHistoryButton.setEnabled(true);
                    }
                    else {
                        balanceDisplay.setText("NO ACCOUNT!");
                    }
                }
        );

        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
