package graphicUserInterface;

import databases.CustomersDatabase;
import databases.EmployeesDatabase;
import graphicUserInterface.mainMenu.MainMenuCustomer;
import graphicUserInterface.mainMenu.MainMenuEmployee;
import hardwareSettings.WindowActions;
import person.Customer.Customer;
import person.Employee.Employee;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Optional;

public class LoginMenu
        extends JFrame
        implements ActionListener,
        WindowActions {

    JPanel logPanel;
    JRadioButton customerRadioButton;
    JRadioButton workerRadioButton;
    JPasswordField passwordField;
    JFormattedTextField loginField;
    JButton loginButton;
    private JButton cancelButton;
    private JButton clearButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    /**
     * 0 for none
     * 1 for customer
     * 2 for employee
     */
    private int chooser = 1;

    public LoginMenu() throws IOException {


        WindowActions.setBankLogoFrame(this);
        WindowActions.centreWindow(this);
        WindowActions.setHalfScreenSize(this);

        this.setTitle("Your Bank, Welcome!");
        this.setContentPane(logPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(customerRadioButton);
        group.add(workerRadioButton);

        customerRadioButton.setFocusable(false);
        customerRadioButton.addActionListener(

                (e) -> this.chooser = 1
        );

        workerRadioButton.addActionListener(

                (e) -> this.chooser = 2
        );
        workerRadioButton.setFocusable(false);

        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        clearButton.setFocusable(false);
        clearButton.addActionListener(this);

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
        if(e.getSource() == clearButton){
            passwordField.setText("");
            loginField.setText("");
        }
        if(e.getSource() == loginButton){
            if(chooser == 1) {
                CustomersDatabase customersDatabase = CustomersDatabase.getInstance();
                String login = loginField.getText();
                //if that customer exists
                Optional<Customer> matchedCustomer = customersDatabase.getCustomers().stream().filter(customer -> customer.getLogin().equals(login)).findFirst();

                if(matchedCustomer.isPresent() &&
                    matchedCustomer.get().getPassword().equals(new String(passwordField.getPassword()))) {

                    Customer toLogCustomer = matchedCustomer.get();
                    JOptionPane.showMessageDialog(null, "LOGGED", "Succesful login operation", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    try {
                        new MainMenuCustomer(toLogCustomer);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                } else{
                    JOptionPane.showMessageDialog(null, "WRONG LOGIN DATA!", "DATA ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else if(chooser == 2) {
                EmployeesDatabase employeesDatabase = EmployeesDatabase.getInstance();
                String sID = loginField.getText();
                //if that customer exists
                Optional<Employee> matchedEmployee = employeesDatabase.getEmployees().stream().filter(employee -> employee.getsID().equals(sID)).findFirst();

                if(matchedEmployee.isPresent() &&
                    matchedEmployee.get().getPassword().equals(new String(passwordField.getPassword()))) {

                    Employee toLogEmployee = matchedEmployee.get();

                    JOptionPane.showMessageDialog(null, "LOGGED", "Succesful login operation", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    try {
                        new MainMenuEmployee(toLogEmployee);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                } else{
                    JOptionPane.showMessageDialog(null, "WRONG LOGIN DATA!", "DATA ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
