package team.shoppingmall.domain.member.dto.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PrivateInfoServiceDTO {

    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Integer zipCode;
    private String address;
    private String detailAddress;
    private Integer roadZipCode;
    private String roadAddress;
    private String detailRoadAddress;
    private LocalDate birthday;
    private Boolean receptionSMS;
    private Boolean receptionMail;
}
