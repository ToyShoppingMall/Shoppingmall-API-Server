package team.shoppingmall.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReq {

    private String id;
    private String password;
}
