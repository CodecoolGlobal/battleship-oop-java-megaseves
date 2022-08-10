package game;

import java.util.Scanner;

public class Input {
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public int getInputforMenu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input > 0 && input < 4) {      //  TODO:   solve hardcode , set global instead of magicnumbers
                return input;
            }
        }
    }

    public int[] getShipPlacement(){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                char firstPartInput = Character.toUpperCase(input.charAt(0));
                int secondPartInput = Integer.parseInt(input.substring(1));
                int firstConvertedCoord = alphabet.indexOf(firstPartInput);
                int secondConvertedCoord = secondPartInput - 1;
                if (firstConvertedCoord < 10 && firstConvertedCoord > 0 && secondConvertedCoord < 10){ //Todo make it dynamic, add table size
                    return new int[]{firstConvertedCoord, secondConvertedCoord};
                }
                System.out.println("Invalid input"); //Todo remove print from here
            } catch (Exception ignored){
                System.out.println("Invalid input"); //Todo remove print from here
            }
        }
    }

    private boolean validateInput() {return true;}
}
