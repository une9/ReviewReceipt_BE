package nineproject.ReviewReceipt.user.service;

import nineproject.ReviewReceipt.common.error.InvalidValueException;
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

    public Integer insertUser(UserVO user) {
        System.out.println("service-user = " + user);
        return um.insertUser(user);
    }

    public boolean isPossibleUsername(String username) {
        return um.countSameUsername(username) <= 0;
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

    public Object updateUserWebPw(int userId, String newPw, String newPwCheck, String prevPw) {
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



}
