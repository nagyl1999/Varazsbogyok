package test;

import java.io.IOException;

/*

  @ Project : Varazsbogyok
  @ Date : 2022. 03. 23.
  @ Author : nagyl

*/

public class Main {
    public static SkeletonTesterMenu menu;

    public static void main(String[] args) {
        try {
			menu = new SkeletonTesterMenu();
		} catch (IOException e){
			e.printStackTrace();
		}
        menu.run();
    }
}
