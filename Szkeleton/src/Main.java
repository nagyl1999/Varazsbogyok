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
        Game.newGame();
        VarazsbogyokFrame f = VarazsbogyokFrame.getInstance();
    }

}
