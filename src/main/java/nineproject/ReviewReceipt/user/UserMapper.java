package nineproject.ReviewReceipt.user;

import nineproject.ReviewReceipt.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE USER_ID = #{userId}")
    UserVO getUser(int userId);

    @Select("SELECT COUNT(*) FROM USER WHERE USERNAME = #{username}")
    int countSameUsername(String username);

    @Select("SELECT USER_WEBPW FROM USER WHERE USER_ID = #{userId}")
    String getPrevUserWebPw(int userId);

    Integer insertUser(UserVO user);

    int updateUsername(HashMap<String, Object> params);

    int updateUserWebPw(HashMap<String, Object> params);

    int deleteUser(int userId);
}
