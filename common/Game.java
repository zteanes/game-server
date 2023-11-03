package common;

/**
 * Interface used for all the games to implement.
 *
 * @author Zach Eanes
 * @version 11/02/2023
 */
public interface Game {
    /**
     * Causes the game to play a turn for the given player.
     *
     * @param player the player to play the turn for
     */
    void playTurn(Player player);

    /**
     * Displays the board for the game.
     */
    void printBoard();
}
