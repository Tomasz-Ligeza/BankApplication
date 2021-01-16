package graphicUserInterface.mainMenu.customerMainMenuOptions;

import hardwareSettings.WindowActions;
import person.Customer.Customer;
import transaction.Transactions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CheckHistoryFrame
        extends JFrame
        implements WindowActions {

    private JPanel panel;
    private JList historyList;
    private JButton backButton;
    private JButton details;
    private Customer copy;
    private Transactions customerTansactions;

    public CheckHistoryFrame(Customer customer) throws IOException {

        copy = customer;
        /*
        customerTransactions = copy.getAccounts().getTransactions(); or something like that
        and then
        historyList.add(customerTransactions);
         */

        WindowActions.setBankLogoFrame(this);

        details.setFocusable(false);
        details.addActionListener(
                e -> System.out.println("pokaz szczegoly transakcji")
        );

        backButton.setFocusable(false);
        backButton.addActionListener(
                e -> {
                    this.dispose();
                }
        );

        this.setSize(400,400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
