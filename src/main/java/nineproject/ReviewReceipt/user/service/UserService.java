package nineproject.ReviewReceipt.user.service;

import nineproject.ReviewReceipt.common.constants.sessionConstants;
import nineproject.ReviewReceipt.common.exception.InvalidValueException;
import nineproject.ReviewReceipt.common.exception.LeavedUserException;
import nineproject.ReviewReceipt.common.exception.NullValueException;
import nineproject.ReviewReceipt.model.LoginUserInfo;
import nineproject.ReviewReceipt.model.SignUpForm;
import nineproject.ReviewReceipt.model.User;
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

    public User getUserInfo(int userId) {
        User user = um.getUser(userId);

        if (!user.getStatus()) {
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

        if (!isCorrectPw(passwordEncoder, prevPw, um.getPrevUserWebPw(userId))) {
            throw new InvalidValueException(NOT_CORRECT_PREV_PW);
        }

        // 비밀번호 암호화 & rawPw 저장 (개발용)
        String encodedNewPw = passwordEncoder.encode(newPw);

        HashMap<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("new_web_pw", encodedNewPw);
        params.put("rawPw", newPw);
        return um.updateUserWebPw(params);
    }

    public int deleteUser(int userId) {
        User user = getUserInfo(userId);
        // 이미 탈퇴한 회원이면 에러
        if (!user.getStatus()) {
            throw new LeavedUserException(LEAVED_USER);
        }

        return um.deleteUser(userId);
    }

    public LoginUserInfo login(HttpServletRequest request, String webId, String rawPW) {
        if (webId == null || webId.equals("")) {
            throw new NullValueException(NO_WEBID);
        }

        if (rawPW == null || rawPW.equals("")) {
            throw new NullValueException(NO_WEBPW);
        }

        User user = um.login(webId);

        if (!isValidLogin(passwordEncoder, user, rawPW)) {
            throw new NullValueException(NOT_CORRECT_INFO);
        }

        // 로그인 사용자 정보
        Integer userId = user.getUser_id();
        String username = user.getUsername();

        LoginUserInfo loginUserInfo = new LoginUserInfo(userId, username);

        // 로그인 세션 저장
        HttpSession session = request.getSession();                     // 세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성하여 반환
        session.setAttribute(String.valueOf(sessionConstants.LOGIN_USER_INFO), loginUserInfo);     // 세션에 로그인 회원 정보 보관

        return loginUserInfo;
    }

    public int signup(SignUpForm form) {
        // validation check
        isValidSignupForm(um, form);

        // 회원번호 저장
        String lastMbrNo = um.getLastMbrNo();
        int mbrNum = Integer.parseInt(lastMbrNo.substring(2)) + 1;
        String thisMbrNo = "01" + padLeftWithZero(mbrNum);
        form.setMbr_no(thisMbrNo);

        // 닉네임 공백제거
        form.setUsername(form.getUsername().trim());

        // 비밀번호 암호화 & 원래 암호 저장 (개발용)
        String rawPw = form.getUser_webpw();
        String encodedPw = passwordEncoder.encode(rawPw);
        form.setRaw_pw(rawPw);
        form.setUser_webpw(encodedPw);

        return um.insertUser(form);
    }

    public boolean checkPossibleUsername(String username) {
        return isPossibleUsername(um, username);
    }

}
