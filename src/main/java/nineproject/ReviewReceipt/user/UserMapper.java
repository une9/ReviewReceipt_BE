package nineproject.ReviewReceipt.user;

import nineproject.ReviewReceipt.model.SignUpForm;
import nineproject.ReviewReceipt.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE USER_ID = #{userId}")
    User getUser(int userId);

    @Select("SELECT COUNT(*) FROM USER WHERE USERNAME = #{username} AND STATUS = 1")
    int countSameUsername(String username);

    @Select("SELECT COUNT(*) FROM USER WHERE USER_WEBID = #{webId}")
    int countSameUserWebId(String webId);

    @Select("SELECT USER_WEBPW FROM USER WHERE USER_ID = #{userId}")
    String getPrevUserWebPw(int userId);

    Integer insertUser(SignUpForm user);

    int updateUsername(HashMap<String, Object> params);

    int updateUserWebPw(HashMap<String, Object> params);

    int deleteUser(int userId);

    @Select("SELECT * FROM USER WHERE USER_WEBID = #{webId}")
    User login(@Param("webId") String webId);
    @Select("SELECT MBR_NO FROM USER ORDER BY MBR_NO DESC LIMIT 1")
    String getLastMbrNo();
}
