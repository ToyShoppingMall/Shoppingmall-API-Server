package team.shoppingmall.domain.member.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team.shoppingmall.domain.member.dto.service.AuthenticateServiceDTO;
import team.shoppingmall.domain.member.dto.service.SingUpInfoServiceDTO;
import team.shoppingmall.domain.member.repository.MemberRepository;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("가입정보가 정상적으로 들어온 경우 회원 가입 성공")
    public void test1() {
        SingUpInfoServiceDTO dto = new SingUpInfoServiceDTO(
                "testId",
                "testPassword",
                "김태완",
                "test@naver.com",
                "010-0000-0000",
                false,
                false,
                "192.168.4.55"
        );

        memberService.singUp(dto);
        System.out.println();
    }

    @Test
    @DisplayName("가입하려는 ID가 유효하지 않은 경우 InvalidParameterException 예외 발생")
    public void test2() {
        SingUpInfoServiceDTO dto = new SingUpInfoServiceDTO(
                "    test",
                "testPassword",
                "김태완",
                "test@naver.com",
                "010-0000-0000",
                false,
                false,
                "192.168.4.55"
        );

        Exception exception = assertThrows(InvalidParameterException.class, () -> memberService.singUp(dto));
        assertEquals(exception.getMessage(), "입력하신 '아이디' 정보가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("가입하려는 패스워드가 유효하지 않은 경우 InvalidParameterException 예외 발생")
    public void test3() {
        SingUpInfoServiceDTO dto = new SingUpInfoServiceDTO(
                "test",
                "testPassword ",
                "김태완",
                "test@naver.com",
                "010-0000-0000",
                false,
                false,
                "192.168.4.55"
        );

        Exception exception = assertThrows(InvalidParameterException.class, () -> memberService.singUp(dto));
        assertEquals(exception.getMessage(), "입력하신 '패스워드' 정보가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("가입하려는 이메일이 유효하지 않은 경우 InvalidParameterException 예외 발생")
    public void test4() {
        SingUpInfoServiceDTO dto = new SingUpInfoServiceDTO(
                "test",
                "testPassword",
                "김태완",
                "test @naver.com",
                "010-0000-0000",
                false,
                false,
                "192.168.4.55"
        );

        Exception exception = assertThrows(InvalidParameterException.class, () -> memberService.singUp(dto));
        assertEquals(exception.getMessage(), "입력하신 '이메일' 정보가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("가입하려는 핸드폰번호가 유효하지 않은 경우 InvalidParameterException 예외 발생")
    public void test5() {
        SingUpInfoServiceDTO dto = new SingUpInfoServiceDTO(
                "test",
                "testPassword",
                "김태완",
                "test@naver.com",
                "010-0000-000",
                false,
                false,
                "192.168.4.55"
        );

        Exception exception = assertThrows(InvalidParameterException.class, () -> memberService.singUp(dto));
        assertEquals(exception.getMessage(), "입력하신 '핸드폰번호' 정보가 올바르지 않습니다.");
    }

    @Test
    @DisplayName("회원 탈퇴 성공")
    public void test6() {
        SingUpInfoServiceDTO dto1 = new SingUpInfoServiceDTO(
                "test",
                "testPassword",
                "김태완",
                "test@naver.com",
                "010-0000-0000",
                false,
                false,
                "192.168.4.55"
        );
        AuthenticateServiceDTO dto2 = new AuthenticateServiceDTO("test");

        memberService.singUp(dto1);
        memberService.singOut(dto2);
    }
}