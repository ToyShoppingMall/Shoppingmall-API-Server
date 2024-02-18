package team.shoppingmall.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import team.shoppingmall.domain.member.service.MemberService;

@Controller
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthenticateController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign-up";
    }
}
