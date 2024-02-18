package team.shoppingmall.domain.member.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import team.shoppingmall.api.AuthenticateRestController;
import team.shoppingmall.domain.member.dto.LoginReq;
import team.shoppingmall.domain.member.dto.LoginRes;
import team.shoppingmall.domain.member.dto.SignUpInfoReq;
import team.shoppingmall.domain.member.service.MemberService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthenticateRestController.class)
public class AuthenticateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("정상적인 로그인 시 회원 아이디 반환")
    void 정상_로그인_테스트() throws Exception {

        String url = "/api/authenticate/login";
        LoginReq req = new LoginReq();
        ObjectMapper objectMapper = new ObjectMapper();

        req.setId("test");
        req.setPassword("test1234");

        LoginRes res = new LoginRes(req.getId());

        Mockito.when(memberService.login(req)).thenReturn(res);

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("정상적인 회원가입 시 회원 루트로 리다이렉트 반환")
    void 정상_회원가입_테스트() throws Exception {
        String url = "/api/authenticate/sign-up";
        SignUpInfoReq req = new SignUpInfoReq();
        ObjectMapper objectMapper = new ObjectMapper();

        req.setId("test");
        req.setPassword("test1234");
        req.setName("test");
        req.setEmail("test@test.com");
        req.setPhoneNumber("010-0000-0000");

        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isOk())
                .andExpect(content().string("redirect:/"));
    }
}
