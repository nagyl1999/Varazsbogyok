import game.Game;
import graphics.VarazsbogyokFrame;

import java.io.IOException;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

public class Main {

    public static void main(String[] args) {
        Game.newGame();
        VarazsbogyokFrame f = VarazsbogyokFrame.getInstance();
    }

}
