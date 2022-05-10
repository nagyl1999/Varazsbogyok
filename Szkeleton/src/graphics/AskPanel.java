package graphics;

import javax.swing.*;
import java.awt.*;

/**
 * A játék elkezdéséhez szükséges adatok
 * bekéréséért felelős panel
 */
public class AskPanel extends JPanel {

    /**
     * Konstruktor
     */
    public AskPanel() {
        super();
        init();
    }

    /**
     * Komponensek létrehozása
     */
    private void init() {
        JButton ok, cancel;
        JLabel tile, bot;
        JSpinner tileTF, botTF;
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        tile = new JLabel("<html> <div style='text-align:center;'> Hány mezõ legyen <br> a pályán: </div></html>", SwingConstants.CENTER);
        tile.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        tileTF = new JSpinner();

        bot = new JLabel("<html>Hány Bot legyen: </html>", SwingConstants.CENTER);
        bot.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        botTF = new JSpinner();

        ok = new JButton("Ok");
        ok.setFont(new Font("Comic Sans MS", Font.BOLD, 25));

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.insets = new Insets(10, 1, 10, 40);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(tile,c);

        c.gridx = 1;
        c.gridy = 0;
        panel.add(tileTF,c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(bot,c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(botTF,c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(ok,c);

        c.gridx = 1;
        c.gridy = 2;
        panel.add(cancel,c);

        panel.setBackground(Color.pink);
        setVisible(true);
    }

}
