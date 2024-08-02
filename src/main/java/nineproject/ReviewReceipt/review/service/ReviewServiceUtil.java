package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.Review;
import nineproject.ReviewReceipt.model.ReviewExtend;

import java.lang.reflect.Field;

public class ReviewServiceUtil {

    public static void trimReviewStringFields(ReviewExtend re) throws IllegalAccessException {
        // REVIEW
        Field[] reviewFields = re.getClass().getSuperclass().getDeclaredFields();
        trimFields(re, reviewFields);

        // 리뷰디테일 없으면 끝
        if (!((Review) re).getYes_detail()) return;

        // REVIEW_DETAIL
        Field[] ReviewExtendFields = re.getClass().getDeclaredFields();
        trimFields(re, ReviewExtendFields);
    }

    public static void trimFields(ReviewExtend re, Field[] fields) throws IllegalAccessException {
        for (Field field : fields) {
            String type = field.getType().getTypeName();
            if (type == "java.lang.String") {
                field.setAccessible(true);
                String val = (String) field.get(re);
                if (val != null) {
                    field.set(re, val.trim());
                }
            }
        }
    }

}
