package client;

import static server.ServerDriver.validateArgs;

/**
 * Driver class for the client of a game.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public class ClientDriver {
    public ClientDriver() {}

    /**
     * Main method for the client of a game.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // validate the args given
        validateArgs(args);
        int port = DefaultGameClient.DEFAULT_PORT;
        String host = DefaultGameClient.DEFAULT_HOST;

        // args are good, create as needed
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
            if (args.length == 2) {
                host = args[1];
            }
        }

        GameClient client = new TicTacToeClient(port, host);
        System.out.println("Client started on port " + port + " at " + host);
        try {
            client.connect();
        } catch (GameClientException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }

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

            try {
                if (args.length == 2) {
                    String host = args[1];
                }
            } catch (NumberFormatException e) {
                printUsage();
            }
        }
    }

    /**
     * Prints the usage for the program.
     */
    private static void printUsage() {
        System.err.println("Usage: java ClientDriver <game> [<port>] [<host>]");
        System.exit(1);
    }
}
