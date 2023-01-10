package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * @author Sebastian Mollejas
 * 
 * This class holds all the jUnit tests created and ran...
 */
public class BoardTest{
    private Board tester;
    private Board horizontalTest;
    private Board verticalTest;
    private Board diagonalUpTest;
    private Board diagonalDownTest;
    
    @Before
    public void setup(){
        //set up for the test
        tester = new Board();
        horizontalTest = new Board();
        verticalTest = new Board();
        diagonalUpTest = new Board();
        diagonalDownTest = new Board();
    }

    @Test 
    public void initializeBoardTest() {
        char[][] expectedBoard = {
            {'\0','\0','\0','\0','\0','\0','\0'},
            {'\0','\0','\0','\0','\0','\0','\0'},
            {'\0','\0','\0','\0','\0','\0','\0'},
            {'\0','\0','\0','\0','\0','\0','\0'},
            {'\0','\0','\0','\0','\0','\0','\0'},
            {' ','\0','\0','\0','\0','\0','\0'}
        };

        char[][] actualBoard = new char[6][7];

        tester.initializeBoard();
        actualBoard = tester.getBoard();
        Assert.assertEquals(actualBoard[5][0], expectedBoard[5][0]);
    }

    @Test
    public void toStringTest(){
        String test = "\n 0 1 2 3 4 5 6\n---------------\n|\0|\0|\0|\0|\0|\0|\0|\n|\0|\0|\0|\0|\0|\0|";
        String test2 = "\0|\n|\0|\0|\0|\0|\0|\0|\0|\n|\0|\0|\0|\0|\0|\0|";
        String test3 = "\0|\n|\0|\0|\0|\0|\0|\0|\0|\n|\0|\0|\0|\0|\0|\0|\0|\n---------------\n 0 1 2 3 4 5 6\n\n";
        Assert.assertEquals(tester.toString(), test + test2 + test3);
    }

    @Test 
    public void setBoardTest() throws ValidEntry {

        char[][] expectedBoard = {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ','X',' ',' '}
        };
        
        char[][] actualBoard = new char[6][7];

        tester.initializeBoard();
        tester.setBoard(4, 'X');
        actualBoard = tester.getBoard();
        Assert.assertEquals(actualBoard[5][4], expectedBoard[5][4]);
        Assert.assertEquals(actualBoard[5][0], expectedBoard[5][0]);
        
    }

    @Test
    public void winHorizontal() throws ValidEntry {
        char[][] expectedBoard1 = {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {'X','X','X',' ',' ',' ',' '}
        };
        boolean tf = false;

        tf = horizontalTest.getWinner();
        Assert.assertEquals(tf, false);

        horizontalTest.loadingBoard(expectedBoard1);
        horizontalTest.setBoard(3, 'X');
        tf = horizontalTest.getWinner();
        Assert.assertEquals(tf, true);
    }

    @Test
    public void winVertical() throws ValidEntry {
        char[][] expectedBoard2 = {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ','X',' ',' '},
            {' ',' ',' ',' ','X',' ',' '},
            {' ',' ',' ',' ','X',' ',' '}
        };
    
        boolean tf = false;

        tf = verticalTest.getWinner();
        Assert.assertEquals(tf, false);

        verticalTest.loadingBoard(expectedBoard2);
        verticalTest.setBoard(4, 'X');
        tf = verticalTest.getWinner();
        Assert.assertEquals(tf, true);
    }

    @Test
    public void winDiagonalUp() throws ValidEntry {
        char[][] expectedBoard3 = {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ','X','O',' ',' ',' '},
            {' ','X',' ','X',' ',' ',' '},
            {'X',' ',' ','X',' ',' ',' '},
            {' ',' ',' ','O',' ',' ',' '},
            {' ',' ',' ','X',' ',' ',' '}
        };
    
        boolean tf = false;

        tf = diagonalUpTest.getWinner();
        Assert.assertEquals(tf, false);

        diagonalUpTest.loadingBoard(expectedBoard3);
        diagonalUpTest.setBoard(3, 'X');
        tf = diagonalUpTest.getWinner();
        Assert.assertEquals(tf, true);
    }

    @Test
    public void winDiagonalDown() throws ValidEntry {
        char[][] expectedBoard4 = {
            {'X',' ',' ',' ',' ',' ',' '},
            {' ','X',' ',' ',' ',' ',' '},
            {' ',' ','X',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','O',' ',' ',' '},
            {' ',' ',' ','X',' ',' ',' '}
        };
    
        boolean tf = false;

        tf = diagonalDownTest.getWinner();
        Assert.assertEquals(tf, false);

        diagonalDownTest.loadingBoard(expectedBoard4);
        diagonalDownTest.setBoard(3, 'X');
        tf = diagonalDownTest.getWinner();
        Assert.assertEquals(tf, true);
    }
    

}


