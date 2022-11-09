package nineproject.ReviewReceipt.user.service;

import nineproject.ReviewReceipt.common.error.InvalidValueException;
import nineproject.ReviewReceipt.common.error.NullValueException;
import nineproject.ReviewReceipt.model.SignUpFormVO;
import nineproject.ReviewReceipt.model.UserVO;
import nineproject.ReviewReceipt.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        return um.getUser(userId);
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

    public HashMap<String, Object> login(String webId, String rawPW) {
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

        HashMap<String, Object> loginUserInfo = new HashMap<>();
        loginUserInfo.put("userId", user.getUSER_ID());
        loginUserInfo.put("nickname", user.getUSERNAME());

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
