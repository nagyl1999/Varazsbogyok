package test;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

import java.util.HashMap;

/** A szkeleton működésére létrehozott teszter menü */
public class SkeletonTesterMenu {
    /** Parancsok, és a hozzá tartozó azonosítók,
     * később ez alapján hívjuk őket */
    private HashMap<Integer, Runnable> commands;

    /** Konstruktor */
    public SkeletonTesterMenu() {
        commands = new HashMap<>();
    }

    /** Konzolról bekérendő adat, majd a megfelelő metódus futtatása */
    public void run() {
    }

}
