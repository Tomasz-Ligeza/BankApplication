package graphicUserInterface.mainMenu;

import graphicUserInterface.mainMenu.customerMainMenuOptions.*;
import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.swing.*;
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
    private JButton createPeriodicPaymentButton;
    private JLabel balanceDisplay;
    private JComboBox chooseAccount;
    private JPanel balancePanel;

    private final Customer loggedCustomerCopy;

    public MainMenuCustomer(Customer loggedCustomer) throws IOException {

        WindowActions.setUp(this);
        WindowActions.addMenuBar(this);

        loggedCustomerCopy = loggedCustomer;

        customerHello.setText("HELLO " + loggedCustomer.getFirstName() + " " + loggedCustomer.getLastName());
        balanceDisplay.setText("BALANCE");

        makeTransferButton.setFocusable(false);
        makeTransferButton.addActionListener(
                e -> {
                    try {
                        new MakeTransactionFrame(loggedCustomerCopy);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        checkHistoryButton.setFocusable(false);
        checkHistoryButton.addActionListener(
                e -> {
                    try {
                        new CheckHistoryFrame(loggedCustomerCopy);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        askForALoanButton.setFocusable(false);
        askForALoanButton.addActionListener(
                e -> {
                    try {
                        new AskForLoanFrame(loggedCustomerCopy);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        changeDataButton.setFocusable(false);
        changeDataButton.addActionListener(
                e -> {
                    try {
                        new ChangeDataFrame(loggedCustomerCopy);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        createNewAccountButton.setFocusable(false);
        createNewAccountButton.addActionListener(
                e -> {
                    try {
                        new CreateNewAccountFrame(loggedCustomerCopy);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        createPeriodicPaymentButton.setFocusable(false);
        createPeriodicPaymentButton.addActionListener(
                e -> {
                    try {
                        new CreatePeriodPaymentFrame(loggedCustomerCopy);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
        );

        chooseAccount.setFocusable(false);
        chooseAccount.addActionListener(
                e -> System.out.println("impelemt")
        );

        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
