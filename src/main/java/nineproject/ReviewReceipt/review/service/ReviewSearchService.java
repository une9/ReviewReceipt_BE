package nineproject.ReviewReceipt.review.service;

import nineproject.ReviewReceipt.model.Review;
import nineproject.ReviewReceipt.review.ReviewSearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static nineproject.ReviewReceipt.review.service.ReviewSearchServiceUtil.convertToRegExpStr;

@Service
public class ReviewSearchService {

    @Autowired
    private ReviewSearchMapper rsm;

    public Review[] getKeywordSearchResult(String keyword) {
        String regExp = convertToRegExpStr(keyword);
        return rsm.getKeywordSearchResult(regExp);
    }
}
