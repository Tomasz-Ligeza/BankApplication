package graphicUserInterface.mainMenu.customerMainMenuOptions;

import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreatePeriodPaymentFrame
        extends JFrame
        implements ActionListener, WindowActions {

    private JPanel panel;
    private JFormattedTextField accountNumberFormattedTextField;
    private JFormattedTextField amountFormattedTextField;
    private JFormattedTextField durationTimeInMonthsFormattedTextField;
    private JButton submitButton;
    private final Customer customerCopy;
    private String receiverAccountNr;
    private double amount;
    private int duration;
    private final int userPIN;

    public CreatePeriodPaymentFrame(Customer customer) throws IOException {

        customerCopy = customer;
        userPIN = customerCopy.getiPIN();

        WindowActions.setBankLogoFrame(this);

        submitButton.setFocusable(false);
        submitButton.addActionListener(
                e -> {
                    receiverAccountNr = accountNumberFormattedTextField.getText();
                    amount = Double.parseDouble(amountFormattedTextField.getText());
                    duration = Integer.parseInt(durationTimeInMonthsFormattedTextField.getText());
                    System.out.println(customerCopy.toString());
                    System.out.println(receiverAccountNr);
                    System.out.println(amount);
                    System.out.println(duration);
                    String userInput;
                    userInput = JOptionPane.showInputDialog(this, "Enter your PIN", "Confirm with PIN", JOptionPane.QUESTION_MESSAGE);

                    if(Integer.valueOf(userInput) == userPIN){
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "WRONG DATA", "Wrong data", JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        this.setSize(400,400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
