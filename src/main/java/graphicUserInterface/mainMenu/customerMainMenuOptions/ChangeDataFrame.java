package graphicUserInterface.mainMenu.customerMainMenuOptions;

import hardwareSettings.WindowActions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChangeDataFrame
        extends JFrame
        implements ActionListener, WindowActions {

    private JFormattedTextField newLoginFormattedTextField;
    private JPasswordField newPasswordPasswordField;
    private JPasswordField oldPasswordConfirmPasswordField;
    private JButton SUBMITButton;
    private JPanel panel;

    public ChangeDataFrame() throws IOException {

        //WindowActions.centreWindow(this);
        WindowActions.setBankLogoFrame(this);

        this.setSize(400,400);
        this.setContentPane(panel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
