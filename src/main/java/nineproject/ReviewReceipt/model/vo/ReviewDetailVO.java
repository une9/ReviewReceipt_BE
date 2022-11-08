package nineproject.ReviewReceipt.model.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ReviewDetailVO extends ReviewVO {

    private int REVIEW_DETAIL_ID;
    private String DETAIL_REVIEW_TEXT;
    private String LIST_1_TITLE;
    private int LIST_1_SCORE_TOTAL;
    private int LIST_1_SCORE;
    private String LIST_1_DESC;
    private String LIST_2_TITLE;
    private int LIST_2_SCORE_TOTAL;
    private int LIST_2_SCORE;
    private String LIST_2_DESC;
    private String LIST_3_TITLE;
    private int LIST_3_SCORE_TOTAL;
    private int LIST_3_SCORE;
    private String LIST_3_DESC;
    private String LIST_4_TITLE;
    private int LIST_4_SCORE_TOTAL;
    private int LIST_4_SCORE;
    private String LIST_4_DESC;
    private String LIST_5_TITLE;
    private int LIST_5_SCORE_TOTAL;
    private int LIST_5_SCORE;
    private String LIST_5_DESC;
}
