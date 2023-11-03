package client;

/**
 * Exception class for GameClient if an error occurs during connection.
 *
 * @author Zach Eanes
 * @version 11/02/2023
 */
public class GameClientException extends Exception {
    /**
     * Constructor for a GameClientException with a message and throwable object.
     *
     * @param message   the message to include in the exception
     * @param throwable the throwable object to wrap with GameClientException
     */
    public GameClientException(String message, Throwable throwable) { super(message, throwable); }

    /**
     * Constructor for a GameClientException with a message.
     *
     * @param message the message clarifying the exception
     */
    public GameClientException(String message) { super(message); }

    /**
     * Constructor for a GameClientException with a throwable object.
     *
     * @param throwable the throwable object to wrap
     */
    public GameClientException(Throwable throwable) { super(throwable); }

    /**
     * Constructor for a GameClientException with no message or wrapped throwable.
     */
    public GameClientException() { super(); }
}
