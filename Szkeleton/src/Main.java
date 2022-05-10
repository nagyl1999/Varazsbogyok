import game.Game;
import graphics.VarazsbogyokFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

public class Main {

    private static JFrame frame, frame2;

    public static void main(String[] args) {

            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Virológus");
            frame.setSize(700,800);

            JPanel topText = new JPanel();
            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            ImageIcon img = new ImageIcon("resource\\csillag.png");

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
            newGameBtn.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    frame2 = new JFrame();
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setTitle("Virológus PopUp");
                    frame2.setSize(300,500);

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
                    ok.addActionListener( new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            Game.newGame();
                            VarazsbogyokFrame f = VarazsbogyokFrame.getInstance();
                        }
                    });

                    cancel = new JButton("Cancel");
                    cancel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));

                    cancel.addActionListener( new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            frame2.setVisible(false);
                            frame.setVisible(true);
                        }
                    });

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
                    frame2.add(panel);

                    frame.setVisible(false);
                    frame2.setVisible(true);
                }
            });


            loadGameBtn.setBackground(new Color(255, 0, 82));
            loadGameBtn.setBorder(BorderFactory.createLineBorder(new Color(191, 255, 0), 10));

            exitBtn.setBackground(new Color(255, 0, 82));
            exitBtn.setBorder(BorderFactory.createLineBorder(new Color(191, 255, 0), 10));
            exitBtn.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });

            frame.add(topText, BorderLayout.NORTH);
            frame.add(panel);
            frame.setVisible(true);





    }

}
