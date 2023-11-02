package client;

/**
 * Interface for all game clients to implement.
 *
 * @author Zach Eanes
 * @version 11/02/2023
 */
public interface GameClient {
    /**
     * Causes the game client to connect to the server and play the game.
     *
     * @throws GameClientException if an error occurs while connecting to the server
     */
    void connect() throws GameClientException;
}
