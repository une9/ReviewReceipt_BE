package nineproject.ReviewReceipt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter @Setter
@RequiredArgsConstructor
public class ReviewVO {

    private Integer REVIEW_ID;
    private Integer USER_ID;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CREATE_DATE;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date MODIFY_DATE;

    private String REVIEW_TYPE;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date DO_DATE;

    private String REVIEW_TITLE;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date PUBLISH_DATE;

    private String ABSTRACT_TXT;
    private String PUBLISHER;
    private String DIRECTOR;
    private String PLAYER;
    private String FAVORITE_LINE;
    private String SHOW_TYPE;
    private String PLACE;
    private Boolean YES_DETAIL;     // 연결된 리뷰디테일 존재 여부
    private Boolean IS_PUBLIC;  // 공개-비공개
    private Boolean STATUS;     // 삭제 여부

}
