package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.ReviewDetailVO;

import java.lang.reflect.Field;

public class ReviewServiceUtil {

    // 굳이 필요있나?...보류
    public static void trimReviewStringFields(ReviewDetailVO rd) {
        // REVIEW
        String rt = rd.getREVIEW_TITLE();
        String at = rd.getABSTRACT_TXT();
        String fl = rd.getFAVORITE_LINE();

        if (rt != null) {
            rd.setREVIEW_TITLE(rt.trim());
        }
        if (at != null) {
            rd.setABSTRACT_TXT(at.trim());
        }
        if (fl != null) {
            rd.setFAVORITE_LINE(fl.trim());
        }

        // 리뷰디테일 없으면 끝
        if (!rd.getYES_DETAIL()) return;

        // REVIEW_DETAIL
        String drt = rd.getDETAIL_REVIEW_TEXT();
        String l1t = rd.getLIST_1_TITLE();

    }
}
