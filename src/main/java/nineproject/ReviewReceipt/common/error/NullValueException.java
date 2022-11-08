package nineproject.ReviewReceipt.common.error;

import lombok.Getter;

@Getter
public class NullValueException extends InvalidValueException {

    public NullValueException(ErrorMessage errMsg) {
        super(errMsg);
        System.out.println();
    }
}
