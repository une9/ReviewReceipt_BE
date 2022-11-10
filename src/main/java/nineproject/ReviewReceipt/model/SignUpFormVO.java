package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class SignUpFormVO {
    private String mbr_no;
    private String username;
    private String user_webid;
    private String raw_pw;
    private String user_webpw;
    private String user_webpw_check;

}
