package graphicUserInterface;

import hardwareSettings.WindowActions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class StartPage
        extends JFrame
        implements ActionListener,
        WindowActions {

    private JButton logInButton;
    private JButton createAccountButton;
    private JPanel startPagePanel;


    public StartPage() throws IOException {


        WindowActions.setUp(this);
        /*WindowActions.setBankLogoFrame(this);
        WindowActions.centreWindow(this);
        WindowActions.setHalfScreenSize(this);*/

        this.setContentPane(startPagePanel);
        this.setResizable(false);
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
            try {
                CreateAccountMenu cam = new CreateAccountMenu();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}