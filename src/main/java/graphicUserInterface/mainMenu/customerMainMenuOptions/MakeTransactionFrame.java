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
import java.time.LocalDate;
import java.time.LocalTime;

public class MakeTransactionFrame
        extends JFrame
        implements ActionListener, WindowActions {

    private JPanel panel;
    private JFormattedTextField accountNumberFormattedTextField;
    private JFormattedTextField amountFormattedTextField;
    private JButton sendButton;
    private JComboBox<Account> accountsComboBox;

    public MakeTransactionFrame(Customer customer) throws IOException {
        WindowActions.setBankLogoFrame(this);

        for(var acc : customer.getAccounts()) {
            accountsComboBox.addItem(acc);
        }

        sendButton.setFocusable(false);
        sendButton.addActionListener(
                e -> {
                    String receiverAccount= accountNumberFormattedTextField.getText();
                    String amountString = amountFormattedTextField.getText().toString().replace(',', '.');
                    double amount = Double.parseDouble(amountString);

                    if(amount > ((Account)accountsComboBox.getSelectedItem()).getBalance()) {
                        JOptionPane.showMessageDialog(this, "You don`t have enough money on account.", "Wrong transfer amount", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(receiverAccount.equals(((Account) accountsComboBox.getSelectedItem()).getAccountNumber())) {
                        JOptionPane.showMessageDialog(this, "Both account numbers are equal.", "Wrong account numbers", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String userInput;
                    userInput = JOptionPane.showInputDialog(this, "Enter your PIN", "Confirm with PIN", JOptionPane.QUESTION_MESSAGE);

                    if(Integer.parseInt(userInput) == customer.getiPIN()){
                        Transaction transaction = new Transaction();
                        transaction.setReceiverAccountNumber(receiverAccount);
                        transaction.setSenderAccountNumber(((Account)accountsComboBox.getSelectedItem()).getAccountNumber());
                        transaction.setTransferAmount(amount);
                        transaction.setSendingTime(LocalTime.now());
                        transaction.setSendingDate(LocalDate.now());

                        TransactionsDatabase.getInstance().makeTransaction(transaction);


                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "WRONG DATA", "Wrong data", JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        this.setSize(400, 400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
