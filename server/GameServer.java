package server;

/**
 * Interface for all game servers to implement.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public interface GameServer {

    /**
     * Causes the game server to start and wait for a client to connect.
     *
     * @throws GameServerException if an error occurs while starting the server
     */
    void start() throws GameServerException;
}
