package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * A Varázsbogyók játék menüje
 */
public class MenuPanel extends JPanel {

    private ArrayList<JButton> btns = new ArrayList<JButton>();

    /**
     * Konstruktor
     */
    public MenuPanel() {
        super(new BorderLayout());
        init();
    }

    /**
     * Komponensek létrehozása
     */
    public void init() {
        JPanel topText = new JPanel();
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ImageIcon img = new ImageIcon("resources/csillag.jpg");

        JLabel title = new JLabel("<html> <div style='text-align:center;'> VIROLOGY <br> BALL </div></html>", JLabel.LEFT);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(Color.black);
        JLabel kep = new JLabel("", img, JLabel.CENTER);
        topText.add(title);
        topText.add(kep);

        // Define new buttons with different regions
        JButton newGameBtn = new JButton("NEW GAME");
        JButton scoreboard = new JButton("SCOREBOARD");
        JButton exitBtn = new JButton("EXIT");

        btns.add(newGameBtn);
        btns.add(scoreboard);
        btns.add(exitBtn);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.insets = new Insets(20, 10, 20, 10);

        int counter = 1;

        for (JButton btn : btns){
            btn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
            btn.setForeground(Color.black);
            btn.setBackground(new Color(255, 0, 82));
            btn.setBorder(BorderFactory.createLineBorder(new Color(191, 255, 0), 10));

            c.gridx = 0;
            c.gridy = counter++;
            panel.add(btn, c);

        }

        panel.setBackground(new Color(255, 0, 82));
        topText.setBackground(new Color(255, 0, 82));

        newGameBtn.addActionListener(e -> VarazsbogyokFrame.getInstance().show("adat"));
        scoreboard.addActionListener(e -> VarazsbogyokFrame.getInstance().show("scoreboard"));
        exitBtn.addActionListener(e -> System.exit(0));

        add(topText, BorderLayout.NORTH);
        add(panel);
        setVisible(true);
    }
}