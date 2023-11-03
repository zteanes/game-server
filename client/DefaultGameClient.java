package client;

import common.Player;

/**
 * Client used for a TicTacToe game using a TCP connection that all
 * clients will extend.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public abstract class DefaultGameClient implements GameClient{
    /** default port number for the client to connect to */
    public static final int DEFAULT_PORT = 8080;

    /** default host name for the client to connect to */
    public static final String DEFAULT_HOST = "localhost";

    /** port number for the client to connect to */
    private int port;

    /** host name for the client to connect to */
    private String host;

    /** player for the client */
    private Player player;

    /**
     * Constructor for the DefaultGameClient class with a provided port number
     * and host name.
     *
     * @param port   the port number for the client to connect to
     * @param host   the host name for the client to connect to
     * @param player the player for the client
     */
    public DefaultGameClient(int port, String host, Player player) {
        this.port = port;
        this.host = host;
        this.player = player;
    }

    /**
     * Constructor for the DefaultGameClient class with a provided port number.
     *
     * @param port   the port number for the client to connect to
     * @param player the player for the client
     */
    public DefaultGameClient(int port, Player player) { this(port, DEFAULT_HOST, player); }

    /**
     * Constructor for the DefaultGameClient class with a provided host name.
     *
     * @param host   the host name for the client to connect to
     * @param player the player for the client
     */
    public DefaultGameClient(String host, Player player) { this(DEFAULT_PORT, host, player); }

    /**
     * Constructor for the DefaultGameClient class with a given player.
     *
     * @param player the player for the client
     */
    public DefaultGameClient(Player player) { this(DEFAULT_PORT, DEFAULT_HOST, player); }


    /**
     * Causes the game client to connect to the server and play the game.
     *
     * @throws GameClientException if an error occurs while connecting to the server
     */
    @Override
    public abstract void connect() throws GameClientException;

    /** Getter method for the port number */
    public int getPort() { return port; }

    /** setter method for the port number */
    public void setPort(int port) { this.port = port; }

    /** Getter method for the host name */
    public String getHost() { return host; }

    /** Setter method for the host name */
    public void setHost(String host) { this.host = host; }

    /** Getter method for the player */
    public Player getPlayer() { return player; }

    /** Setter method for the player */
    public void setPlayer(Player player) { this.player = player; }
}
