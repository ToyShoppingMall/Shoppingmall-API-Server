package team.shoppingmall.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.shoppingmall.domain.member.dto.LoginReq;
import team.shoppingmall.domain.member.dto.LoginRes;
import team.shoppingmall.domain.member.dto.SignUpInfoReq;
import team.shoppingmall.domain.member.service.MemberService;

@RestController
@RequestMapping("/api/authenticate")
@RequiredArgsConstructor
public class AuthenticateRestController {

    private final MemberService memberService;

    @PostMapping("/login")
    public LoginRes login(@RequestBody LoginReq dto) {
        return memberService.login(dto);
    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignUpInfoReq dto) {
        memberService.singUp(dto);
        return "redirect:/";
    }
}
