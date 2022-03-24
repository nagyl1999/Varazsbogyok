package test;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

import java.util.HashMap;
import java.util.Scanner;

/** A szkeleton működésére létrehozott teszter menü */
public class SkeletonTesterMenu implements Runnable {
    /** Parancsok, és a hozzá tartozó azonosítók,
     * később ez alapján hívjuk őket */
    private HashMap<Integer, Runnable> commands;

    /** Konstruktor */
    public SkeletonTesterMenu() {
        commands = new HashMap<>();
        init();
    }

    /** Futtatható metódusok hozzáadása */
    private void init() {

    }

    /** Konzolról bekérendő adat, majd a megfelelő metódus futtatása */
    public void run() {
        int cmd;
        while(true) {
            try {
                cmd = new Scanner(System.in).nextInt();
                if (!commands.containsKey(cmd))
                    continue; // TODO
                commands.get(cmd).run();
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
