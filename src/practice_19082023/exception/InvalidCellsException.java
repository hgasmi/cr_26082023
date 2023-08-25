package practice_19082023.exception;

public class InvalidCellsException extends RuntimeException {
    public InvalidCellsException(String message) {
        super(message);
    }

    public InvalidCellsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCellsException(Throwable cause) {
        super(cause);
    }
}
