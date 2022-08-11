package game;

import java.util.Scanner;

public class Input {
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final Display display = new Display();


    public int getInputforMenu() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if (input > 0 && input < 4) {      //  TODO:   solve hardcode , set global instead of magicnumbers
                    return input;
                }
            } catch (Exception e){
                display.printInvalidInput();
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
                if (firstConvertedCoord < 10 && firstConvertedCoord >= 0 && secondConvertedCoord < 10 && secondConvertedCoord >= 0){
                    return new int[]{firstConvertedCoord, secondConvertedCoord};
                }
                display.printInvalidInput();
            } catch (Exception ignored){
                display.printInvalidInput();
            }
        }
    }

    public int getShipPlacementWay(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try{
                int input = scanner.nextInt();
                if (input > 0 && input < 5) {
                    return input;
                }
                display.printInvalidInput();
            } catch (Exception e){
                display.printInvalidInput();
            }
        }
    }

    private boolean validateInput() {return true;}

    public String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
