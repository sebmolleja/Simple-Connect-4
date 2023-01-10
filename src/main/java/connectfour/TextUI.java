package connectfour;

import java.util.Scanner;

/**
 * @author Sebastian Mollejas
 * 
 * This class handles all the user input and print statement that occur in the entire program, 
 * every prompt from the user is done here and all the scanning of input and handinling is done in its own method
 * due to this there will be a lot of exception handling that 
 * can be see done in each method, this is where valid entry exceptions and 
 * file exceptions are thrown along with the instance of the calls in the other classes. 
 */
public class TextUI{

    private static Scanner sc = new Scanner(System.in);
    private static Scanner test = new Scanner(System.in);
    private static Scanner test2 = new Scanner(System.in);
    private static Scanner saveInput = new Scanner(System.in);
    private static Scanner loadInput = new Scanner(System.in);
    private static String position;
    private static int posNum;
    private static char saveOption;
    private static char loadOption;
    private static String saveFileName;
    private static String loadFileName;
    

    public static void boardPrint(Board b) {
        System.out.print(b);
    }

    public static int userInput() throws ValidEntry {
        System.out.println("Enter position between 0 and 6: ");
        position = sc.nextLine();

        try {
            posNum = Integer.parseInt(position);
        } catch (NumberFormatException e) {
            throw new ValidEntry("NAN");
        }

        return posNum;
    }

    public static char promptSave() throws ValidEntry {
        System.out.println("Would you like to save your game? (y or n)");
        saveOption = test.next().charAt(0);

        if (saveOption != 'y' && saveOption != 'n') {
            throw new ValidEntry("That was not a valid entry");
    }

        return saveOption;
    }

    public static char promptLoad() throws ValidEntry {
        System.out.println("Would you like to load an existing game? (y or n)");
        loadOption = test2.next().charAt(0);

        if (loadOption != 'y' && loadOption != 'n') {
                throw new ValidEntry("That was not a valid entry");
        }

        return loadOption;
    }

    public static String promptSaveFile() {
        System.out.println("Enter the name of your csv file: ");
        saveFileName = saveInput.nextLine();
        return saveFileName;
    }

    public static String promptLoadFile() {
        System.out.println("Enter the name of the csv file you want to load: ");
        loadFileName = loadInput.nextLine();
        return loadFileName;
    }

    public static void startPlayer() {
        System.out.println("Turn = X");
    }

    public static void trackPlayer(char player) {
        System.out.println("Turn = " + player);
    }

    public static void winnerMessage() {
        System.out.println("Winner Winner Chicken Dinner!");
    }

    public static void tieMessage() {
        System.out.println("Tie!");
    }

    public static void errorMssg(String s) {
        System.out.println(s);
    }

    public String toString() {
        return "This is a string that can be printed out of the TextUI class";
    }
}