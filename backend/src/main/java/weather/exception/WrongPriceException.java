package weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongPriceException extends RuntimeException {
    public WrongPriceException(String message) {
        super(message);
    }
}
