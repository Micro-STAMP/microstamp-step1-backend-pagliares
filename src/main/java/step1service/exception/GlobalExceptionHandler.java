package step1service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

// For GLOBAL exceptions we use @ControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {
    /*
      @ExceptionHandler is an annotation used to handle the SPECIFIC exceptions and
      sending the custom responses to the client

      @TODO Note that in the employee microservice, instead of using ResourceNotFoundException as the first argument
      my implementation user Exception exception
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleGloballyResourceNotFoundException(
                                            ResourceNotFoundException resourceNotFoundException,
                                            WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                                                LocalDateTime.now(),
                                                resourceNotFoundException.getMessage(),
                                                webRequest.getDescription(false),
                                        "E-01: SystemSafetyConstraint_NOT_FOUND"
                                            );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Handle here other exceptions in addition to ResourceNotFoundException
    // Notice we return HttpStatus.INTERNAL_SERVER_ERROR and not
    // HttpStatus.BAD_REQUEST or HttpStatus.NOT_FOUND
    // You can test this exception handler by trying to save a new employee  with a POST request
    // without the body in the request on Postman, for example.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(
            Exception exception,
            WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "E-03: INTERNAL_SERVER_ERROR"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
