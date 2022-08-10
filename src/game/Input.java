package game;

import java.util.Scanner;

public class Input {

    public int getInputforMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input > 0 && input < 4) {
                return input;
            }
        }
    }



    private boolean validateInput() {return true;}
}
