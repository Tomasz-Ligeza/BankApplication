package hardwareSettings;

import java.awt.*;

public class HardwareSettings {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public int screenHeight = screenSize.height;
    public int screenWidth = screenSize.width;
}
