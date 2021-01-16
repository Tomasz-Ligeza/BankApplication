package graphicUserInterface.mainMenu.customerMainMenuOptions;

import hardwareSettings.WindowActions;
import person.Customer.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChangeDataFrame
        extends JFrame
        implements WindowActions {

    private JFormattedTextField newLoginFormattedTextField;
    private JPasswordField newPasswordPasswordField;
    private JPasswordField oldPasswordConfirmPasswordField;
    private JButton SUBMITButton;
    private JPanel panel;

    private final String newLogin;
    private final String newPassword;
    private final String oldPassword;

    private final Customer loggedCustomerCopy;
    private final int userPIN;

    public ChangeDataFrame(Customer loggedCustomer) throws IOException {

        loggedCustomerCopy = loggedCustomer;
        userPIN = loggedCustomer.getiPIN();
        //WindowActions.centreWindow(this);
        WindowActions.setBankLogoFrame(this);

        newLogin = newLoginFormattedTextField.getText();
        newPassword = newPasswordPasswordField.getPassword().toString();
        oldPassword = oldPasswordConfirmPasswordField.getPassword().toString();

        SUBMITButton.addActionListener(
                e ->
                {
                    if(newLogin != null &&
                            newPassword != null &&
                            oldPassword.equals(loggedCustomerCopy.getPassword())){

                        String userInput;
                        userInput = JOptionPane.showInputDialog(this, "Enter your PIN", "Confirm with PIN", JOptionPane.QUESTION_MESSAGE);
                        if(Integer.valueOf(userInput) == userPIN){
                            this.dispose();
                            loggedCustomerCopy.setLogin(newLogin);
                            loggedCustomerCopy.setPassword(newPassword);
                        }else{
                            JOptionPane.showMessageDialog(this, "WRONG DATA", "Wrong data", JOptionPane.ERROR_MESSAGE);
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "WRONG DATA!", "WRONG DATA", JOptionPane.ERROR_MESSAGE);
                        System.out.println(loggedCustomerCopy.toString());   //haslo jest poprawnie przypisane to o co tu chodzi?
                        /*
                        odpalilem debugger i juz widze
                        oldPassword i password uzytwnika sie roznia dlugoscia i znakami
                         */
                    }
                }
        );

        this.setSize(400,400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

}
