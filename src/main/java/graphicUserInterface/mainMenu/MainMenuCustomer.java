package graphicUserInterface.mainMenu;

import hardwareSettings.WindowActions;

import javax.accessibility.AccessibleAction;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
    private JLabel balancyDisplay;
    private JComboBox chooseAccount;
    private JPanel balancePanel;

    public MainMenuCustomer() throws IOException {

        WindowActions.setUp(this);

        makeTransferButton.setFocusable(false);
        checkHistoryButton.setFocusable(false);
        askForALoanButton.setFocusable(false);
        createNewAccountButton.setFocusable(false);
        changeDataButton.setFocusable(false);
        createNewAccountButton.setFocusable(false);
        createPeriodicPaymentButton.setFocusable(false);

        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
