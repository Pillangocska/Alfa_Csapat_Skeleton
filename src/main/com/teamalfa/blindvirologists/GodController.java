package main.com.teamalfa.blindvirologists;

import java.util.Scanner;

public class GodController {
    //das ist kurvanagy class lesz



    public static String readInput(String msg) {
        System.out.println(msg);
        return new Scanner(System.in).nextLine();
    }

    public static boolean askYesOrNo(String msg) {
        // Returns true if user answered yes.
        String question = msg + " (y/n)";
        while(true) {
            switch(readInput(question)) {
                case "y": return true;
                case "n": return false;
            }
        }
    }
}
