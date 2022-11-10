package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.ReviewDetailVO;

import java.lang.reflect.Field;

public class ReviewServiceUtil {

    public static void trimReviewStringFields(ReviewDetailVO rd) throws IllegalAccessException {
        // REVIEW
        Field[] reviewFields = rd.getClass().getSuperclass().getDeclaredFields();
        trimFields(rd, reviewFields);

        // 리뷰디테일 없으면 끝
        if (!rd.getYes_detail()) return;

        // REVIEW_DETAIL
        Field[] reviewDetailFields = rd.getClass().getDeclaredFields();
        trimFields(rd, reviewDetailFields);
    }

    public static void trimFields(ReviewDetailVO rd, Field[] fields) throws IllegalAccessException {
        for (Field field : fields) {
            String type = field.getType().getTypeName();
            if (type == "java.lang.String") {
                field.setAccessible(true);
                String val = (String) field.get(rd);
                if (val != null) {
                    field.set(rd, val.trim());
                }
            }
        }
    }

}
