package graphicUserInterface;

import graphicUserInterface.mainMenu.MainMenuCustomer;
import graphicUserInterface.mainMenu.MainMenuEmployee;
import hardwareSettings.WindowActions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class LoginMenu
        extends JFrame
        implements ActionListener,
        WindowActions {

    JPanel loginPanel;
    JRadioButton customerRadioButton;
    JRadioButton workerRadioButton;
    JPasswordField passwordField1;
    JFormattedTextField formattedTextField1;
    JButton loginButton;

    public LoginMenu() throws IOException {

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
        customerRadioButton.addActionListener(this);
        workerRadioButton.addActionListener(this);
        customerRadioButton.setFocusable(false);
        workerRadioButton.setFocusable(false);

        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == customerRadioButton){
            this.dispose();
            try {
                MainMenuCustomer mmc = new MainMenuCustomer();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        else if(e.getSource() == workerRadioButton) {
            this.dispose();
            try {
                MainMenuEmployee mme = new MainMenuEmployee();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
