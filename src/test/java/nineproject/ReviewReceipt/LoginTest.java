package nineproject.ReviewReceipt;

import nineproject.ReviewReceipt.common.constants.sessionConstants;
import nineproject.ReviewReceipt.model.LoginUserInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginTest {
    private MockMvc mockMvc;
    protected MockHttpSession session;

    @Autowired
    WebApplicationContext context;

    @Before // 1
    public void setUp() throws Exception{
        session = new MockHttpSession();

        LoginUserInfo loginUser = new LoginUserInfo(5, "퇴근요정");
        session.setAttribute(String.valueOf(sessionConstants.LOGIN_USER_INFO), loginUser);
    }

    @After // 2
    public void clean(){
        session.clearAttributes();
    }

    @Test // 3
    public void testGetMyReviews() throws Exception {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        // ...
        mockMvc.perform(
                    get("/review/mine")
                    .session(session) // 추가
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
