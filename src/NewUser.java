import javax.swing.*;
import java.awt.*;

public class NewUser extends JFrame {

    // Declare GUI Components
    private JPanel top;
    private JPanel center;
    private JPanel bottom;

    public NewUser(String name) {

        String title = "Account: " + name;
        JFrame userFrame = new JFrame(title);

        // Declare layout with 3 panels
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();

        // Declare GUI components in top panel
        top.setLayout(new FlowLayout());


        userFrame.add(top, BorderLayout.NORTH);
        userFrame.add(center, BorderLayout.CENTER);
        userFrame.add(bottom, BorderLayout.SOUTH);
        userFrame.setSize(800, 800);
        userFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.setVisible(true);
    }
}
