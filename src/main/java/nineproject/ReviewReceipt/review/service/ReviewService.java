package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.ReviewVO;
import nineproject.ReviewReceipt.review.ReviewMapper;
import nineproject.ReviewReceipt.model.ReviewDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nineproject.ReviewReceipt.review.service.ReviewServiceUtil.*;

@Service
public class ReviewService {

    @Autowired
    private ReviewMapper rm;

    public List<ReviewVO> getAllReview() {
        List<ReviewVO> reviewList = rm.selectAll();
        return reviewList;
    }

    public List<ReviewVO> getMyReview(Integer userId) {
        List<ReviewVO> reviewList = rm.selectMyReviews(userId);
        return reviewList;
    }

    public ReviewDetailVO getReviewDetail(int rvid) {
        return rm.selectByRvId(rvid);
    }

    public Integer insertReview(ReviewDetailVO review) throws IllegalAccessException {
        // 문자열 데이터 공백제거
        ReviewServiceUtil.trimReviewStringFields(review);

        // 리뷰 저장
        rm.insertRv((ReviewVO) review);
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

    public int updateReview(int rvId, ReviewDetailVO review) throws IllegalAccessException {
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
