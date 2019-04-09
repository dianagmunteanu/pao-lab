package library.domain;

public class LibraryException extends RuntimeException {
    private ErrorCode errorCode;

    public LibraryException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getCode() {
        return errorCode;
    }
}
