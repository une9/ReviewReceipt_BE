package nineproject.ReviewReceipt.common.exception;

import lombok.Getter;
import nineproject.ReviewReceipt.common.error.ErrorMessage;
import org.springframework.http.HttpStatus;
@Getter
public abstract class MyException extends RuntimeException{

    private final HttpStatus status;
    private final String msg;
    private final String code;

    public MyException(HttpStatus status, ErrorMessage msg) {
        super();
        this.status = status;
        this.msg = msg.getMessage();
        this.code = msg.getCode();
    }
}
