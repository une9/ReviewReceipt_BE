package nineproject.ReviewReceipt.common.error;

import nineproject.ReviewReceipt.common.exception.InvalidValueException;
import nineproject.ReviewReceipt.common.exception.MyException;
import nineproject.ReviewReceipt.common.exception.NotLoggedInException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyErrorController {

    @ExceptionHandler(MyException.class)
    protected ResponseEntity<ErrorResponse> MyException(MyException e) {

        final ErrorResponse response = ErrorResponse
                .create()
                .status(e.getStatus())
                .message(e.getMsg())
                .code(e.getCode());
//                .error(e.getError());

        return new ResponseEntity<>(response, e.getStatus());
    }
}
