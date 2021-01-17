package graphicUserInterface.mainMenu.customerMainMenuOptions;

import account.Account;
import databases.TransactionsDatabase;
import hardwareSettings.WindowActions;
import person.Customer.Customer;
import transaction.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CheckHistoryFrame
        extends JFrame
        implements WindowActions {

    private JPanel panel;
    private JList historyList;
    private DefaultListModel<Transaction> listModel;
    private JButton backButton;
    private JButton details;

    public CheckHistoryFrame(Account account) throws IOException {

        listModel = new DefaultListModel<>();
        historyList.setModel(listModel);

        TransactionsDatabase.getInstance().getTransactions()
                .stream()
                .filter(transaction -> transaction.getReceiverAccountNumber().equals(account.getAccountNumber()) ||
                        transaction.getSenderAccountNumber().equals(account.getAccountNumber())).
                        forEach(transaction -> listModel.addElement(transaction));

        WindowActions.setBankLogoFrame(this);

        details.setFocusable(false);
        details.addActionListener(
                e -> {
                    if(!historyList.isSelectionEmpty()) {
                        Transaction transaction = listModel.elementAt(historyList.getSelectedIndex());
                        JOptionPane.showMessageDialog(this,
                                "Sender: " + transaction.getSenderAccountNumber() + "\n" +
                                        "Receiver: " + transaction.getReceiverAccountNumber() + "\n" +
                                        "Amount: " + transaction.getTransferAmount() + "\n" +
                                        "Date: " + transaction.getSendingDate() + " " + transaction.getSendingTime(),
                                "TRANSACTION DETAILS",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
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
