package nineproject.ReviewReceipt.common.utils;

import nineproject.ReviewReceipt.common.constants.sessionConstants;
import nineproject.ReviewReceipt.common.exception.NotLoggedInException;
import nineproject.ReviewReceipt.model.LoginUserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static nineproject.ReviewReceipt.common.error.ErrorMessage.NOT_LOGGED_IN;

public class LoginUtil {
    public static Integer getLoginUserId(HttpSession session) {
        LoginUserInfo loginUserInfo = (LoginUserInfo) session.getAttribute(String.valueOf(sessionConstants.LOGIN_USER_INFO));

        System.out.println("request = " + session);
        System.out.println("loginUserInfo = " + loginUserInfo);
        // login X 시
        if (loginUserInfo == null) {
            throw new NotLoggedInException(NOT_LOGGED_IN);
        }

        return loginUserInfo.getUserId();
    }
}
