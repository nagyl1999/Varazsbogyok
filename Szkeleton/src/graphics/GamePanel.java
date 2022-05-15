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
	private boolean isDisabled = false;
	
    private JButton mb;
    private JButton ub;
    private JButton rb;
    private JButton cb;
    private JButton db;
    private JButton sb;
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
            if(isDisabled) {
            	temp.setEnabled(false);
            }
            temp.addActionListener(ve);
            vp.add(temp);
        }
        virologistPanel.add(vp, BorderLayout.NORTH);

        /* Effektek */
        ArrayList<Agent> agents = Game.activeVirologist.getApplied();
        JPanel ap = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (Agent a : agents) {
        	ReferenceButton temp = new ReferenceButton(a);
            if(isDisabled) {
            	temp.setEnabled(false);
            }
        	ap.add(temp);
        }
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
            if(isDisabled) {
            	temp.setEnabled(false);
            }
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
        dataPanel.add(virologistPanel);

        /* Inventory panel */
        inventoryPanel = new JPanel(new BorderLayout());
        inventoryPanel.setPreferredSize(new Dimension(500, 400));
        inventoryPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
        dataPanel.add(inventoryPanel);

        /* Parancsok panel */
        commandPanel = new JPanel(new FlowLayout());
        commandPanel.setPreferredSize(new Dimension(500, 100));
        dataPanel.add(commandPanel);

        /* Move gomb */
        mb = new JButton();
        mb.setIcon(new ImageIcon("resources/move.jpg"));
        mb.setPreferredSize(new Dimension(50, 50));
        mb.addActionListener(mc);
        mb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Use gomb */
        ub = new JButton();
        ub.setIcon(new ImageIcon("resources/use.png"));
        ub.setPreferredSize(new Dimension(50, 50));
        ub.addActionListener(new UseController());
        ub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Rob gomb */
        rb = new JButton();
        rb.setIcon(new ImageIcon("resources/rob.jpg"));
        rb.setPreferredSize(new Dimension(50, 50));
        rb.addActionListener(new RobController());
        rb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Craft gomb */
        cb = new JButton();
        cb.setIcon(new ImageIcon("resources/craft.jpg"));
        cb.setPreferredSize(new Dimension(50, 50));
        cb.addActionListener(new CraftController());
        cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Drop gomb */
        db = new JButton();
        db.setIcon(new ImageIcon("resources/drop.jpg"));
        db.setPreferredSize(new Dimension(50, 50));
        db.addActionListener(new DropController());
        db.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        /* Körlépés gomb */
        sb = new JButton();
        sb.setIcon(new ImageIcon("resources/arrow.png"));
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

    public void setDisabled(boolean disabled){
    	isDisabled=disabled;
        if(disabled){
            mapPanel.setEnabled(false);
            dataPanel.setEnabled(false);
            inventoryPanel.setEnabled(false);
            virologistPanel.setEnabled(false);

            mb.setEnabled(false);
            ub.setEnabled(false);
            rb.setEnabled(false);
            cb.setEnabled(false);
            db.setEnabled(false);
        } else {
            mapPanel.setEnabled(true);
            dataPanel.setEnabled(true);
            inventoryPanel.setEnabled(true);
            virologistPanel.setEnabled(true);
            
            mb.setEnabled(true);
            ub.setEnabled(true);
            rb.setEnabled(true);
            cb.setEnabled(true);
            db.setEnabled(true);
        }
    }

}
