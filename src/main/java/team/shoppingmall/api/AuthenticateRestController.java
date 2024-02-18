package team.shoppingmall.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.shoppingmall.domain.member.dto.LoginReq;
import team.shoppingmall.domain.member.dto.LoginRes;
import team.shoppingmall.domain.member.dto.SignUpInfoReq;
import team.shoppingmall.domain.member.service.MemberService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/authenticate")
@RequiredArgsConstructor
public class AuthenticateRestController {

    private final MemberService memberService;

    @PostMapping("/login")
    public LoginRes login(@RequestBody LoginReq dto) {
        return memberService.login(dto);
    }

    @PostMapping(
            value = "/sign-up",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Map<String, String> signUp(@RequestBody SignUpInfoReq dto) {
        memberService.singUp(dto);
        return new HashMap<>(){{ put("redirect", "/"); }};
    }
}
