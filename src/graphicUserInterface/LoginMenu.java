package graphicUserInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class LoginMenu {

    JPanel loginPanel;
    JRadioButton customerRadioButton;
    JRadioButton workerRadioButton;
    JPasswordField passwordField1;
    JFormattedTextField formattedTextField1;
    JButton createAccountButton;
    JButton loginButton;

    public LoginMenu() throws IOException {
        JFrame frame = new JFrame("Login Menu");

        /*
        can add if-else, about customers internet connection
        but imo if customer doesnt have internet connecton he shouldnt be able
        to log in
         */
        URL iconURL = new URL("https://freeiconshop.com/wp-content/uploads/edd/bank-flat.png");
        Image icon = ImageIO.read(iconURL);
        frame.setIconImage(new ImageIcon(icon).getImage());

        /*loginPanel.add(customerRadioButton);
        loginPanel.add(workerRadioButton);
        loginPanel.add(passwordField1);
        loginPanel.add(formattedTextField1);
        loginPanel.add(createAccountButton);
        loginPanel.add(loginButton);*/

        frame.setContentPane(loginPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setLocation(screenWidth/2, screenHeight/2);
        frame.setSize(screenWidth/2, screenHeight/2);
        //frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Zalogowano");
            }
        });
    }
}
