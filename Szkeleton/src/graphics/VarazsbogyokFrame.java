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
     * Virológus event listener
     */
    private final ActionListener ve = new SetActiveVirologist();
    /**
     * Virológus event listener
     */
    private final ActionListener ie = new SetActiveItem();
    /**
     * Lépéshez szükséges kontroller
     */
    private final Controller mc = new MoveController();

    /**
     * Konstruktor
     */
    private VarazsbogyokFrame() {
        drawables = new ArrayList<>();
        init();
        setVisible(true);
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
        setVirologistPanel();
        setInventoryPanel();
    }

    /**
     * Aktív mező virológusainak beállítása
     */
    private void setVirologistPanel() {
        /* Virológusok */
        ArrayList<Virologist> virologists = Game.activeVirologist.getTile().getVirologist();
        JPanel vp = new JPanel(new FlowLayout());
        for (Virologist v : virologists) {
            ReferenceButton temp = new ReferenceButton(v);
            temp.addActionListener(ve);
        }
        virologistPanel.add(vp, BorderLayout.NORTH);

        /* Effektek */
        ArrayList<Agent> agents = Game.activeVirologist.getApplied();
        JPanel ap = new JPanel(new FlowLayout());
        for (Agent a : agents)
            ap.add(new ReferenceButton(a));
        virologistPanel.add(ap, BorderLayout.SOUTH);
    }

    /**
     * Aktív virológus inventory-jának listázása
     */
    private void setInventoryPanel() {
        Inventory i = Game.activeVirologist.getInventory();
        i.reset();
        JPanel ip = new JPanel(new FlowLayout());
        while (i.hasNext()) {
            ReferenceButton temp = new ReferenceButton(i.next());
            temp.addActionListener(ie);
        }
        inventoryPanel.add(ip, BorderLayout.CENTER);
    }

    /**
     * Komponsensek létrehozása
     */
    public void init() {
        /* JFrame */
        setSize(1000, 800);
        setResizable(false);
        setTitle("Varazsbogyok");
        //setLayout(new BorderLayout());

        /* Game panel */
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(0, 2));

        /* Map panel */
        mapPanel = new JPanel();
        mapPanel.setPreferredSize(new Dimension(500, 800));
        add(mapPanel);

        /* Segédpanel */
        dataPanel = new JPanel();
        dataPanel.setPreferredSize(new Dimension(500, 800));
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        add(dataPanel);

        /* Virológus panel */
        virologistPanel = new JPanel(new BorderLayout());
        virologistPanel.setPreferredSize(new Dimension(500, 300));
        dataPanel.add(virologistPanel);

        /* Inventory panel */
        inventoryPanel = new JPanel(new BorderLayout());
        inventoryPanel.setPreferredSize(new Dimension(500, 400));
        dataPanel.add(inventoryPanel);

        /* Parancsok panel */
        commandPanel = new JPanel(new FlowLayout());
        commandPanel.setPreferredSize(new Dimension(500, 100));
        dataPanel.add(commandPanel);

        /* Move gomb */
        JButton mb = new JButton();
        mb.setIcon(new ImageIcon("resource\\bot.svg"));
        mb.setPreferredSize(new Dimension(50, 50));
        mb.addActionListener(mc);
        mb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Use gomb */
        JButton ub = new JButton();
        ub.setIcon(new ImageIcon("resource\\bot.svg"));
        ub.setPreferredSize(new Dimension(50, 50));
        ub.addActionListener(new UseController());
        ub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Rob gomb */
        JButton rb = new JButton();
        rb.setIcon(new ImageIcon("resource\\bot.svg"));
        rb.setPreferredSize(new Dimension(50, 50));
        rb.addActionListener(new RobController());
        rb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Craft gomb */
        JButton cb = new JButton();
        cb.setIcon(new ImageIcon("resource\\bot.svg"));
        cb.setPreferredSize(new Dimension(50, 50));
        cb.addActionListener(new CraftController());
        cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Drop gomb */
        JButton db = new JButton();
        db.setIcon(new ImageIcon("resource\\bot.svg"));
        db.setPreferredSize(new Dimension(50, 50));
        db.addActionListener(new DropController());
        db.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Körlépés gomb */
        JButton sb = new JButton();
        sb.setIcon(new ImageIcon("resource\\bot.svg"));
        sb.setPreferredSize(new Dimension(50, 50));
        sb.addActionListener(new StepController());
        sb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        /* Parancsgombok hozzáadása */
        commandPanel.add(mb);
        commandPanel.add(ub);
        commandPanel.add(rb);
        commandPanel.add(cb);
        commandPanel.add(db);
        commandPanel.add(sb);

        gamePanel.add(mapPanel);
        gamePanel.add(dataPanel);
        add(gamePanel);

    }

    /**
     * Aktív kiválasztott virológus beállítása
     */
    public class SetActiveVirologist implements ActionListener {

        /**
         * Gombnyomáskor bekövetkező esemény, virológus beállítása
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            activeVirologist = (Virologist) ((ReferenceButton) e.getSource()).getReference();
        }
    }

    /**
     * Aktív kiválasztott virológus beállítása
     */
    public class SetActiveItem implements ActionListener {

        /**
         * Gombnyomáskor bekövetkező esemény, item beállítása
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            activeItem = (IStorable) ((ReferenceButton) e.getSource()).getReference();
        }
    }

    /* Grafikus elemek */
    private JPanel gamePanel;
    private JPanel mapPanel;
    private JPanel dataPanel;
    private JPanel inventoryPanel;
    private JPanel virologistPanel;
    private JPanel commandPanel;

}
