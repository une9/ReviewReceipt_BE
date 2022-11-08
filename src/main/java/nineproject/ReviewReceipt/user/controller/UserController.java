package nineproject.ReviewReceipt.user.controller;

import nineproject.ReviewReceipt.model.UserVO;
import nineproject.ReviewReceipt.model.webPwChangeVO;
import nineproject.ReviewReceipt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService us;

    @GetMapping("/{userId}")
    public UserVO getUserInfo(@PathVariable int userId) {
        return us.getUserInfo(userId);
    }

    @PostMapping("/insert")
    public Integer insertUser(UserVO user) {
        return us.insertUser(user);
    }

    @PatchMapping("/update/{userId}/username")
    public int updateUsername(String username, @PathVariable int userId) {
        return us.updateUsername(userId, username.trim());
    }

    @PostMapping("/update/{userId}/userwebpw")
    public Object updateUserWebPw(webPwChangeVO body, @PathVariable int userId) {
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
    public boolean isPossibleUsername(String username) {
        return us.isPossibleUsername(username.trim());
    }

}
