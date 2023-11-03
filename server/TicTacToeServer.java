package server;

import common.TicTacToe;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Server used for a TicTacToe game using a TCP connection.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public class TicTacToeServer extends DefaultGameServer{

    /**
     * Constructor for the TicTacToeServer class with a provided port number,
     * host name, and game.
     */
    public TicTacToeServer(int port, String host, TicTacToe game) {
        super(port, host, game);
    }

    /**
     * Constructor for the TicTacToeServer class with a provided port number
     * and game.
     *
     * @param port the port number for the server to run on
     * @param game the game for the server to host
     */
    public TicTacToeServer(int port, TicTacToe game) { super(port, game); }

    /**
     * Constructor for the TicTacToeServer class with a provided host name and game.
     *
     * @param host the host name for the server to run on
     * @param game the game for the server to host
     */
    public TicTacToeServer(String host, TicTacToe game) { super(host, game); }

    /**
     * Constructor for the TicTacToeServer class with a provided game.
     *
     * @param game the game for the server to host
     */
    public TicTacToeServer(TicTacToe game) { super(game); }

    /**
     * Causes the game server to start and wait for a client to connect.
     *
     * @throws GameServerException if an error occurs while starting the server
     */
    @Override
    public void start() throws GameServerException {
        // welcome socket for the server
        try(ServerSocket welcomeSocket = new ServerSocket(getPort())){
            // create server thread arraylist
            ArrayList<ServerThread> threads = new ArrayList<>();

            // connect two different clients
            Socket client = welcomeSocket.accept();
            threads.add(new ServerThread(client, threads));
            System.out.println("Client 1 connected");
            threads.get(0).start();

            client = welcomeSocket.accept();
            threads.add(new ServerThread(client, threads));
            System.out.println("Client 2 connected");
            threads.get(1).start();

        } catch (Exception e) {
            throw new GameServerException("Error accepting client connection", e);
        }
    }
}
