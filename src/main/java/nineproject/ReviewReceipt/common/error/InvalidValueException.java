package nineproject.ReviewReceipt.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

@Getter
public class InvalidValueException extends RuntimeException {

    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final String msg;

    public InvalidValueException(ErrorMessage msg) {
        super();
        this.msg = msg.getMessage();
    }
}
