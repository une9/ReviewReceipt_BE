package nineproject.ReviewReceipt.common.exception;

import lombok.Getter;
import nineproject.ReviewReceipt.common.error.ErrorMessage;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidValueException extends MyException {

    public InvalidValueException(ErrorMessage msg) {
        super(HttpStatus.CONFLICT, msg);
    }
}
