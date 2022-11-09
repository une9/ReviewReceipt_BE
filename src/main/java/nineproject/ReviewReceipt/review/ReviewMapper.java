package nineproject.ReviewReceipt.review;

import nineproject.ReviewReceipt.model.ReviewDetailVO;
import nineproject.ReviewReceipt.model.ReviewVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReviewMapper {

    @Select("SELECT * FROM review WHERE status != 0 AND IS_PUBLIC = 1")
    List<ReviewVO> selectAll();

    @Select("SELECT * FROM review LEFT JOIN review_detail USING (review_id) WHERE review_id = #{rvid}")
    ReviewDetailVO selectByRvId(int rvid);

    @Select("SELECT * FROM review WHERE user_id = #{userid}")
    ReviewVO selectByUserId(int userid);

    Integer insertRv(ReviewVO rv);

    int updateRv(Map<String, Object> params);

    int deleteRv(int rvid);

}
