package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Getter @Setter
@RequiredArgsConstructor
public class UserVO {
    private Integer user_id;
    private String mbr_no;
    private String username;
    private String user_webid;
    private String raw_pw;      // 암호화되지 않은 비밀번호 (개발용)
    private String user_webpw;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String create_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String modify_date;

    private Boolean unread_receipt;
    private Boolean status;         // 활성: 1 탈퇴: 0
}
