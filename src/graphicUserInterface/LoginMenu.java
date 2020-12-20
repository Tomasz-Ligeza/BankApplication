package graphicUserInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class LoginMenu extends JFrame{

    JPanel loginPanel;
    JRadioButton customerRadioButton;
    JRadioButton workerRadioButton;
    JPasswordField passwordField1;
    JFormattedTextField formattedTextField1;
    JButton createAccountButton;
    JButton loginButton;

    public LoginMenu() throws IOException {

        URL iconURL = new URL("https://freeiconshop.com/wp-content/uploads/edd/bank-flat.png");
        Image icon = ImageIO.read(iconURL);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.setIconImage(new ImageIcon(icon).getImage());
        this.setTitle("Your Bank, Welcome!");
        this.setContentPane(loginPanel);
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.setLocation(screenWidth/4, screenHeight/4);
        this.setSize(screenWidth/2, screenHeight/2);
        //this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Zalogowano");
            }
        });
    }
}
