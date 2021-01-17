package graphicUserInterface.mainMenu.customerMainMenuOptions;

import account.Account;
import account.AccountNumberGenerator;
import account.foreignCurrencyAccount.CurrencyManager;
import account.foreignCurrencyAccount.ForeignCurrencyAccount;
import account.savingsAccount.SavingsAccount;
import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class CreateNewAccountFrame
        extends JFrame
        implements WindowActions {

    private JPanel panel;
    private JRadioButton NORMALRadioButton;
    private JRadioButton SAVINGSRadioButton;
    private JRadioButton FOREIGN_CURRENCYRadioButton;
    private JFormattedTextField targetTextField;
    private JComboBox<CurrencyManager.Currency> currencyCombo;
    private JButton submitButton;
    /*
    1 - normal
    2 - savings
    3 - foreign
     */
    public CreateNewAccountFrame(Customer customer) throws IOException {
        WindowActions.setBankLogoFrame(this);

        ButtonGroup group = new ButtonGroup();
        group.add(NORMALRadioButton);
        group.add(SAVINGSRadioButton);
        group.add(FOREIGN_CURRENCYRadioButton);

        NORMALRadioButton.setFocusable(false);
        SAVINGSRadioButton.setFocusable(false);
        FOREIGN_CURRENCYRadioButton.setFocusable(false);
        targetTextField.setFocusable(false);
        currencyCombo.setFocusable(false);
        NORMALRadioButton.setSelected(true);
        targetTextField.setEnabled(false);
        currencyCombo.setEnabled(false);

        NORMALRadioButton.setFocusable(false);
        NORMALRadioButton.addActionListener(
                e -> {
                    targetTextField.setEnabled(false);
                    targetTextField.setFocusable(false);
                    currencyCombo.setEnabled(false);
                }
        );

        SAVINGSRadioButton.setFocusable(false);
        SAVINGSRadioButton.addActionListener(
                e -> {
                    targetTextField.setEnabled(true);
                    targetTextField.setFocusable(true);
                    currencyCombo.setEnabled(false);
                }
        );

        FOREIGN_CURRENCYRadioButton.setFocusable(false);
        FOREIGN_CURRENCYRadioButton.addActionListener(
                e -> {
                    targetTextField.setEnabled(false);
                    targetTextField.setFocusable(false);
                    currencyCombo.setEnabled(true);
                }
        );
        for (var curr: CurrencyManager.getCurrencies()) {
            if(curr != CurrencyManager.Currency.PLN)
                currencyCombo.addItem(curr);
        }

        submitButton.setFocusable(false);
        submitButton.addActionListener(
                e -> {
                    String userInput;
                    userInput = JOptionPane.showInputDialog(this,
                            "\nEnter your PIN", "Confirm with PIN", JOptionPane.QUESTION_MESSAGE);

                    if(Integer.valueOf(userInput).equals(customer.getiPIN())) {
                        this.dispose();
                        Account account = null;
                        if(NORMALRadioButton.isSelected()) {
                            account = new Account();
                        }
                        if(SAVINGSRadioButton.isSelected()) {
                            account = new SavingsAccount();
                            ((SavingsAccount)account).setTargetBalance(Float.parseFloat(targetTextField.getText()));
                        }
                        if(FOREIGN_CURRENCYRadioButton.isSelected()) {
                            account = new ForeignCurrencyAccount();
                            ((ForeignCurrencyAccount)account).setCurrency((CurrencyManager.Currency) currencyCombo.getSelectedItem());
                        }
                        account.setBalance(0.0);
                        account.setStatus(false);
                        account.setAccountNumber(AccountNumberGenerator.nextAccountNumber());
                        customer.addAccount(account);
                        JOptionPane.showMessageDialog(this, "ACCOUNT ADDED!", "Account added message", JOptionPane.INFORMATION_MESSAGE);

                    }else{
                        JOptionPane.showMessageDialog(this, "WRONG DATA", "Wrong data", JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        this.setSize(650, 400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}
