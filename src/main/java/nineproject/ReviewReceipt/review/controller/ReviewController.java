package nineproject.ReviewReceipt.review.controller;

import nineproject.ReviewReceipt.common.utils.LoginUtil;
import nineproject.ReviewReceipt.model.ReviewDetailVO;
import nineproject.ReviewReceipt.review.service.ReviewService;
import nineproject.ReviewReceipt.model.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService rs;

    @GetMapping
    public List<ReviewVO> getAllReviews() {
        return rs.getAllReview();
    }

    @GetMapping("/mine")
    public List<ReviewVO> getMyReviews(HttpSession session) {
        Integer userId = LoginUtil.getLoginUserId(session);
        return rs.getMyReview(userId);
    }

    @GetMapping("/{rvid}")
    public ReviewDetailVO getReviewDetail(@PathVariable int rvid) {
        return rs.getReviewDetail(rvid);
    }

    @PostMapping("/insert")
    public Integer insertReview(ReviewVO review) {
        return rs.insertReview(review);
    }

    @PatchMapping("/update/{rvid}")
    public int updateReview(@PathVariable int rvid, ReviewDetailVO review_detail) {
        rs.updateReview(rvid, review_detail);
        return rvid;
    }

    @PatchMapping("/delete/{rvid}")
    public void deleteReview(@PathVariable int rvid) {
        rs.deleteReview(rvid);
    }
}
