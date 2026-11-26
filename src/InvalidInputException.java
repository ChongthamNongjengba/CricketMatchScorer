public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super("Invalid input provided. Please enter a valid value.");
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
