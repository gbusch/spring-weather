package weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnknownContractException extends RuntimeException{
    public UnknownContractException(String message) {super(message);}
}
