package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Varázsbogyók játék menüje
 */
public class MenuPanel extends JPanel {

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

        ImageIcon img = new ImageIcon("Szkeleton/resources/csillag.png");

        JLabel title = new JLabel("<html> <div style='text-align:center;'> VIROLÓGUS <br> BUMBÓ </div></html>", JLabel.LEFT);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(Color.black);
        JLabel kep = new JLabel("", img, JLabel.CENTER);
        topText.add(title);
        topText.add(kep);


        // Define new buttons with different regions
        JButton newGameBtn = new JButton("NEW GAME");
        newGameBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        newGameBtn.setForeground(Color.black);
        JButton loadGameBtn = new JButton("LOAD GAME");
        loadGameBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        loadGameBtn.setForeground(Color.black);
        JButton exitBtn = new JButton("EXIT");
        exitBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        exitBtn.setForeground(Color.black);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.insets = new Insets(20, 10, 20, 10);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(newGameBtn,c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(loadGameBtn,c);

        c.gridx = 0;
        c.gridy = 3;
        panel.add(exitBtn,c);

        panel.setBackground(new Color(255, 0, 82));
        topText.setBackground(new Color(255, 0, 82));

        newGameBtn.setBackground(new Color(255, 0, 82));
        newGameBtn.setBorder(BorderFactory.createLineBorder(new Color(191, 255, 0), 10));
        newGameBtn.addActionListener(e -> VarazsbogyokFrame.getInstance().show("adat"));

        loadGameBtn.setBackground(new Color(255, 0, 82));
        loadGameBtn.setBorder(BorderFactory.createLineBorder(new Color(191, 255, 0), 10));
        loadGameBtn.addActionListener(e -> System.out.println("TODO"));

        exitBtn.setBackground(new Color(255, 0, 82));
        exitBtn.setBorder(BorderFactory.createLineBorder(new Color(191, 255, 0), 10));
        exitBtn.addActionListener(e -> System.exit(0));

        add(topText, BorderLayout.NORTH);
        add(panel);
        setVisible(true);
    }

}
