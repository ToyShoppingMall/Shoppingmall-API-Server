package team.shoppingmall.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpInfoReq {

    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean receptionSMS;
    private Boolean receptionMail;
    private String accessIp;
}
