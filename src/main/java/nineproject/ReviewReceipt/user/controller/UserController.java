package nineproject.ReviewReceipt.user.controller;

import nineproject.ReviewReceipt.model.UserVO;
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
        System.out.println("controller-user = " + user);
        return us.insertUser(user);
    }

    @PatchMapping("/update/{userId}/username")
    public int updateUsername(String username, @PathVariable int userId) {
        return us.updateUsername(userId, username);
    }

    @PatchMapping("/update/{userId}/userwebpw")
    public Object updateUserWebPw(String newPw, String newPwCheck, String prevPw, @PathVariable int userId) {
        return us.updateUserWebPw(userId, newPw, newPwCheck, prevPw);
    }




}
