package homework20.homework20.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeDataExpetion extends RuntimeException{
    public InvalidEmployeeDataExpetion(String message) {
        super(message);
    }
}
