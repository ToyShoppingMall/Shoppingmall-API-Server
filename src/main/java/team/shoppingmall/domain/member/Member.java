package team.shoppingmall.domain.member;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class Member {

    private Long index;
    private String id;
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
    private LocalDate birthDay;
    private LocalDateTime joinDate;
    private LocalDateTime lastActDate;
    private LocalDateTime withdrawalDate;
    private String withdrawalReason;
    private Boolean receptionSMS;
    private Boolean receptionMail;
    private Integer point;
    private String rank;
    private String accessIp;

    public Member(String id, String password, String name, String email, String phoneNumber, LocalDate birthDay, LocalDateTime joinDate, Boolean receptionSMS, Boolean receptionMail, String accessIp) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.joinDate = joinDate;
        this.receptionSMS = receptionSMS;
        this.receptionMail = receptionMail;
        this.accessIp = accessIp;
    }
}
