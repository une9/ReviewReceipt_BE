package nineproject.ReviewReceipt.review.controller;

import nineproject.ReviewReceipt.model.ReviewVO;
import nineproject.ReviewReceipt.review.service.ReviewSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class ReviewSearchController {

    @Autowired
    private ReviewSearchService rss;

    @GetMapping
    public ReviewVO[] getKeywordSearchResult(String keyword) {
        return rss.getKeywordSearchResult(keyword);
    }
}
