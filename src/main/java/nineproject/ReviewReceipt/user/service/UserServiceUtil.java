package nineproject.ReviewReceipt.user.service;

import nineproject.ReviewReceipt.common.error.InvalidValueException;
import nineproject.ReviewReceipt.common.error.NullValueException;
import nineproject.ReviewReceipt.model.SignUpFormVO;
import nineproject.ReviewReceipt.model.UserVO;
import nineproject.ReviewReceipt.user.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import static nineproject.ReviewReceipt.common.error.ErrorMessage.*;

public class UserServiceUtil {
    public static boolean isCorrectPrevPw(UserMapper um, String userWebPw, int userId) {
        return userWebPw.equals(um.getPrevUserWebPw(userId));
    }

    public static String padLeftWithZero(int num) {
        return String.format("%05d", num);
    }

    public static boolean isValidSignupForm(UserMapper um, SignUpFormVO form) {
        String username = form.getUSERNAME();
        String webId = form.getUSER_WEBID();
        String webPw = form.getUSER_WEBPW();
        String webPwCheck = form.getUSER_WEBPW_CHECK();

        // 빈 값 체크
        if (username == null || username.equals("")) {
            throw new NullValueException(NO_USERNAME);
        }

        if (webId == null || webId.equals("")) {
            throw new NullValueException(NO_WEBID);
        }

        if (webPw == null || webPw.equals("")) {
            throw new NullValueException(NO_WEBPW);
        }

        if (webPwCheck == null || webPwCheck.equals("")) {
            throw new NullValueException(NO_WEBPWCHECK);
        }

        // 올바른 값 체크
        if (!isPossibleUsername(um, username)) {    // 닉네임 중복체크
            throw new InvalidValueException(EXISTING_USERNAME);
        }

        if (!isPossibleUserWebId(um, webId)) {      // 아이디 중복체크
            throw new InvalidValueException(EXISTING_WEBID);
        }

        if (!webPw.equals(webPwCheck)) {        // 비밀번호 - 비밀번호 확인 일치 체크
            throw new InvalidValueException(PW_NOT_CORRESPOND);
        }

        return true;
    }

    public static boolean isPossibleUsername(UserMapper um, String username) {
        return um.countSameUsername(username) <= 0;
    }

    public static boolean isPossibleUserWebId(UserMapper um, String webId) {
        return um.countSameUserWebId(webId) <= 0;
    }

    public static boolean isValidLogin(PasswordEncoder passwordEncoder, UserVO user, String rawPW) {
        if (user == null) return false;

        return passwordEncoder.matches(rawPW, user.getUSER_WEBPW());
    }
}
