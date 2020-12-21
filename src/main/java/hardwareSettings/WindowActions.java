package hardwareSettings;

import javax.swing.*;
import java.awt.*;

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

    public static void setBankLogoFrame(JFrame frame){
        ImageIcon icon = new ImageIcon("bank_logo.png");
        frame.setIconImage(icon.getImage());
    }

    public static void setUp(JFrame frame){
        centreWindow(frame);
        setHalfScreenSize(frame);
        setBankLogoFrame(frame);
    }
}
