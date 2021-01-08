package graphicUserInterface.mainMenu;

import hardwareSettings.WindowActions;
import person.Employee.Employee;

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

    public MainMenuEmployee(Employee loggedEmployee) throws IOException {

        WindowActions.setUp(this);
        WindowActions.addMenuBar(this);

        employeeHello.setText("HELLO " + loggedEmployee.getFirstName() + " " + loggedEmployee.getsID());

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
