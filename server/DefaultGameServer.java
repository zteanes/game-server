package server;

import common.Game;
/**
 * Default implementation of a GameServer every server created will extend.
 * Provides basic logic and functionality for port, host name, the game, and
 * more.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public abstract class DefaultGameServer implements GameServer{
    /** Default port number for the server to run on. */
    public static final int DEFAULT_PORT = 8080;

    /** Default host name for the server to run on. */
    public static final String DEFAULT_HOST = "localhost";

    /** The port number for the server to run on. */
    private int port;

    /** The host name for the server to run on. */
    private String host;

    /** The game that the server is running. */
    private Game game;

    /**
     * Constructor for the DefaultGameServer class with a provided port number,
     * host name, and game.
     *
     * @param port the port number for the server to run on
     * @param host the host name for the server to run on
     * @param game the game for the server to host
     */
    public DefaultGameServer(int port, String host, Game game) {
        this.port = port;
        this.host = host;
        this.game = game;
    }

    /**
     * Constructor for the DefaultGameServer class with a provided port number
     * and game.
     *
     * @param port the port number for the server to run on
     * @param game the game for the server to host
     */
    public DefaultGameServer(int port, Game game) { this(port, DEFAULT_HOST, game); }

    /**
     * Constructor for the DefaultGameServer class with a provided host name and game.
     *
     * @param host the host name for the server to run on
     * @param game the game for the server to host
     */
    public DefaultGameServer(String host, Game game) { this(DEFAULT_PORT, host, game); }

    /**
     * Constructor for the DefaultGameServer class with a provided game.
     *
     * @param game the game for the server to host
     */
    public DefaultGameServer(Game game) { this(DEFAULT_PORT, DEFAULT_HOST, game); }

    /**
     * Causes the game server to start and wait for a client to connect.
     *
     * @throws GameServerException if an error occurs while starting the server
     */
    @Override
    public abstract void start() throws GameServerException;

    /** Getter method for the port. */
    public int getPort() { return this.port; }

    /* Setter method for the port. */
    public void setPort(int port) { this.port = port; }

    /** Getter method for the host name. */
    public String getHost() { return this.host; }

    /** Setter method for the host name. */
    public void setHost(String host) { this.host = host; }

    /** Getter method for the game. */
    public Game getGame() { return this.game; }

    /** Setter method for the game. */
    public void setGame(Game game) { this.game = game; }
}
