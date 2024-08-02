package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.Review;
import nineproject.ReviewReceipt.review.ReviewMapper;
import nineproject.ReviewReceipt.model.ReviewExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper rm;

    public List<Review> getAllReview() {
        List<Review> reviewList = rm.selectAll();
        return reviewList;
    }

    public List<Review> getMyReview(Integer userId) {
        List<Review> reviewList = rm.selectMyReviews(userId);
        return reviewList;
    }

    public ReviewExtend getReviewExtend(int rvid) {
        return rm.selectByRvId(rvid);
    }

    public Integer insertReview(ReviewExtend review) throws IllegalAccessException {
        // 문자열 데이터 공백제거
        ReviewServiceUtil.trimReviewStringFields(review);

        // 리뷰 저장
        rm.insertRv((Review) review);
        Integer rvId = review.getReview_id();

        // 리뷰디테일 존재 시 저장
        if (review.getYes_detail()) {
            Map<String, Object> params = new HashMap<>();
            params.put("rvId", rvId);
            params.put("review_detail", review);
            rm.insertRvDetail(params);
        }

        return rvId;
    }

    public int updateReview(int rvId, ReviewExtend review) throws IllegalAccessException {
        // 문자열 데이터 공백제거
        ReviewServiceUtil.trimReviewStringFields(review);

        // params 생성
        Map<String, Object> params = new HashMap<>();
        params.put("rvId", rvId);
        params.put("review_detail", review);

        // 리뷰 업데이트
        rm.updateRv(params);

        // 리뷰디테일 존재 시 업데이트
        if (review.getYes_detail()) {
            rm.updateRvDetail(params);
        }
        return rvId;
    }

    public void deleteReview(int rvid) {
        rm.deleteRv(rvid);
    }

}
