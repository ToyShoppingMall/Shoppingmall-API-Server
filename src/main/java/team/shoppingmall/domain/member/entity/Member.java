package team.shoppingmall.domain.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;
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
    private LocalDate birthday;
    private LocalDateTime signUpDate;
    private LocalDateTime lastActDate;
    private LocalDateTime signOutDate;
    private String signOutReason;
    private Boolean receptionSMS;
    private Boolean receptionMail;
    private Integer point;
    private String grade;
    private String accessIp;
    private Integer loginTry;

    public Member(String id, String password, String name, String email, String phoneNumber, Boolean receptionSMS, Boolean receptionMail, String accessIp) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.receptionSMS = receptionSMS;
        this.receptionMail = receptionMail;
        this.accessIp = accessIp;
    }

    public Member isValidPassword(String password) {
        if (!this.password.equals(password))
            throw new InvalidParameterException();
        return this;
    }

    public Member updateLastActDate() {
        this.lastActDate = LocalDateTime.now();
        return this;
    }

    public Member initLoginTry() {
        this.loginTry = 0;
        return this;
    }

    public Member initPassword() {
        this.password = RandomStringUtils.randomAlphanumeric(8);
        return this;
    }
}
