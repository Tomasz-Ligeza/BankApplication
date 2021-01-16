package graphicUserInterface;

import address.Address;
import databases.CustomersDatabase;
import hardwareSettings.WindowActions;
import person.Customer.Customer;
import person.IDGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CreateAccountMenu
        extends JFrame
        implements ActionListener,
        WindowActions {

    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField peselTextField;
    private JComboBox yearComboBox;
    private JComboBox monthComboBox;
    private JComboBox dayComboBox;
    private JPanel camPanel;
    private JTextField countryTextField;
    private JTextField cityTextField;
    private JTextField postalCodeTextField;
    private JTextField streetTextField;
    private JTextField houseNumberTextField;
    private JButton registerButton;
    private JButton cancelButton;

    private List<JTextField> textFields;

    public CreateAccountMenu() throws IOException {


        WindowActions.setUp(this);
        /*WindowActions.setBankLogoFrame(this);
        WindowActions.centreWindow(this);
        WindowActions.setHalfScreenSize(this);*/

        this.setContentPane(camPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        for(int i = 1900; i <= 2021; i++)
            yearComboBox.addItem(i);
        for(int i = 1; i <= 12; i++)
            monthComboBox.addItem(i);
        for(int i = 1; i <= 31; i++)
            dayComboBox.addItem(i);

        registerButton.addActionListener(this);
        registerButton.setFocusable(false);

        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);
        textFields = new LinkedList<>();
        collectTextFields();
    }

    private void collectTextFields() {
        textFields.add(nameTextField);
        textFields.add(surnameTextField);
        textFields.add(peselTextField);
        textFields.add(countryTextField);
        textFields.add(cityTextField);
        textFields.add(postalCodeTextField);
        textFields.add(streetTextField);
        textFields.add(houseNumberTextField);
    }

    private boolean isInputOK() {
        for (var textField : textFields) {
            if(textField.getText().isEmpty())
                return false;
            if(textField.getText().contains(" "))
                return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            this.dispose();
            try {
                new StartPage();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if(e.getSource() == registerButton) {
            if(isInputOK()) {
                Customer customer = new Customer(
                        nameTextField.getText(),
                        surnameTextField.getText(),
                        peselTextField.getText(),
                        LocalDate.of((Integer) yearComboBox.getSelectedItem(), (Integer) monthComboBox.getSelectedItem(), (Integer) dayComboBox.getSelectedItem()),
                        new Address(countryTextField.getText(), cityTextField.getText(), streetTextField.getText(), houseNumberTextField.getText(), postalCodeTextField.getText()),
                        "XD",
                        new Random().nextInt(10000)
                );
                customer.setLogin(customer.getsID());

                if(CustomersDatabase.getInstance().addCustomer(customer)) {
                    String password = customer.getPassword();
                    int pin = customer.getiPIN();
                    JTextArea text = new JTextArea(String.format("REGISTERED!\nlogin: %s\npassword: %s\npin: %d", customer.getsID(), password, pin));
                    text.setEditable(false);
                    text.setBackground(UIManager.getColor("TextField.background"));
                    JOptionPane.showMessageDialog(null,
                            text,
                            "REGISTRATION FEEDBACK", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "SUCH CUSTOMER ALREADY EXISTS!",
                            "REGISTRATION FEEDBACK", JOptionPane.ERROR_MESSAGE);
                }
                this.dispose();
                try {
                    new StartPage();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "WRONG REGISTRATION DATA!", "DATA ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
