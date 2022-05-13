package graphics;

import controller.*;
import entity.Virologist;
import game.Game;
import inventory.IStorable;
import inventory.Inventory;
import item.Agent;

import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    /**
     * Virológus event listener
     */
    public final ActionListener ve = new SetActiveVirologist();
    /**
     * Virológus event listener
     */
    public final ActionListener ie = new SetActiveItem();
    /**
     * Lépéshez szükséges kontroller
     */
    public static final Controller mc = new MoveController();

    /**
     * Konstruktor
     */
    public GamePanel() {
        super(new GridLayout(0, 2));
        init();
    }

    /**
     * Képfrissítés
     */
    public void redraw() {
        virologistPanel.invalidate();
        inventoryPanel.invalidate();
        virologistPanel.repaint();
        inventoryPanel.repaint();

        repaint();
        invalidate();

    }

    /**
     * Aktív mező virológusainak beállítása
     */
    public void setVirologistPanel() {
        /* Virológusok */
        virologistPanel.removeAll();
        ArrayList<Virologist> virologists = Game.activeVirologist.getTile().getVirologist();
        JPanel vp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (Virologist v : virologists) {

            ReferenceButton temp = new ReferenceButton(v);
            temp.addActionListener(ve);
            vp.add(temp);
        }
        virologistPanel.add(vp, BorderLayout.NORTH);

        /* Effektek */
        ArrayList<Agent> agents = Game.activeVirologist.getApplied();
        JPanel ap = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (Agent a : agents)
            ap.add(new ReferenceButton(a));
        virologistPanel.add(ap, BorderLayout.SOUTH);
    }

    /**
     * Aktív virológus inventory-jának listázása
     */
    public void setInventoryPanel() {
        inventoryPanel.removeAll();
        Inventory i = Game.activeVirologist.getInventory();
        i.reset();
        JPanel ip = new JPanel(new FlowLayout(FlowLayout.LEFT));
        while (i.hasNext()) {
            ReferenceButton temp = new ReferenceButton(i.next());
            temp.addActionListener(ie);
            ip.add(temp);
        }
        inventoryPanel.add(ip, BorderLayout.CENTER);
    }

    public void init() {
        /* Map panel */
        mapPanel = new VoronoiPanel();
        mapPanel.setBackground(Color.BLACK);

        /* Segédpanel */
        dataPanel = new JPanel();
        dataPanel.setPreferredSize(new Dimension(500, 800));
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));

        /* Virológus panel */
        virologistPanel = new JPanel(new BorderLayout());
        virologistPanel.setPreferredSize(new Dimension(500, 300));
        virologistPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        dataPanel.add(virologistPanel);

        /* Inventory panel */
        inventoryPanel = new JPanel(new BorderLayout());
        inventoryPanel.setPreferredSize(new Dimension(500, 400));
        dataPanel.add(inventoryPanel);

        /* Parancsok panel */
        commandPanel = new JPanel(new FlowLayout());
        commandPanel.setPreferredSize(new Dimension(500, 100));
        commandPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
        dataPanel.add(commandPanel);

        /* Move gomb */
        JButton mb = new JButton();
        ImageIcon imgMove = new ImageIcon( new File(System.getProperty("user.dir")).getParent() + "\\resources\\move.jpg");
        mb.setIcon(imgMove);
        mb.setPreferredSize(new Dimension(50, 50));
        mb.addActionListener(mc);
        mb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Use gomb */
        JButton ub = new JButton();
        ImageIcon imgUse = new ImageIcon( new File(System.getProperty("user.dir")).getParent() + "\\resources\\use.png");
        ub.setIcon(imgUse);
        ub.setPreferredSize(new Dimension(50, 50));
        ub.addActionListener(new UseController());
        ub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Rob gomb */
        JButton rb = new JButton();
        ImageIcon imgRob = new ImageIcon( new File(System.getProperty("user.dir")).getParent() + "\\resources\\rob.jpg");
        rb.setIcon(imgRob);
        rb.setPreferredSize(new Dimension(50, 50));
        rb.addActionListener(new RobController());
        rb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Craft gomb */
        JButton cb = new JButton();
        ImageIcon imgCraft = new ImageIcon( new File(System.getProperty("user.dir")).getParent() + "\\resources\\craft.jpg");
        cb.setIcon(imgCraft);
        cb.setPreferredSize(new Dimension(50, 50));
        cb.addActionListener(new CraftController());
        cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Drop gomb */
        JButton db = new JButton();
        ImageIcon imgDrop = new ImageIcon( new File(System.getProperty("user.dir")).getParent() + "\\resources\\drop.jpg");
        db.setIcon(imgDrop);
        db.setPreferredSize(new Dimension(50, 50));
        db.addActionListener(new DropController());
        db.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Körlépés gomb */
        JButton sb = new JButton();
        ImageIcon imgArrow = new ImageIcon( new File(System.getProperty("user.dir")).getParent() + "\\resources\\arrow.png");
        sb.setIcon(imgArrow);
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

        add(mapPanel);
        add(dataPanel);
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
            VarazsbogyokFrame.getInstance().setActiveVirologist((Virologist)((ReferenceButton) e.getSource()).getReference());
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
            VarazsbogyokFrame.getInstance().setActiveItem((IStorable) ((ReferenceButton) e.getSource()).getReference());
        }
    }

    /* Grafikus elemek */
    private VoronoiPanel mapPanel;
    private JPanel dataPanel;
    private JPanel inventoryPanel;
    private JPanel virologistPanel;
    private JPanel commandPanel;
    /* Grafikus elemek */

}
