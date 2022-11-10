package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter @Setter
@RequiredArgsConstructor
public class Review {

    private Integer review_id;
    private Integer user_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modify_date;

    private String review_type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date do_date;

    private String review_title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publish_date;

    private String abstract_txt;
    private String publisher;
    private String director;
    private String player;
    private String favorite_line;
    private String show_type;
    private String place;
    private Boolean yes_detail;     // 연결된 리뷰디테일 존재 여부
    private Boolean is_public;  // 공개-비공개
    private Boolean status;     // 삭제 여부

}
