package finki.emt.emt_lv1_201115.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoneCopiesOfBookLeftException extends RuntimeException{
    public NoneCopiesOfBookLeftException() {
        super(String.format("There are no copies avaible from this book"));
    }

}
