package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ReviewExtend extends Review {

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

    @Override
    public String toString() {
        return super.toString() +
                "ReviewExtend{" +
                "review_detail_id=" + review_detail_id +
                ", detail_review_text='" + detail_review_text + '\'' +
                ", list_1_title='" + list_1_title + '\'' +
                ", list_1_score_total=" + list_1_score_total +
                ", list_1_score=" + list_1_score +
                ", list_1_desc='" + list_1_desc + '\'' +
                ", list_2_title='" + list_2_title + '\'' +
                ", list_2_score_total=" + list_2_score_total +
                ", list_2_score=" + list_2_score +
                ", list_2_desc='" + list_2_desc + '\'' +
                ", list_3_title='" + list_3_title + '\'' +
                ", list_3_score_total=" + list_3_score_total +
                ", list_3_score=" + list_3_score +
                ", list_3_desc='" + list_3_desc + '\'' +
                ", list_4_title='" + list_4_title + '\'' +
                ", list_4_score_total=" + list_4_score_total +
                ", list_4_score=" + list_4_score +
                ", list_4_desc='" + list_4_desc + '\'' +
                ", list_5_title='" + list_5_title + '\'' +
                ", list_5_score_total=" + list_5_score_total +
                ", list_5_score=" + list_5_score +
                ", list_5_desc='" + list_5_desc + '\'' +
                '}';
    }
}
