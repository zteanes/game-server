package client;

import common.Player;

/**
 * Client used for a TicTacToe game using a TCP connection.
 *
 * @author Zach Eanes
 * @version 11/02/2023
 */
public class TicTacToeClient extends DefaultGameClient {
    /**
     * Constructor for the TicTacToeClient class with a provided port number
     * and host name.
     *
     * @param port   the port number for the client to connect to
     * @param host   the host name for the client to connect to
     * @param player the player for the client
     */
    public TicTacToeClient(int port, String host, Player player) { super(port, host, player);}

    /**
     * Constructor for the TicTacToeClient class with a provided port number.
     *
     * @param port   the port number for the client to connect to
     * @param player the player for the client
     */
    public TicTacToeClient(int port, Player player) { super(port, player); }

    /**
     * Constructor for the TicTacToeClient class with a provided host name.
     *
     * @param host   the host name for the client to connect to
     * @param player the player for the client
     */
    public TicTacToeClient(String host, Player player) { super(host, player); }

    /**
     * Constructor for the TicTacToeClient class with a given player.
     *
     * @param player the player for the client
     */
    public TicTacToeClient(Player player) { super(player); }

    /**
     * Causes the game client to connect to the server and play the game.
     *
     * @throws GameClientException if an error occurs while connecting to the server
     */
    @Override
    public void connect() throws GameClientException {


    }
}
