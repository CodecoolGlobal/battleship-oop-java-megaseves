package game;

import java.util.Scanner;

public class Input {

    public int getInputforMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input > 0 && input < 4) {      //  TODO:   solve hardcode , set global instead of magicnumbers
                return input;
            }
        }
    }



    private boolean validateInput() {return true;}
}
