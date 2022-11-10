package nineproject.ReviewReceipt.review.service;

public class ReviewSearchServiceUtil {
    public static String convertToRegExpStr(String keyword) {
        return "%"+keyword+"%";
    }
}
