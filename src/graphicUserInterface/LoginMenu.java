package graphicUserInterface;

import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class LoginMenu {
    private JPanel loginPanel;

    private JRadioButton customerRadioButton;
    private JRadioButton workerRadioButton;
    private JPasswordField passwordField1;
    private JFormattedTextField formattedTextField1;
    private JButton createAccountButton;
    private JButton loginButton;

    public LoginMenu() throws IOException {
        JFrame frame = new JFrame("Login Menu");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new LoginMenu().loginPanel);

        URL iconURL = new URL("https://freeiconshop.com/wp-content/uploads/edd/bank-flat.png");
        Image icon = ImageIO.read(iconURL);
        frame.setIconImage(new ImageIcon(icon).getImage());

        loginPanel.add(customerRadioButton);
        loginPanel.add(workerRadioButton);
        loginPanel.add(passwordField1);
        loginPanel.add(formattedTextField1);
        loginPanel.add(createAccountButton);
        loginPanel.add(loginButton);

    }
}
