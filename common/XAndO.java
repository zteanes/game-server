package common;

/**
 * Representation for the X's and O's in a tic-tac-toe game.
 *
 * @author Zach Eanes
 * @version 11/02/2023
 */
public enum XAndO {
    X("X"), /** x */
    O("O"), /** o */
    EMPTY(" "); /** empty */

    /** string representation of the enum */
    private final String string;

    /**
     * Constructor for the enum.
     *
     * @param string the string representation of the enum
     */
    XAndO(String string) { this.string = string; }

    /**
     * Returns the string representation of the enum.
     *
     * @return the string representation of the enum
     */
    public String toString() { return string; }
}