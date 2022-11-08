package nineproject.ReviewReceipt.user.service;

import nineproject.ReviewReceipt.common.error.InvalidValueException;
import nineproject.ReviewReceipt.common.error.NullValueException;
import nineproject.ReviewReceipt.model.SignUpFormVO;
import nineproject.ReviewReceipt.model.UserVO;
import nineproject.ReviewReceipt.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static nineproject.ReviewReceipt.common.error.ErrorMessage.*;

@Service
public class UserService {

    @Autowired
    UserMapper um;

    public UserVO getUserInfo(int userId) {
        return um.getUser(userId);
    }

    public boolean isCorrectPrevPw(String userWebPw, int userId) {
        return userWebPw.equals(um.getPrevUserWebPw(userId));
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

        if (!isCorrectPrevPw(prevPw, userId)) {
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

    public HashMap<String, Object> login(String webId, String webPw) {
        if (webId == null || webId.equals("")) {
            throw new NullValueException(NO_WEBID);
        }

        if (webPw == null || webPw.equals("")) {
            throw new NullValueException(NO_WEBPW);
        }

        UserVO user = um.login(webId, webPw);

        if (user == null) {
            throw new NullValueException(NOT_CORRECT_INFO);
        }

        HashMap<String, Object> loginUserInfo = new HashMap<>();
        loginUserInfo.put("userId", user.getUSER_ID());
        loginUserInfo.put("nickname", user.getUSERNAME());

        return loginUserInfo;
    }

    public String padLeftWithZero(int num) {
        return String.format("%05d", num);
    }

    public int signup(SignUpFormVO form) {
        // validation check
        isValidSignupForm(form);

        // 회원번호 저장
        String lastMbrNo = um.getLastMbrNo();
        Integer mbrNum = Integer.valueOf(lastMbrNo.substring(2)) + 1;
        String thisMbrNo = "01" + padLeftWithZero(mbrNum);
        form.setMBR_NO(thisMbrNo);

        // 닉네임 공백제거
        form.setUSERNAME(form.getUSERNAME().trim());

        return um.insertUser(form);
    }

    public boolean isValidSignupForm(SignUpFormVO form) {
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
        if (!isPossibleUsername(username)) {    // 닉네임 중복체크
            throw new InvalidValueException(IMPOSSIBLE_USERNAME);
        }

        if (!isPossibleUserWebId(webId)) {      // 아이디 중복체크
            throw new InvalidValueException(IMPOSSIBLE_WEBID);
        }

        if (!webPw.equals(webPwCheck)) {        // 비밀번호 - 비밀번호 확인 일치 체크
            throw new InvalidValueException(PW_NOT_CORRESPOND);
        }

        return true;
    }

    public boolean isPossibleUsername(String username) {
        return um.countSameUsername(username) <= 0;
    }

    public boolean isPossibleUserWebId(String webId) {
        return um.countSameUserWebId(webId) <= 0;
    }


}
