package weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchPriceModelException extends RuntimeException {
    public NoSuchPriceModelException(String message) {
        super(message);
    }
}
