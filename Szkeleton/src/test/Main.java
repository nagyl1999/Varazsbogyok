package test;/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

import test.SkeletonTesterMenu;

public class Main {
    public static SkeletonTesterMenu menu;

    public static void main(String[] args) {
        menu = new SkeletonTesterMenu();
        System.out.println("Hello World!");
        menu.run();
    }
}
