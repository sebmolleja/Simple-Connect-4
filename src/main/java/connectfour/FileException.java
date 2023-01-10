package connectfour;

/**
 * @author Sebastian Mollejas
 * 
 * This class is a custom exception class which will be thrown whenever we are dealing with any file exception
 * meaning wrong file format when loading or incorrect file extensions or names.
 */
class FileException extends Exception {

    FileException(String s) {
        super(s);
    }

    public String toString() {
        return "This is a string that can be printed out of the FileException class";
    }
}
