package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.ReviewDetailVO;

import java.lang.reflect.Field;

public class ReviewServiceUtil {

    // 굳이 필요있나?...보류
    public static void trimReviewStringFields(ReviewDetailVO rd) {
        // REVIEW
        String rt = rd.getReview_title();
        String at = rd.getAbstract_txt();
        String fl = rd.getFavorite_line();

        if (rt != null) {
            rd.setReview_title(rt.trim());
        }
        if (at != null) {
            rd.setAbstract_txt(at.trim());
        }
        if (fl != null) {
            rd.setFavorite_line(fl.trim());
        }

        // 리뷰디테일 없으면 끝
        if (!rd.getYes_detail()) return;

        // REVIEW_DETAIL
        String drt = rd.getDetail_review_text();
        String l1t = rd.getList_1_title();

    }
}
