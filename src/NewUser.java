import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;

public class NewUser extends JFrame {

    // Declare an Linked List for all user accounts in the system
    MyHashTable<Person> allUser;
    boolean isAdded = false;

    // Declare GUI Components
    private JPanel top;
    private JPanel center;
    private JPanel bottom;
    private JButton generateButton;
    private JButton createButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton showButton;
    private JButton showAllButton;
    private JTextArea viewArea;
    private JScrollPane scroller;

    public NewUser(String name) {

        String title = "Account: " + name;
        JFrame userFrame = new JFrame(title);

        // Create a Person object for the user
        Person user = new Person(name);

        // Create a LinkedList of all user accounts in the system and add the current user
        allUser = new MyHashTable<>();
        allUser.chainedHashInsert(user);

        // Declare layout with 3 panels
        top = new JPanel();
        center = new JPanel();
        bottom = new JPanel();

        // Declare GUI components in top panel
        top.setLayout(new GridLayout(0, 4));
        top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        createButton = new JButton("Add a single account");
        generateButton = new JButton("Auto generate 30 accounts");
        addButton = new JButton("Add friend");
        removeButton = new JButton("Unfriend");
        showButton = new JButton("Show my friend list");
        showAllButton = new JButton("Show all accounts");
        top.add(createButton);
        top.add(generateButton);
        top.add(addButton);
        top.add(removeButton);
        top.add(showButton);
        top.add(showAllButton);

        // Declare GUI components in center panel
        center.setLayout(new GridLayout());
        center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        viewArea = new JTextArea(37, 65);
        viewArea.setEditable(false);
        viewArea.setBackground(new Color(235, 255, 240));
        scroller = new JScrollPane(viewArea);
        center.add(scroller);

        printListOfUser();

        userFrame.add(top, BorderLayout.NORTH);
        userFrame.add(center, BorderLayout.CENTER);
        userFrame.add(bottom, BorderLayout.SOUTH);
        userFrame.setSize(800, 800);
        userFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);
        userFrame.getRootPane().setDefaultButton(createButton);
        userFrame.setVisible(true);

        // Add action listener for Create User Account button
        createButton.addActionListener(e -> {
            String result = JOptionPane.showInputDialog(userFrame,
                    "Enter full name for new account: ", null);
            if ((result != null) && (result.length() > 0)) {
                JOptionPane.showMessageDialog(userFrame, "User " + result + " has been added to the system!");
                Person newUser = new Person(result);
                allUser.chainedHashInsert(newUser);
                printListOfUser();
            }
        });

        // Add action listener for Generate 30 User Accounts button
        generateButton.addActionListener(e -> {
            if (isAdded) { // only generate once
                JOptionPane.showMessageDialog(userFrame, "You have already generated 30 accounts.", "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            String[] listOfRandom30Names = {"Sheldon Cooper", "Leonard Hofstadter", "Penny", "Howard Wolowitz", "Raj Koothrappali", "Amy Farrah Fowler", "Bernadette Rostenkowski", "Stuart Bloom", "Beverly Hofstadter", "Mary Cooper",
            "George Cooper", "George Cooper Jr", "Missy Cooper", "Leslie Winkle", "Emily Sweeney", "Priya Koothrappali", "Wil Wheaton", "Barry Kripke", "Stephanie Barnett", "Zack Johnson", "Eric Gablehauser", "Janine Davis", "Bert Kibbler", "Alfred Hofstadter", "Colonel Richard Williams", "Joey Nguyen", "Thanh Pham", "Larry Fowler", "Lana Del Rey", "Rinko Kikuchi"};
            for (String i : listOfRandom30Names) {
                allUser.chainedHashInsert(new Person(i));
            }
            isAdded = true;
            printListOfUser();
        });

        addButton.addActionListener(e -> {
            String result = JOptionPane.showInputDialog(userFrame, "Enter a username you want to add friend: ");
            if ((result != null) && (result.length() > 0)) {
                if (result.equals(user.getName())) {
                    JOptionPane.showMessageDialog(userFrame, "You can't friend yourself.", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (allUser.isContain(result)) {
                    JOptionPane.showMessageDialog(userFrame, "User " + result + " has been added to your friend list!");
                    // TODO use hashtable to search, insert, delete instead of myLinkedList
                    user.getFriendList().listInsert(allUser.chainedHashSearch(result));
                } else
                    JOptionPane.showMessageDialog(userFrame, result + " is not on the system. Please try add that user first.");
            }
        });

        removeButton.addActionListener(e -> {
            String result = JOptionPane.showInputDialog(userFrame, "Enter a username you want to unfriend: ");
            if ((result != null) && (result.length() > 0)) {
                if (user.getFriendList().isContain(result))  {
                    JOptionPane.showMessageDialog(userFrame, "You have unfriended " + result);
                    // TODO use hashtable to search, insert, delete instead of myLinkedList
                    user.getFriendList().listDelete(result);
                }
                else JOptionPane.showMessageDialog(userFrame, result + " is not on your friend list nor on the system. Failed to unfriend.");

            }
        });

        showButton.addActionListener(e -> {
            viewArea.setText("Here's your friend list: \n\n" + user.getFriendList().toString());
        });

        showAllButton.addActionListener(e -> {
            printListOfUser();
        });
    }

    /**
     * Print list of all user accounts in the system
     */
    public void printListOfUser() {
        viewArea.setText("Here're all the accounts on the system: \n\n" + allUser.toString());
    }
}
