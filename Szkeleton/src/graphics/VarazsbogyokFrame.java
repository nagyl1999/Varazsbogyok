package graphics;

import controller.*;
import entity.Virologist;
import game.Game;
import inventory.IStorable;
import inventory.Inventory;
import item.Agent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Megjeleníthető ablak
 */
public class VarazsbogyokFrame extends JFrame {
    /**
     * Privát referencia
     */
    private static VarazsbogyokFrame vf = null;
    /**
     * Aktív virológus
     */
    private Virologist activeVirologist;
    /**
     * Aktív item
     */
    private IStorable activeItem;
    /**
     * Kirajzolandó dolgok listája
     */
    private ArrayList<IDrawable> drawables;

    /**
     * Konstruktor
     */
    private VarazsbogyokFrame() {
        super();
        drawables = new ArrayList<>();
        init();
    }

    /**
     * Példány kérése a singleton Frame-ből
     */
    public static VarazsbogyokFrame getInstance() {
        if (vf == null)
            vf = new VarazsbogyokFrame();
        return vf;
    }

    /**
     * Getter - aktív virológus
     */
    public Virologist getActiveVirologist() {
        return activeVirologist;
    }

    /**
     * Getter - aktív item
     */
    public IStorable getActiveItem() {
        return activeItem;
    }

    /**
     * Invalidálás
     */
    public void redraw() {
        jatek.setVirologistPanel();
        jatek.setInventoryPanel();
        jatek.redraw();
        jatek.revalidate();
        jatek.invalidate();
    }

    public void errorMessage(String msg){
        JOptionPane.showMessageDialog(this,msg, "Tesó...", JOptionPane.ERROR_MESSAGE);
    }

    public boolean confirmDialog(String msg){
        int result = JOptionPane.showConfirmDialog(this, msg, "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            return true;
        }
        return false;

    }

    /**
     * Komponsensek létrehozása
     */
    public void init() {
        /* JFrame */
        setSize(1000, 800);
        setResizable(false);
        setTitle("Varazsbogyok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        main.setPreferredSize(new Dimension(1000, 800));
        main.setLayout(new CardLayout());

        main.add(menu, "menu");
        main.add(adat, "adat");
        main.add(scoreboard, "scoreboard");
        main.add(jatek, "jatek");

        add(main);
        setVisible(true);
    }

    /**
     * A keresett panel megjelenítése
     *
     * @param name Panel neve
     */
    public void show(String name) {
        CardLayout c = (CardLayout) main.getLayout();
        c.show(main, name);
    }


    /**
     * Aktív virológus beállítása
     *
     * @param v Virológus
     */
    public void setActiveVirologist(Virologist v) {
        activeVirologist = v;
    }

    /**
     * Aktív item beállítása
     *
     * @param i Item
     */
    public void setActiveItem(IStorable i) {
        activeItem = i;
    }

    /* Grafikus elemek */
    private JPanel main = new JPanel();
    public MenuPanel menu = new MenuPanel();
    public AskPanel adat = new AskPanel();
    public GamePanel jatek = new GamePanel();
    public ScorePanel scoreboard = new ScorePanel();
    /* Grafikus elemek */

    public void setDisabled(boolean disabled){
        if(disabled){
            menu.setEnabled(false);
            adat.setEnabled(false);
            jatek.setDisabled(true);
            scoreboard.setEnabled(false);
        } else {
            menu.setEnabled(true);
            adat.setEnabled(true);
            jatek.setDisabled(false);
            scoreboard.setEnabled(true);
        }
    }

}
