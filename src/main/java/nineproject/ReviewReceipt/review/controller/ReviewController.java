package nineproject.ReviewReceipt.review.controller;

import nineproject.ReviewReceipt.common.utils.LoginUtil;
import nineproject.ReviewReceipt.model.ReviewExtend;
import nineproject.ReviewReceipt.review.service.ReviewService;
import nineproject.ReviewReceipt.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService rs;

    @GetMapping
    public List<Review> getAllReviews() {
        return rs.getAllReview();
    }

    @GetMapping("/mine")
    public List<Review> getMyReviews(HttpSession session) {
        Integer userId = LoginUtil.getLoginUserId(session);
        return rs.getMyReview(userId);
    }

    @GetMapping("/{rvid}")
    public ReviewExtend getReviewExtend(@PathVariable int rvid) {
        return rs.getReviewExtend(rvid);
    }

    @PostMapping("/insert")
    public Integer insertReview(@RequestBody ReviewExtend review) throws IllegalAccessException {
        System.out.println("reviewExtend = " + review);
        return rs.insertReview(review);
    }

    @PatchMapping("/update/{rvid}")
    public int updateReview(@PathVariable int rvid, ReviewExtend review_detail) throws IllegalAccessException {
        rs.updateReview(rvid, review_detail);
        return rvid;
    }

    @PatchMapping("/delete/{rvid}")
    public void deleteReview(@PathVariable int rvid) {
        rs.deleteReview(rvid);
    }
}
