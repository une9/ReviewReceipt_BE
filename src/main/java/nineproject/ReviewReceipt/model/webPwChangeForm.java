package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class webPwChangeForm {
    private String newPw;
    private String newPwCheck;
    private String prevPw;

}
