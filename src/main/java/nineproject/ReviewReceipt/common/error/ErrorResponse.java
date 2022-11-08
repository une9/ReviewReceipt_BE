package nineproject.ReviewReceipt.common.error;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter
public class ErrorResponse {

    private LocalDateTime timestamp = LocalDateTime.now();

    private String message; //예외 메시지 저장

    private HttpStatus status; // HTTP 상태 저장

    private String code;    // 예외코드 저장

//    private Error error;

    static public ErrorResponse create() {
        return new ErrorResponse();
    }

    public ErrorResponse status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ErrorResponse message(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponse code(String code) {
        this.code = code;
        return this;
    }

//    public ErrorResponse error(Error error) {
//        setError(error);
//        return this;
//    }




}
