package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import nineproject.ReviewReceipt.model.ReviewVO;

@Getter @Setter
@RequiredArgsConstructor
public class ReviewDetailVO extends ReviewVO {

    private int review_detail_id;
    private String detail_review_text;
    private String list_1_title;
    private int list_1_score_total;
    private int list_1_score;
    private String list_1_desc;
    private String list_2_title;
    private int list_2_score_total;
    private int list_2_score;
    private String list_2_desc;
    private String list_3_title;
    private int list_3_score_total;
    private int list_3_score;
    private String list_3_desc;
    private String list_4_title;
    private int list_4_score_total;
    private int list_4_score;
    private String list_4_desc;
    private String list_5_title;
    private int list_5_score_total;
    private int list_5_score;
    private String list_5_desc;
}
