import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JButton button1;
    private JPanel panelMain;

    /**
     * tutaj komentarze zostawaia niezlykozak
     * elo jebac pis
     */
    public App() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Błąd bankowy na Twoją korzyść, pobierz 200 zł!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BankApplication");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        frame.setLocation(screenWidth/2, screenHeight/2);
        frame.setSize(screenWidth/2, screenHeight/2);
        frame.setVisible(true);
    }


}
