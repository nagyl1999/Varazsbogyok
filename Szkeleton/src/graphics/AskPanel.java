package graphics;

import game.Game;
import game.Tile;

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
     * Játék indítása
     */
    public void startGame() {
        int tiles = Integer.parseInt(tileTF.getValue().toString());
        int bots = Integer.parseInt(botTF.getValue().toString());
        if (tiles < Game.minTileCount || bots < Game.minBotCount)
            return; // TODO - hibakezelés
        // TODO - loading menu mutatása

        Game.tileCount = tiles;
        Game.botCount = bots;
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Game.newGame();
        VarazsbogyokFrame.getInstance().show("jatek");
    }

    /**
     * Komponensek létrehozása
     */
    private void init() {
        setLayout(new CardLayout());
        JPanel main = new JPanel(new GridBagLayout());
        JPanel load = new JPanel();

        load.add(new JLabel("<html> <div style='text-align:center;'>Loading...</div></html>", SwingConstants.CENTER));

        JButton ok, cancel;
        JLabel tile, bot;
        setPreferredSize(new Dimension(1000, 800));

        tile = new JLabel("<html> <div style='text-align:center;'> Number of Fields: </div></html>", SwingConstants.CENTER);
        tile.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        SpinnerModel model = new SpinnerNumberModel(Game.minTileCount, Game.minTileCount, 1000, 1);
        tileTF = new JSpinner(model);

        bot = new JLabel("<html>Number of Bots: </html>", SwingConstants.CENTER);
        bot.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        model = new SpinnerNumberModel(Game.minBotCount, Game.minBotCount, 100, 1);
        botTF = new JSpinner(model);

        ok = new JButton("Ok");
        ok.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        ok.addActionListener(e -> startGame());
     
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
        
        add(main, "main");
        add(load, "load");
        setVisible(true);
    }
    
   

    private JSpinner botTF;
    private JSpinner tileTF;

}
