package finki.emt.emt_lv1_201115.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidBookIdException extends RuntimeException{

    public InvalidBookIdException(Long id) {
        super(String.format("Book with id %d doesn't exist", id));
    }
}
