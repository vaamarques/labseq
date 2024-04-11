package lab.seq.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidNumberException extends RuntimeException {

    public InvalidNumberException(String msg){
        super(msg);
    }
}