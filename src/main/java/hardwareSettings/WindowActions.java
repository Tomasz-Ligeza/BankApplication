package hardwareSettings;

import graphicUserInterface.StartPage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public interface WindowActions {

    public static void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 4);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 4);
        frame.setLocation(x, y);
    }

    public static void setHalfScreenSize(JFrame frame){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.height/2);
        int y = (int) (dimension.width/2);
        frame.setSize(y, x);
    }

    public static void setBankLogoFrame(JFrame frame) throws IOException {
       /* ImageIcon icon = new ImageIcon("bank_logo.png");
        frame.setIconImage(icon.getImage());*/

        URL url = new URL("https://freeiconshop.com/wp-content/uploads/edd/bank-flat.png");
        Image image = ImageIO.read(url);
        frame.setIconImage(new ImageIcon(image).getImage());

    }

    public static void setUp(JFrame frame) throws IOException {
        centreWindow(frame);
        setHalfScreenSize(frame);
        setBankLogoFrame(frame);
    }

    public static void addMenuBar(JFrame mainFrame){
        JMenuBar menuBar = new JMenuBar();
        JButton logOutButton = new JButton("Log OUT");

        logOutButton.setFocusable(false);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                //System.out.println("CLICK");
                try {
                    new StartPage();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        menuBar.add(logOutButton);
        menuBar.setVisible(true);

        mainFrame.setJMenuBar(menuBar);
    }

}
