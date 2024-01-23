package team.shoppingmall.domain.member.dto.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingUpInfoServiceDTO {

    private String id;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean receptionSMS;
    private Boolean receptionMail;
    private String accessIp;
}
