package graphicUserInterface.mainMenu;

import hardwareSettings.WindowActions;

import javax.accessibility.AccessibleAction;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuCustomer
        extends JFrame
        implements ActionListener,
        WindowActions {

    public MainMenuCustomer(){

        WindowActions.setUp(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
