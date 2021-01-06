package graphicUserInterface.mainMenu;

import hardwareSettings.WindowActions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class MainMenuEmployee
        extends JFrame
        implements ActionListener,
        WindowActions {

    private JFormattedTextField formattedTextField1;
    private JPanel panel;
    private JButton blockButton;
    private JList loanRequestList;
    private JList accountRequestList;
    private JButton acceptButton;
    private JButton acceptButton1;
    private JPanel panelPicture;
    private JLabel pictureLabel;
    private JLabel employeeHello;
    HashMap<String, String> loginInfoCustomer;
    HashMap<String, String> loginInfoEmployee;

    public MainMenuEmployee(HashMap<String, String> loginInfoCustomerOriginal, HashMap<String, String> loginInfoEmployeeOriginal) throws IOException {

        loginInfoCustomer = loginInfoCustomerOriginal;
        loginInfoEmployee = loginInfoEmployeeOriginal;

        WindowActions.setUp(this);
        WindowActions.addMenuBar(this, loginInfoCustomerOriginal, loginInfoEmployeeOriginal);

        blockButton.setFocusable(false);
        acceptButton.setFocusable(false);
        acceptButton1.setFocusable(false);


        this.setContentPane(panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
