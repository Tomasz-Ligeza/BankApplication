package graphicUserInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class LoginMenu
        extends JFrame
        implements ActionListener{

    JPanel loginPanel;
    JRadioButton customerRadioButton;
    JRadioButton workerRadioButton;
    JPasswordField passwordField1;
    JFormattedTextField formattedTextField1;
    JButton loginButton;

    public LoginMenu() throws IOException {

        URL iconURL = new URL("https://freeiconshop.com/wp-content/uploads/edd/bank-flat.png");
        Image icon = ImageIO.read(iconURL);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        this.setIconImage(new ImageIcon(icon).getImage());
        this.setTitle("Your Bank, Welcome!");
        this.setContentPane(loginPanel);
        this.setLocation(screenWidth/4, screenHeight/4);
        this.setSize(screenWidth/2, screenHeight/2);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(customerRadioButton);
        group.add(workerRadioButton);
        customerRadioButton.addActionListener(this);
        workerRadioButton.addActionListener(this);

        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
