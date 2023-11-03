package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Thread for the server to run on in order to handle multiple clients.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public class ServerThread extends Thread{
    /** The socket for the server to run on. */
    private Socket socket;

    /** list of all threads currently running */
    private ArrayList<ServerThread> threads;

    /** output for the server to send to the client */
    private PrintWriter out;

    /**
     * Constructor for the ServerThread class with a provided socket and list of threads.
     *
     * @param socket the socket for the server to run on
     * @param threads list of all threads currently running
     */
    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threads = threads;
    }

    /**
     * Causes the server thread to run.
     */
    @Override
    public void run() {
        try {
            // read input from the client
            BufferedReader in = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));

            // create our output stream
            out = new PrintWriter(socket.getOutputStream(), true);

            boolean gameOver = false;
            // loop for the server to run on
            while (!gameOver) {
                // read input from the client
                String input = in.readLine();

                // if the client disconnects, break out of the loop
                if (input == null) {
                    break;
                }

                // send the message to every client
                sendAll(input);
            }
        } catch (Exception e) {
            System.out.println("Error creating output stream");
        }
    }

    /**
     * Sends a message to the client.
     *
     * @param message the message to send to the client
     */
    public void send(String message) { out.println(message); }

    /**
     * Sends a message to every client in the thread.
     *
     * @param message the message to send to every client
     */
    public void sendAll(String message) {
        for (ServerThread thread : threads) {
            thread.send(message);
        }
    }
}
