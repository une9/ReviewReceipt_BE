package nineproject.ReviewReceipt.common.exception;

import lombok.Getter;
import nineproject.ReviewReceipt.common.error.ErrorMessage;
import org.springframework.http.HttpStatus;

@Getter
public class NullValueException extends MyException {

    public NullValueException(ErrorMessage errMsg) {
        super(HttpStatus.BAD_REQUEST, errMsg);
    }
}
