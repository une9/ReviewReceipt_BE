package nineproject.ReviewReceipt.common.exception;

import nineproject.ReviewReceipt.common.error.ErrorMessage;
import org.springframework.http.HttpStatus;

public class LeavedUserException extends MyException{
    public LeavedUserException(ErrorMessage msg) {
        super(HttpStatus.FORBIDDEN, msg);
    }
}
