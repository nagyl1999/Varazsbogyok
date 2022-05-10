import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
	
	
	private static JFrame frame;
	private JPanel mainPanel, mapPanel, rightPanel, rightTopPanel ,inventoryPanel, agentsPanel, virologistPanel ,actionsPanel;
	
	
	public ImageIcon getIcon(String Path) {
		
		ImageIcon img = new ImageIcon(Path);
		Image image = img.getImage();
		Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
		return img;
	}
	
	public Game() {

		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game");
		frame.setSize(1000,800);
		
		JPanel mainPanel = new JPanel();
		
		mainPanel.setLayout(new GridLayout(1,0));
		
		JPanel mapPanel = new JPanel();
        JPanel rightPanel = new JPanel(new GridLayout(0,1));
        
        JPanel inventoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inventoryPanel.setBackground(Color.RED);
        JPanel rightTopPanel = new JPanel();
        JPanel actionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        actionsPanel.setBackground(Color.cyan);
        
        JButton vir1, bot1, bot2, agens;
        
        vir1 = new JButton(getIcon("player.png"));
        
        bot1 = new JButton(getIcon("bot.png"));
        bot2 = new JButton(getIcon("bot.png"));
        agens = new JButton(getIcon("bear.png"));
        
        rightTopPanel.setLayout(new GridLayout(0,1));
        
        
        virologistPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        agentsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //virologistPanel.setLayout(new GridLayout(1,0));
        virologistPanel.setBackground(Color.YELLOW);
        agentsPanel.setBackground(Color.GREEN);
        //agentsPanel.setLayout(new GridLayout(1,0));
        
        virologistPanel.add(vir1);
        virologistPanel.add(bot1);
        virologistPanel.add(bot2);
        agentsPanel.add(agens);
        
        rightTopPanel.add(virologistPanel);
        rightTopPanel.add(agentsPanel);
        
        rightPanel.add(rightTopPanel);
        rightPanel.add(inventoryPanel);
        rightPanel.add(actionsPanel);
        
        JButton glove, jacket, bag, axe;
        glove = new JButton(getIcon("glove3.png"));
        jacket = new JButton(getIcon("jacket.png"));
        bag = new JButton(getIcon("bag.png"));
        axe = new JButton(getIcon("unusedAxe.png"));
        
        inventoryPanel.add(glove);
        inventoryPanel.add(jacket);
        inventoryPanel.add(bag);
        inventoryPanel.add(axe);
        
        
        JButton move, vaccine, rob, craft, place;

        move = new JButton(getIcon("move.png"));
        vaccine = new JButton(getIcon("vaccine.png"));
        rob = new JButton(getIcon("rob.png"));
        craft = new JButton(getIcon("craft.png"));
        place = new JButton(getIcon("drop.png"));
        
        /*
        actionsPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
		c.insets = new Insets(5, 5, 5, 5);
        
		c.gridx = 1;
	    c.gridy = 0;
        actionsPanel.add(move, c);
        c.gridx = 2;
	    c.gridy = 0;
        actionsPanel.add(vaccine, c);
        c.gridx = 3;
	    c.gridy = 0;
        actionsPanel.add(rob, c);
        c.gridx = 4;
	    c.gridy = 0;
        actionsPanel.add(craft, c);
        c.gridx = 5;
	    c.gridy = 0;
        actionsPanel.add(place, c);
        */
        
        actionsPanel.add(move);
        actionsPanel.add(vaccine);
        actionsPanel.add(rob);
        actionsPanel.add(craft);
        actionsPanel.add(place);
        
        
        mainPanel.add(mapPanel);
        mainPanel.add(rightPanel);
        
        frame.add(mainPanel);
        frame.setVisible(true);
		
	}
	
}
