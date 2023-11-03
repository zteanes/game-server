package server;

/**
 * Exception class for GameServer if an error occurs during connection.
 *
 * @author Zach Eanes
 * @version 11/03/2023
 */
public class GameServerException extends Exception {
    /**
     * Constructor for a GameServerException with a message and throwable object.
     *
     * @param message   the message to include in the exception
     * @param throwable the throwable object to wrap with GameServerException
     */
    public GameServerException(String message, Throwable throwable) { super(message, throwable); }

    /**
     * Constructor for a GameServerException with a message.
     *
     * @param message the message clarifying the exception
     */
    public GameServerException(String message) { super(message); }

    /**
     * Constructor for a GameServerException with a throwable object.
     *
     * @param throwable the throwable object to wrap
     */
    public GameServerException(Throwable throwable) { super(throwable); }

    /**
     * Constructor for a GameServerException with no message or wrapped throwable.
     */
    public GameServerException() { super(); }
}
