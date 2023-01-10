package connectfour;

import java.io.IOException;


/**
 * @author Sebastian Mollejas
 * 
 * In this class there is the ConnectFour class along with the main where we run the game.
 *  In the connect four class there are two 
 * methods which include setting the turn of each player and switching between them
 *  and well as the accessor to this class in getTurn().
 * Apart from this in the main, majority of functionality is done as methods
 * are called to update the state fo the board, asking the 
 * baord whether a win has been detected printing everything through the TEXTUI calls.
 */
public class ConnectFour{

    private char playerTurn = 'X';

    public void setTurn(char turn) { // switch turns
        if (turn == 'X') {
            turn = 'O';
        } else {
            turn = 'X';
        }
        playerTurn = turn;
    }

    public char getTurn() {
        return playerTurn;
    }

    public void play(Board board, ConnectFour gameplay) throws FileException, IOException {

        int position;
        char saveOption;
    
        TextUI.boardPrint(board);
        TextUI.startPlayer();

        while (!board.getWinner() && board.getDepth() < 42) {

            try {
                do {
                    saveOption = TextUI.promptSave();
                } while (saveOption != 'y' && saveOption != 'n');
    
                if (saveOption == 'y') {
                    SaveLoad.save(board.getBoard());
                    System.exit(0);
                } else {
    
                    do {
                        position = TextUI.userInput();
                    } while (position < 0 || position > 6);
                    
                    board.setDepth();
                    
                    board.setBoard(position, gameplay.getTurn());
                    if (board.getWinner()) {
                        TextUI.boardPrint(board);
                        TextUI.winnerMessage();
                        System.exit(0);
                    } else if (board.getDepth() == 42) {
                        TextUI.boardPrint(board);
                        TextUI.tieMessage();
                        System.exit(0);
                    } else {
                        TextUI.boardPrint(board);
                        gameplay.setTurn(gameplay.getTurn());
                    }
                    TextUI.trackPlayer(gameplay.getTurn());
                }
            } catch (ValidEntry e) {
                continue;
            }
        }
    }

    public static void main(String[] args) throws FileException, IOException {
        char loadOption = ' ';
        String loadFileName;
    
        ConnectFour game = new ConnectFour();
        Board board = new Board();
    
        do {
            try {
                loadOption = TextUI.promptLoad();
            
            if (loadOption == 'y') {
                loadFileName = TextUI.promptLoadFile();
                board.loadingBoard(SaveLoad.load(loadFileName));    
                
                game.play(board, game);
            } else {
                board.initializeBoard();
                game.play(board, game);
            }
        } catch(ValidEntry | FileException | IOException e) {
            TextUI.errorMssg("Invalid file...");
            continue;
        } 
        } while (loadOption != 'y' && loadOption != 'n');
    }

    public String toString() {
        return "This is a string that can be printed out of the ConnectFour.java";
    }
}

