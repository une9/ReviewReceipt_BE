package nineproject.ReviewReceipt.review;

import nineproject.ReviewReceipt.model.ReviewDetail;
import nineproject.ReviewReceipt.model.Review;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReviewMapper {

    @Select("SELECT * FROM review WHERE status != 0 AND IS_PUBLIC = 1")
    List<Review> selectAll();

    @Select("SELECT * FROM review WHERE status != 0 AND USER_ID = #{userId}")
    List<Review> selectMyReviews(Integer userId);

    @Select("SELECT * FROM review LEFT JOIN review_detail USING (review_id) WHERE review_id = #{rvid}")
    ReviewDetail selectByRvId(int rvid);

    @Select("SELECT * FROM review WHERE user_id = #{userid}")
    Review selectByUserId(int userid);

    Integer insertRv(Review rv);

    int insertRvDetail(Map<String, Object> params);

    int updateRv(Map<String, Object> params);
    int updateRvDetail(Map<String, Object> params);

    int deleteRv(int rvid);

}
