package test;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

import game.Game;

import java.util.HashMap;
import java.util.Scanner;

/** A szkeleton működésére létrehozott teszter menü */
public class SkeletonTesterMenu implements Runnable {
    /** Parancsok, és a hozzá tartozó azonosítók,
     * később ez alapján hívjuk őket */
    private final HashMap<Integer, Runnable> commands;

    /** Menüpontok hozzáadása */
    private void init() {
        commands.put(0, TestCases::exit);
        commands.put(1, TestCases::newGame);
        commands.put(2, TestCases::endGame);
        commands.put(3, TestCases::virologistMoves);
        commands.put(4, TestCases::pickUpMaterial);
        commands.put(5, TestCases::pickUpGear);
        commands.put(6, TestCases::pickUpRecipe);
        commands.put(7, TestCases::useAgent);
        commands.put(8, TestCases::createAgent);
        commands.put(9, TestCases::rob);
        commands.put(10, TestCases::meet);
        commands.put(11, TestCases::decompose);
        commands.put(12, TestCases::winGame);
    }

    /** Konstruktor */
    public SkeletonTesterMenu() {
        commands = new HashMap<>();
        init();
    }

    /** Konzolról bekérendő adat, majd a megfelelő metódus futtatása */
    public void run() {
        int cmd;
        while(true) {
            System.out.print("Parancs: ");
            try {
                cmd = new Scanner(System.in).nextInt();
            }catch (Exception e) {
                System.out.println("Nem megfelelő bemenet!");
                continue;
            }
            if(!commands.containsKey(cmd)) {
                System.out.println("Ilyen parancs nem található!");
                continue;
            }
            commands.get(cmd).run();
        }
    }

}
