package graphicUserInterface.mainMenu.customerMainMenuOptions;

import account.savingsAccount.SavingsAccount;
import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateNewAccountFrame
        extends JFrame
        implements WindowActions {

    private JPanel panel;
    private JRadioButton NORMALRadioButton;
    private JRadioButton SAVINGSRadioButton;
    private JRadioButton FOREIGN_CURRENCYRadioButton;
    private JFormattedTextField targetTextField;
    private JComboBox currencyCombo;
    private JButton submitButton;
    /*
    1 - normal
    2 - savings
    3 - foreign
     */
    private int chooser = 1;
    private final Customer customerCopy;

    public CreateNewAccountFrame(Customer customer) throws IOException {
        customerCopy = customer;
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
                    this.chooser = 1;
                    targetTextField.setEnabled(false);
                    currencyCombo.setEnabled(false);
                }
        );

        SAVINGSRadioButton.setFocusable(false);
        SAVINGSRadioButton.addActionListener(
                e -> {
                    this.chooser = 2;
                    targetTextField.setEnabled(true);
                    currencyCombo.setEnabled(false);
                }
        );

        FOREIGN_CURRENCYRadioButton.setFocusable(false);
        FOREIGN_CURRENCYRadioButton.addActionListener(
                e -> {
                    this.chooser = 3;
                    targetTextField.setEnabled(false);
                    currencyCombo.setEnabled(true);
                }
        );

        submitButton.setFocusable(false);
        submitButton.addActionListener(
                e -> {
                    String userInput;
                    userInput = JOptionPane.showInputDialog(this, "Type of new account: " + chooser +
                            "\nEnter your PIN", "Confirm with PIN", JOptionPane.QUESTION_MESSAGE);

                    if(Integer.valueOf(userInput) == customerCopy.getiPIN()){
                        this.dispose();
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
