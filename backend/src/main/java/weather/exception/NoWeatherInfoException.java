package weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class NoWeatherInfoException extends RuntimeException {
    public NoWeatherInfoException (String message) {super(message);}
}
