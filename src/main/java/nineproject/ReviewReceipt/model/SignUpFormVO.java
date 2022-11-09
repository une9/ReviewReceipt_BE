package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class SignUpFormVO {
    private String MBR_NO;
    private String USERNAME;
    private String USER_WEBID;
    private String RAW_PW;
    private String USER_WEBPW;
    private String USER_WEBPW_CHECK;

}
