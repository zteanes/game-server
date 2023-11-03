package server;

import common.Player;
import common.TicTacToe;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Driver for the game server.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public class ServerDriver {
    public ServerDriver() {}

    /**
     * Main method for the game server.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // validate the args given
        validateArgs(args);
        int port = DefaultGameServer.DEFAULT_PORT;
        String host = DefaultGameServer.DEFAULT_HOST;

        // args are good, create as needed
        if(args.length > 0) {
            port = Integer.parseInt(args[0]);
            if (args.length == 2) {
                host = args[1];
            }
        }

        GameServer server = new TicTacToeServer(port, host, new TicTacToe());
        System.out.println("Server started on port " + port + " at " + host);
        try {
            server.start();
        } catch (GameServerException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    /**
     * Validates the command line arguments.
     *
     * @param args command line arguments
     */
    private static void validateArgs(String[] args) {
        if (args.length > 2) {
            printUsage();
        }

        if (args.length == 1 || args.length == 2) {
            try {
                int port = Integer.parseInt(args[0]);
                if (port < 0 || port > 65535) {
                    System.err.println("Invalid port number provided: " + port + ".");
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                printUsage();
            }

            try{
                InetAddress address = InetAddress.getByName(args[1]);
            }catch (UnknownHostException uhe){
                System.err.println("Invalid host name provided: " + args[1] + ".");
                printUsage();
            }
        }
    }

    /**
     * Prints the usage message for the program and exits.
     */
    private static void printUsage() {
        System.err.println("Usage: java ServerDriver [<port>] [<host>]");
        System.exit(1);
    }
}
