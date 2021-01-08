package graphicUserInterface.mainMenu;

import account.Account;
import graphicUserInterface.mainMenu.customerMainMenuOptions.*;
import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.accessibility.AccessibleAction;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class MainMenuCustomer
        extends JFrame
        implements ActionListener,
        WindowActions {

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

    public MainMenuCustomer(Customer loggedCustomer) throws IOException {

        WindowActions.setUp(this);
        WindowActions.addMenuBar(this);

        chooseAccount.addItem("");

        customerHello.setText("HELLO " + loggedCustomer.getFirstName() + " " + loggedCustomer.getLastName());
        balanceDisplay.setText("BALANCE");

        makeTransferButton.setFocusable(false);
        checkHistoryButton.setFocusable(false);
        askForALoanButton.setFocusable(false);
        createNewAccountButton.setFocusable(false);
        changeDataButton.setFocusable(false);
        createNewAccountButton.setFocusable(false);
        createPeriodicPaymentButton.setFocusable(false);
        chooseAccount.setFocusable(false);
        makeTransferButton.addActionListener(this);
        checkHistoryButton.addActionListener(this);
        askForALoanButton.addActionListener(this);
        createNewAccountButton.addActionListener(this);
        changeDataButton.addActionListener(this);
        createNewAccountButton.addActionListener(this);
        createPeriodicPaymentButton.addActionListener(this);
        chooseAccount.addActionListener(this);

        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == changeDataButton){
            try {
                new ChangeDataFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //changeDataButton.setEnabled(false);
        }else if(e.getSource() == makeTransferButton){
            try {
                new MakeTransferFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //makeTransferButton.setEnabled(false);
        }else if(e.getSource() == checkHistoryButton){
            try {
                new CheckHistoryFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //checkHistoryButton.setEnabled(false);
        }else if(e.getSource() == askForALoanButton){
            try {
                new AskForLoanFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //askForALoanButton.setEnabled(false);
        }else if(e.getSource() == createNewAccountButton) {
            try {
                new CreateNewAccountFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //createNewAccountButton.setEnabled(false);
        } else if(e.getSource() == createPeriodicPaymentButton){
            try {
                new CreatePeriodPaymentFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //createPeriodicPaymentButton.setEnabled(false);
        }
    }
}
