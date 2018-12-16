import javax.swing.*;
import java.awt.*;

public class Simulator extends JFrame{

    // Declare GUI elements
    private JButton createButton;
    private JPanel panel;


    public Simulator() {

        // Initiate main frame
        createMainFrame();
    }

    private void createMainFrame() {
        // Set up GUI components
        createButton = new JButton("Create a new account");

        // Setup panels
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(createButton);

        // Set up frames
        JFrame mainFrame = new JFrame("FB Simulator 1.0");
        mainFrame.add(panel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 100);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.getRootPane().setDefaultButton(createButton);
        mainFrame.setVisible(true);

        // --------------Action Listeners--------------
        createButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(mainFrame,
                    "Enter your full name: ", null);
            if ((name != null) && (name.length() > 0)) {
                new NewUser(name);
                mainFrame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Simulator();
    }
}
