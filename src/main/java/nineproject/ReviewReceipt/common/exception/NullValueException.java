package nineproject.ReviewReceipt.common.exception;

import lombok.Getter;
import nineproject.ReviewReceipt.common.error.ErrorMessage;

@Getter
public class NullValueException extends InvalidValueException {

    public NullValueException(ErrorMessage errMsg) {
        super(errMsg);
    }
}
