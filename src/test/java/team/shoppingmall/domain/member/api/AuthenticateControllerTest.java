package team.shoppingmall.domain.member.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import team.shoppingmall.api.AuthenticateController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticateController.class)
public class AuthenticateControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("/authenticate/login 호출 시 로그인 페이지 정상 반환")
    void 로그인_페이지_호출_테스트() throws Exception {
        String url = "/authenticate/login";

        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/authenticate/sign-up 호출 시 회원가입 페이지 정상 반환")
    void 회원가입_페이지_호출_테스트() throws Exception {
        String url = "/authenticate/sign-up";

        mockMvc.perform(get(url))
                .andExpect(status().isOk());
    }
}
