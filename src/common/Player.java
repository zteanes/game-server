package common;
/**
 * This class is used to identify and store information about a player for a game.
 *
 * @author Zach Eanes
 * @version 11/02/2023
 */
public class Player {
    /** The name of the player */
    private String name;

    /** the number of the player */
    private int num;

    /** Default name of the player */
    private static final String DEFAULT_NAME = "Player";

    /** piece for the game that the player is playing */
    private Object piece;

    /**
     * Constructor for the player class with a given name and number.
     *
     * @param name  name of the player
     * @param num   the number of the player
     * @param piece piece for the game that the player is playing
     */
    public Player(String name, int num, Object piece) {
        this.name = name;
        this.num = num;
        this.piece = piece;
    }

    /**
     * Constructor for the player class with a given number and piece.
     *
     * @param num   number of the player
     * @param piece piece for the game that the player is playing
     */
    public Player(int num, Object piece) { this(DEFAULT_NAME, num, piece); };

    /** Returns the name of the player */
    public String getName() { return this.name; }

    /* Sets the name of the player */
    public void setName(String name) { this.name = name; }

    /* Returns the number of the player */
    public int getNum() { return this.num; }

    /* Sets the number of the player */
    public void setNum(int num) { this.num = num; }

    /* Returns the piece of the player */
    public Object getPiece() { return this.piece; }

    /* Sets the piece of the player */
    public void setPiece(Object piece) { this.piece = piece; }
}