package nineproject.ReviewReceipt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
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
    private Boolean STATUS;     // 삭제 여부

}
