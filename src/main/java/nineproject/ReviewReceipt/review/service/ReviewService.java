package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.vo.ReviewVO;
import nineproject.ReviewReceipt.review.ReviewMapper;
import nineproject.ReviewReceipt.model.vo.ReviewDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper rm;

    public List<ReviewVO> getAllReview() {
        final List<ReviewVO> reviewList = rm.selectAll();
        return reviewList;
    }

    public ReviewDetailVO getReviewDetail(int rvid) {
        return rm.selectByRvId(rvid);
    }

    public Integer insertReview(ReviewVO review) {
        rm.insertRv(review);
        Integer rvId = review.getREVIEW_ID();
        return rvId;
    }

    public int updateReview(int rvid, ReviewDetailVO review_detail) {
        Map<String, Object> params = new HashMap<>();
        params.put("rvid", rvid);
        params.put("review_detail", review_detail);
        return rm.updateRv(params);
    }

    public void deleteReview(int rvid) {
        rm.deleteRv(rvid);
    }

}
