package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
//@RequiredArgsConstructor
public class LoginUserInfo {
    private Integer userId;
    private String username;

    public LoginUserInfo(){}

    public LoginUserInfo(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginUserInfo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
