package nineproject.ReviewReceipt.review;

import nineproject.ReviewReceipt.model.Review;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ReviewSearchMapper {

    Review[] getKeywordSearchResult(String regExp);
}
