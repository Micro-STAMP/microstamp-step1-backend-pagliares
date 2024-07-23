package step1service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SystemSafetyConstraintAlreadyExistsException extends RuntimeException {
    public SystemSafetyConstraintAlreadyExistsException(String message){
        super(message);
    }
}
