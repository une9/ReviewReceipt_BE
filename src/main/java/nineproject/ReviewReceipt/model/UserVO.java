package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Getter @Setter
@RequiredArgsConstructor
public class UserVO {
    private Integer USER_ID;
    private String MBR_NO;
    private String USERNAME;
    private String USER_WEBID;
    private String USER_WEBPW;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String CREATE_DATE;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String MODIFY_DATE;

    private Boolean UNREAD_RECEIPT;
    private Boolean STATUS;         // 활성: 1 탈퇴: 0
}
