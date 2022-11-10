package nineproject.ReviewReceipt.user.controller;

import nineproject.ReviewReceipt.model.LoginUserInfo;
import nineproject.ReviewReceipt.model.SignUpFormVO;
import nineproject.ReviewReceipt.model.UserVO;
import nineproject.ReviewReceipt.model.webPwChangeVO;
import nineproject.ReviewReceipt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService us;

    @GetMapping("/{userId}")
    public UserVO getUserInfo(@PathVariable int userId) {
        return us.getUserInfo(userId);
    }

//    @PostMapping("/insert")
//    public Integer insertUser(UserVO user) {
//        return us.insertUser(user);
//    }

    @PatchMapping("/update/{userId}/username")
    public int updateUsername(String username, @PathVariable int userId) {
        return us.updateUsername(userId, username.trim());
    }

    @PostMapping("/update/{userId}/userwebpw")
    public int updateUserWebPw(webPwChangeVO body, @PathVariable int userId) {
        String newPw = body.getNewPw();
        String newPwCheck = body.getNewPwCheck();
        String prevPw = body.getPrevPw();
        return us.updateUserWebPw(userId, newPw, newPwCheck, prevPw);
    }

    @PatchMapping("/delete/{userId}")
    public int deleteUser(@PathVariable int userId) {
        return us.deleteUser(userId);
    }

    @GetMapping("/check/username")
    public boolean checkPossibleUsername(String username) {
        return us.checkPossibleUsername(username.trim());
    }

    @PostMapping("/login")
    public LoginUserInfo login(HttpServletRequest request, UserVO user) {
        return us.login(request, user.getUser_webid(), user.getUser_webpw());
    }
    @PostMapping("/signup")
    public int signup(SignUpFormVO form) {
        return us.signup(form);
    }

}
