package connectfour;

/**
 * @author Sebastian Mollejas
 * 
 * This class handles everything that is related to the Board of the game. 
 * The board is what the users will be playing on
 * meaning you will find things such Creation of a board, initializing, 
 * and loading the board in this class.
 * Along with this, the class includes creating a string to print the board,
 *  sets and updates pieces to the board, checking how many
 * slots are used up on the board, and checking and retrieving if there is a winner.
 */
public class Board {

    private char[][] board = new char[6][7];
    private int depth = 0;
    private boolean checkWinner;
    
    /**
     * The initializeBoard() method simply sets all indexes of the
     * board to a empty char character for reference in the future.
     * 
     * @param n/a
     * @return none
     */
    public void initializeBoard() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = ' ';
            }
        }
    }

    /**
     * This method passes a board and sets the contents of the board that is used in the game
     * with another board that already has pieces in it, typically used when loading an existing game.
     * 
     * @param loadedBoard returns a matrix as a board that is loaded with pieces
     * @return n/a
     */
    public void loadingBoard(char[][] loadedBoard) {
        board = loadedBoard;
    }
    
    /**
     * the toString() method which is required to create a string that prints the board 
     * that will visualize the game.
     * 
     * @param n/a
     * @return return a string which hold the board to print in the console
     */
    public String toString() {
        
        StringBuilder str = new StringBuilder();
        String boardString = "";
        
        str.append("\n 0 1 2 3 4 5 6\n");
        str.append("---------------\n");
        
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                str.append("|");
                str.append(board[row][col]);
            }
            str.append("|\n");
        }
        str.append("---------------\n");
        str.append(" 0 1 2 3 4 5 6\n\n");
        
        boardString = str.toString();
        
        return boardString;
    }
    
    /**
     * The setBoard class is the class that will update the board when a user chooses a slot
     * It traverses the entire matrix, from the bottom up as the game would and updates the game to the
     * piece that is chosen by the user. Along with this we call the setWinner method in this class 
     * as it makes sense to update the board then check if there is 4 in a row of the same piece after each
     * update.
     * 
     * @param colPosition this is the column position that is passed from the user input
     * @param playerTurn this is the player turn which holds the two pieces so we know what piece to update the board to
     * @throws ValidEntry throws our custom exception to check the user input on each move
     * @return n/a
     */
    public void setBoard(int colPosition, char playerTurn) throws ValidEntry {
        boolean flag = true;

        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][colPosition] == ' ') {
                board[row][colPosition] = playerTurn;
                flag = false;
                break;
            } 
        }
        if (flag) {
            throw new ValidEntry("This col is full");
        }
        
        setWinner(playerTurn);
    }

    /**
     * This class returns a board
     * 
     * @return board returns a current board which is a 2d array
     */
    public char[][] getBoard() {
        return board;
    }
    
    /**
     * This class increments the depth variable when called, it will track how far we are into the game
     */
    public void setDepth() {
        depth++;
    }

    /**
     * this class will get the current depth of the game which is stored in an int variable
     * @return depth an int which returns the value of how many turns have when by in the game
     */
    public int getDepth() {
        return depth;
    }

   
    private void setWinner(char playerTurn) {
        for (int row = 0; row < board.length; row++) { // check horizontal
            for (int col = 0; col < board[row].length - 3; col++) {
                if (board[row][col] == playerTurn
                 && board[row][col + 1] == playerTurn
                 && board[row][col + 2] == playerTurn 
                 && board[row][col + 3] == playerTurn) {
                    checkWinner = true;
                    return;
                }
            }
        }
        // checking vertical pieces
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == playerTurn
                 && board[row + 1][col] == playerTurn
                 && board[row + 2][col] == playerTurn 
                 && board[row + 3][col] == playerTurn) {
                    checkWinner = true;
                    return;
                }
            }
        }
        // checking diagonal up
        for (int row = 3; row < board.length; row++) {
            for (int col = 0; col < board[row].length - 3; col++) {
                if (board[row][col] == playerTurn
                 && board[row - 1][col + 1] == playerTurn
                 && board[row - 2][col + 2] == playerTurn 
                 && board[row - 3][col + 3] == playerTurn) {
                    checkWinner = true;
                    return;
                }
            }
        }
        // checking diagonal down 
        for (int row = 0; row < board.length - 3; row++) {
            for (int col = 0; col < board[row].length - 3; col++) {
                if (board[row][col] == playerTurn
                 && board[row + 1][col + 1] == playerTurn
                 && board[row + 2][col + 2] == playerTurn 
                 && board[row + 3][col + 3] == playerTurn) {
                    checkWinner = true;
                    return;
                }
            }
        }
        checkWinner = false;
    }

    /**
     *  
     * 
     * This will get a boolean variable of the winner, if it was false meaning no winner
     * or if it was true, there is a winner. This is done from the private function which check for 
     * a winner in 4 ways:
     * horizontal check, vertical check, diagonal up check, diagonal down check
     *
     * @return getWinner a boolean value indicating if there was a winner.
     */
    public boolean getWinner() {
        return checkWinner;
    }
}