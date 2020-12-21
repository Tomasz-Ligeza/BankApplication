package graphicUserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartPage
        extends JFrame
        implements ActionListener {

    private JButton logInButton;
    private JButton createAccountButton;
    private JPanel startPagePanel;

    public StartPage(){

        ImageIcon icon = new ImageIcon("bank_logo.png");

        this.setContentPane(startPagePanel);
        this.setSize(420,500);
        this.setResizable(false);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        logInButton.setFocusable(false);
        logInButton.setSize(200,250);
        logInButton.addActionListener(this);

        createAccountButton.setFocusable(false);
        createAccountButton.setSize(200,250);
        createAccountButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logInButton){
            try {
                this.dispose();
                LoginMenu loginMenu = new LoginMenu();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if(e.getSource() == createAccountButton){
            this.dispose();
            CreateAccountMenu cam = new CreateAccountMenu();
        }
    }
}
