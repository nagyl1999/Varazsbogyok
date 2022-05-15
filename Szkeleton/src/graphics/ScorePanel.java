package graphics;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * A játék legjobb játékosait megjelenítő táblázata
 */
public class ScorePanel extends JPanel {

    private ArrayList<JLabel> txts = new ArrayList<JLabel>();
    /**
     * Konstruktor
     */
    public ScorePanel() {
        super(new BorderLayout());
        init();
    }

    private JLabel createLabel(String text){
        JLabel temp = new JLabel(text);
        temp.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        temp.setForeground(Color.black);
        return temp;
    }

    /**
     * Komponensek létrehozása
     */
    private void init() {


        JPanel topText = new JPanel();
        JPanel panel = new JPanel();
        JPanel bottonPanel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        ImageIcon img = new ImageIcon("resources\\csillag.jpg");

        JLabel title = new JLabel("<html> <div style='text-align:center;'> VIROLÓGUS <br> BUMBÓ</div></html>", JLabel.LEFT);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(Color.black);
        JLabel kep = new JLabel("", img, JLabel.CENTER);
        topText.add(title);
        topText.add(kep);

        panel.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel topScoreText = new JLabel("SCOREBOARD");
        txts.add(createLabel("Green"));
        txts.add(createLabel("Green"));
        txts.add(createLabel("Green"));
        txts.add(createLabel("Green"));
        txts.add(createLabel("Green"));
        JButton BackBtn = new JButton("Back");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 1;
        panel.add(createLabel("User"),c);

        c.gridx = 2;
        panel.add(createLabel("Score"),c);

        int counter = 1;

        for (JLabel txt : txts){

            c.gridx = 0;
            c.gridy = counter;
            panel.add(createLabel(counter + "."),c);

            c.gridx = 1;
            panel.add(txt,c);

            c.gridx = 2;
            c.gridy = counter++;

            panel.add(createLabel("999999999999"),c);
        }


        Color bestColor = new Color(255, 0, 82);

        BackBtn.setBackground(bestColor);
        BackBtn.setBorder(BorderFactory.createLineBorder(new Color(191, 255, 0), 10));
        BackBtn.addActionListener(e -> VarazsbogyokFrame.getInstance().show("menu"));
        BackBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        BackBtn.setForeground(Color.black);

        bottonPanel.add(BackBtn);

        panel.setBackground(bestColor);
        topText.setBackground(bestColor);
        bottonPanel.setBackground(bestColor);

        add(topText, BorderLayout.NORTH);
        add(panel);
        add(bottonPanel,BorderLayout.SOUTH);

        setBackground(Color.pink);
        setVisible(true);
    }

}
