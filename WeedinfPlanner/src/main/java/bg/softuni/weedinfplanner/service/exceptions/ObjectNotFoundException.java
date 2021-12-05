package bg.softuni.weedinfplanner.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Resource not found!")
public class ObjectNotFoundException extends RuntimeException{
}
