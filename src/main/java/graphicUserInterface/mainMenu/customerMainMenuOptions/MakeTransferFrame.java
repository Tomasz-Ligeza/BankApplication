package graphicUserInterface.mainMenu.customerMainMenuOptions;

import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MakeTransferFrame
        extends JFrame
        implements ActionListener, WindowActions {

    private JPanel panel;
    private JFormattedTextField accountNumberFormattedTextField;
    private JFormattedTextField amountFormattedTextField;
    private JButton sendButton;
    private String receiverAccount;
    private String amount;

    private final Customer customerCopy;

    public MakeTransferFrame(Customer customer) throws IOException {

        customerCopy = customer;

        WindowActions.setBankLogoFrame(this);

        sendButton.setFocusable(false);
        sendButton.addActionListener(
                e -> {
                    receiverAccount= accountNumberFormattedTextField.getText();
                    amount = amountFormattedTextField.getText();

                    String userInput;
                    userInput = JOptionPane.showInputDialog(this, "Enter your PIN", "Confirm with PIN", JOptionPane.QUESTION_MESSAGE);

                    if(Integer.valueOf(userInput) == customerCopy.getiPIN()){
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
