package graphics;

import game.Game;

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
        setLayout(new CardLayout());

        JPanel main = new JPanel(new GridBagLayout());
        JPanel load = new JPanel();

        JButton ok, cancel;
        JLabel tile, bot;
        JSpinner tileTF, botTF;
        setPreferredSize(new Dimension(1000, 800));

        load.add(new JLabel("<html> <div style='text-align:center;'> Hány mezõ legyen <br> a pályán: </div></html>", SwingConstants.CENTER));

        tile = new JLabel("<html> <div style='text-align:center;'> Number of Fields : </div></html>", SwingConstants.CENTER);
        tile.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        SpinnerModel model = new SpinnerNumberModel(100, Game.minTileCount, 1000, 1);
        tileTF = new JSpinner(model);

        bot = new JLabel("<html>Number of Bots: </html>", SwingConstants.CENTER);
        bot.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        model = new SpinnerNumberModel(5, Game.minBotCount, 100, 1);
        botTF = new JSpinner(model);

        ok = new JButton("Ok");
        ok.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        ok.addActionListener(e -> {
            int tiles = Integer.parseInt(tileTF.getValue().toString());
            int bots = Integer.parseInt(botTF.getValue().toString());
            if (tiles < Game.minTileCount || bots < Game.minBotCount)
                return; // TODO - hibakezelés
            Game.tileCount = tiles;
            Game.botCount = bots;
            Game.newGame();
            VarazsbogyokFrame.getInstance().show("jatek");
        });

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        cancel.addActionListener(e -> VarazsbogyokFrame.getInstance().show("menu"));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.insets = new Insets(10, 1, 10, 40);

        c.gridx = 0;
        c.gridy = 0;
        main.add(tile,c);

        c.gridx = 1;
        c.gridy = 0;
        main.add(tileTF,c);

        c.gridx = 0;
        c.gridy = 1;
        main.add(bot,c);

        c.gridx = 1;
        c.gridy = 1;
        main.add(botTF,c);

        c.gridx = 0;
        c.gridy = 2;
        main.add(ok,c);

        c.gridx = 1;
        c.gridy = 2;
        main.add(cancel,c);

        main.setBackground(Color.pink);
        load.setBackground(Color.pink);

        add(main);
        add(load);

        setBackground(Color.pink);
        setVisible(true);
    }

}
