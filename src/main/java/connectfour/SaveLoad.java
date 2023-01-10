package connectfour;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Sebastian Mollejas
 * 
 * This class holds the methods that are used when saving and loading a game of Connect 4. 
 * Firstly, you see the save function which takes the currentBoard of the game as a parameter
 * and writes the contents of that file in the correct format onto a csv file. It uses 3 symbols of 
 * 0, 1, and 2 to distinguish the symbols on the board. 0 indicates an open slot, 1 indicates a X and 2 indicates a O.
 * This will create the board on the csv file as a comma delimited matrix made up of 0s, 1s, and 2s for representation.
 * 
 * The next file loads a csv file in the same form that it is saved into 
 * the game and does the conversion of the values into 
 * their correct symbols. The game will start with this new board. 
 * With the while loop the code will go through the entire file and 
 * store the current symbol in the variable current piece. We will c
 * heck what value that currect piece is everytime and use the same 
 * logic representing each symbol to set that current index of the 2d 
 * array to that symbol, when completed the board will be full and 
 * the function returns the loaded board
 */
public class SaveLoad {
    
    private static String fileName;
    
    public static void save(char[][] currentBoard) throws FileException, IOException {
    
        fileName = TextUI.promptSaveFile();
        FileWriter fileWriter;

            try {
                fileWriter = new FileWriter(Paths.get("./assets/" + fileName).toString());
            } catch (IOException e) {
                throw new FileException("Caught");
            }

    
        for (int row = 0; row < 6; row++) {
            StringBuilder eachLine = new StringBuilder();
            for (int col = 0; col < 7; col++) {
                if (currentBoard[row][col] == 'X') {
                    eachLine.append(1);
                } else if (currentBoard[row][col] == 'O') {
                    eachLine.append(2);
                } else {
                    eachLine.append(0);
                }
                if (col != 6) {
                    eachLine.append(',');
                }
            }
            if (row != 5) {
                eachLine.append("\n");
            }
            try {
                fileWriter.write(eachLine.toString());    
            } catch (IOException e) {
                fileWriter.close(); 
                throw new FileException("Caught");
            }
        }
        fileWriter.close(); 
    }

    public static char[][] load(String loadFileName) throws FileException {
        Scanner scan;
        try {
           scan = new Scanner(new File(Paths.get("./assets/" + loadFileName).toString()));
        } catch (FileNotFoundException e) {
            throw new FileException("");
        }
        scan.useDelimiter(",|\\n");

        char[][] loadedBoard = new char[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                loadedBoard[row][col] = ' ';
            }
        }

        int row = 0;
        int col = 0;
        int currentPiece = 0;

        while (scan.hasNext()) {
            try {
                currentPiece = scan.nextInt();
            } catch (InputMismatchException e) {
                throw new FileException("Wrong file");
            }

            if (currentPiece == 0) {
                loadedBoard[row][col] = ' ';
            } else if (currentPiece == 1) {
                loadedBoard[row][col] = 'X';
            } else if (currentPiece == 2) {
                loadedBoard[row][col] = 'O';
            } else {
                throw new FileException("File format is not valid");
            }

            col++;
            if (col < 0 || col > 6) {
                col = 0;
                row++;
            } 
        }
        scan.close();
        return loadedBoard;
    }
    public String toString() {
        return "This is a string that can be printed out of the SaveLoad.java class";
    }
}
