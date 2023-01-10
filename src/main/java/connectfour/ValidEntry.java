package connectfour;

/**
 * @author Sebastian Mollejas
 * 
 * This class is a custom exception class which will be 
 * thrown whenever we are dealing with user input exceptions of any sort
 */
class ValidEntry extends Exception {

    ValidEntry(String s) {
        super(s);
    }

    public String toString() {
        return "This is a string that can be printed out of the ValidEntry.java class";
    }
}
