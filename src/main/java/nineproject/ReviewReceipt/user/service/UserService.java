package nineproject.ReviewReceipt.user.service;

import nineproject.ReviewReceipt.common.constants.sessionConstants;
import nineproject.ReviewReceipt.common.exception.InvalidValueException;
import nineproject.ReviewReceipt.common.exception.LeavedUserException;
import nineproject.ReviewReceipt.common.exception.NullValueException;
import nineproject.ReviewReceipt.model.LoginUserInfo;
import nineproject.ReviewReceipt.model.SignUpFormVO;
import nineproject.ReviewReceipt.model.UserVO;
import nineproject.ReviewReceipt.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

import static nineproject.ReviewReceipt.common.error.ErrorMessage.*;
import static nineproject.ReviewReceipt.user.service.UserServiceUtil.*;

@Service
public class UserService {

    @Autowired
    UserMapper um;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserVO getUserInfo(int userId) {
        UserVO user = um.getUser(userId);

        if (!user.getSTATUS()) {
            throw new LeavedUserException(LEAVED_USER);
        }
        return user;
    }

    public int updateUsername(int userId, String username) {
        HashMap<String, Object> params = new HashMap<>();

        params.put("userId", userId);
        params.put("new_username", username);
        return um.updateUsername(params);
    }

    public int updateUserWebPw(int userId, String newPw, String newPwCheck, String prevPw) {
        if (!newPw.equals(newPwCheck)) {
            throw new InvalidValueException(PW_NOT_CORRESPOND);
        }

        if (newPw.equals(prevPw)) {
            throw new InvalidValueException(SAME_WITH_PREV_PW);
        }

        if (!isCorrectPrevPw(um, prevPw, userId)) {
            throw new InvalidValueException(NOT_CORRECT_PREV_PW);
        }

        HashMap<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("new_web_pw", newPw);
        return um.updateUserWebPw(params);
    }

    public int deleteUser(int userId) {
        return um.deleteUser(userId);
    }

    public LoginUserInfo login(HttpServletRequest request, String webId, String rawPW) {
        if (webId == null || webId.equals("")) {
            throw new NullValueException(NO_WEBID);
        }

        if (rawPW == null || rawPW.equals("")) {
            throw new NullValueException(NO_WEBPW);
        }

        UserVO user = um.login(webId);

        if (!isValidLogin(passwordEncoder, user, rawPW)) {
            throw new NullValueException(NOT_CORRECT_INFO);
        }

        // 로그인 사용자 정보
        Integer userId = user.getUSER_ID();
        String username = user.getUSERNAME();

        LoginUserInfo loginUserInfo = new LoginUserInfo(userId, username);

        // 로그인 세션 저장
        HttpSession session = request.getSession();                     // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
        session.setAttribute(String.valueOf(sessionConstants.LOGIN_USER_INFO), loginUserInfo);     // 세션에 로그인 회원 정보 보관

        return loginUserInfo;
    }

    public int signup(SignUpFormVO form) {
        // validation check
        isValidSignupForm(um, form);

        // 회원번호 저장
        String lastMbrNo = um.getLastMbrNo();
        int mbrNum = Integer.parseInt(lastMbrNo.substring(2)) + 1;
        String thisMbrNo = "01" + padLeftWithZero(mbrNum);
        form.setMBR_NO(thisMbrNo);

        // 닉네임 공백제거
        form.setUSERNAME(form.getUSERNAME().trim());

        // 비밀번호 암호화 & 원래 암호 저장 (개발용)
        String rawPw = form.getUSER_WEBPW();
        String encodedPw = passwordEncoder.encode(rawPw);
        form.setRAW_PW(rawPw);
        form.setUSER_WEBPW(encodedPw);

        return um.insertUser(form);
    }

    public boolean checkPossibleUsername(String username) {
        return isPossibleUsername(um, username);
    }

}
