package nineproject.ReviewReceipt.review;

import nineproject.ReviewReceipt.model.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReviewSearchMapper {

    ReviewVO[] getKeywordSearchResult(String regExp);
}
