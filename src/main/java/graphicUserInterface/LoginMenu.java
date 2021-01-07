package graphicUserInterface;

import databases.CustomersDatabase;
import databases.EmployeesDatabase;
import graphicUserInterface.mainMenu.MainMenuCustomer;
import graphicUserInterface.mainMenu.MainMenuEmployee;
import hardwareSettings.WindowActions;
import person.Customer.Customer;
import person.Employee.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class LoginMenu
        extends JFrame
        implements ActionListener,
        WindowActions {

    JPanel loginPanel;
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
    HashMap<String, String> loginInfoCustomer;
    HashMap<String, String> loginInfoEmployee;


    public LoginMenu(HashMap<String, String> loginInfoCustomerOriginal, HashMap<String, String> loginInfoEmployeeOriginal) throws IOException {

        loginInfoCustomer = loginInfoCustomerOriginal;
        loginInfoEmployee = loginInfoEmployeeOriginal;

        WindowActions.setBankLogoFrame(this);
        WindowActions.centreWindow(this);
        WindowActions.setHalfScreenSize(this);

        this.setTitle("Your Bank, Welcome!");
        this.setContentPane(loginPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(customerRadioButton);
        group.add(workerRadioButton);

        customerRadioButton.setFocusable(false);
        customerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginLabel.setText("Login:");
                chooser = 1;
                //System.out.println(chooser);
            }
        });

        workerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginLabel.setText("ID:");
                chooser = 2;
                //System.out.println(chooser);
            }
        });
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
                new StartPage(loginInfoCustomer, loginInfoEmployee);
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
                Optional<Customer> matched = customersDatabase.getCustomers().stream().filter(customer -> customer.getLogin().equals(login)).findFirst();
                if(matched.isPresent() && matched.get().getPassword().equals(new String(passwordField.getPassword()))) {
                    loginField.setText("ZALOGOWANO KLIENTA");   //usun to pozniej xd
                    //ZALOGOWANO!!!,
                    // TUTAJ CIĘ STANISŁAWIE OPUSZCZAM
                    //DALEJ BYL TEN KOD, ALE MUSISZ GO CIUT ZMIENIC:
                    //POWINNO BYĆ W TYM KONSTRUKTORZE KLIENTA PRZESYŁANIE JEGO KONTA DALEJ
                    //ŻEBY NIE TRZEBA BYŁO DRUGI RAZ TEGO WYSZUKIWAĆ
                    /*try {
                        new MainMenuCustomer(loginInfoCustomer, loginInfoEmployee);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }*/

                }
            }
            if(chooser == 2) {
                EmployeesDatabase employeesDatabase = EmployeesDatabase.getInstance();
                String sID = loginField.getText();
                //if that customer exists
                Optional<Employee> matched = employeesDatabase.getEmployees().stream().filter(employee -> employee.getsID().equals(sID)).findFirst();
                if(matched.isPresent() && matched.get().getPassword().equals(new String(passwordField.getPassword()))) {
                    loginField.setText("ZALOGOWANO PRACOWNIKA");   //usun to pozniej xd
                    //ZALOGOWANO!!!,
                    // TUTAJ CIĘ STANISŁAWIE OPUSZCZAM
                    //DALEJ BYL TEN KOD, ALE MUSISZ GO CIUT ZMIENIC:
                    //POWINNO BYĆ W TYM KONSTRUKTORZE KLIENTA PRZESYŁANIE JEGO KONTA DALEJ
                    //ŻEBY NIE TRZEBA BYŁO DRUGI RAZ TEGO WYSZUKIWAĆ

                }
            }
            /*
            if(chooser == 1){
                if(loginInfoCustomer.containsKey(loginField.getText()) &&
                    loginInfoCustomer.get(loginField.getText()).equals(String.valueOf(passwordField.getPassword()))){
                    this.dispose();

                }
                else{
                    JOptionPane.showMessageDialog(null, "WRONG DATA, ARE YOU MAD?!", "WRONG DATA ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(chooser == 2){
                if(loginInfoEmployee.containsKey(loginField.getText())&&
                    loginInfoEmployee.get(loginField.getText()).equals(String.valueOf(passwordField.getPassword()))){
                    this.dispose();
                    try{
                        new MainMenuEmployee(loginInfoCustomer, loginInfoEmployee);
                    }catch(IOException ioException){
                        ioException.printStackTrace();
                    }
                }
                else if(loginInfoEmployee.containsKey(loginField.getText()) &&
                    !loginInfoEmployee.get(loginField.getText()).equals(String.valueOf(passwordField.getPassword()))){
                    JOptionPane.showMessageDialog(null, "WRONG PASSWORD HONEY", "WRONG PASSWORD", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "USERNAME NOT FOUND", "NO USERNAME", JOptionPane.ERROR_MESSAGE);

                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Choose your profession summoner!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            */
        }
    }
}
