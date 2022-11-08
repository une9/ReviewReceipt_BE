package nineproject.ReviewReceipt.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyErrorController {

    @ExceptionHandler(InvalidValueException.class)
    protected ResponseEntity<ErrorResponse> invalidValueException(InvalidValueException e) {

        final ErrorResponse response = ErrorResponse
                .create()
                .status(e.getStatus())
                .message(e.getMsg())
                .code(e.getCode());
//                .error(e.getError());

        return new ResponseEntity<>(response, e.getStatus());
    }
}
