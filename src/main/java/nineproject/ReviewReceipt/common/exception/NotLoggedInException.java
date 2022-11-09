package nineproject.ReviewReceipt.common.exception;

import lombok.Getter;
import nineproject.ReviewReceipt.common.error.ErrorMessage;
import org.springframework.http.HttpStatus;

@Getter
public class NotLoggedInException extends MyException {

    public NotLoggedInException(ErrorMessage msg) {
        super(HttpStatus.UNAUTHORIZED, msg);
    }
}
