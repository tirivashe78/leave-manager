package zw.co.Afrosoft.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import zw.co.Afrosoft.Exceptions.FileAlreadyExistsException;
import zw.co.Afrosoft.Exceptions.RecordNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionHandlerController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error recordNotFoundError(RecordNotFoundException e) {
        LOGGER.info("Record not found error: {}", e.getMessage());
        return Error.of(400, e.getMessage());
    }

    @ExceptionHandler(FileAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error recordAlreadyExistError(FileAlreadyExistsException e) {
        LOGGER.info("File already exist error: {}", e.getMessage());
        return Error.of(400, e.getMessage());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    Error httpClientErrorException(HttpClientErrorException e) {
        LOGGER.info("Error occurred while processing request: Details {}", e.getMessage());
        return Error.of(400, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    Error handleRuntimeException(RuntimeException e) {
        LOGGER.error("Unexpected error occurred: {}", e.getMessage());
        return Error.of(500, "An unexpected error occurred: " + e.getMessage());
    }
}
