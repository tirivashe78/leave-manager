package zw.co.Afrosoft.Exceptions;

public class FileAlreadyExistsException extends RuntimeException{
    public FileAlreadyExistsException(String message) {
        super(message);
    }
}
