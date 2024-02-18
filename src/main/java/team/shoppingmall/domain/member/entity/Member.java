package team.shoppingmall.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import team.shoppingmall.domain.member.Grade;
import team.shoppingmall.domain.member.dto.PrivateInfoDTO;
import team.shoppingmall.domain.member.dto.SignUpInfoReq;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "members")
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
    @CreatedDate
    private LocalDateTime signUpDate;
    @LastModifiedDate
    private LocalDateTime lastActDate;
    private LocalDateTime signOutDate;
    private String signOutReason;
    private Boolean receptionSMS;
    private Boolean receptionMail;
    private Integer point;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "grade")
    private Grade grade;
    private String accessIp;
    private Integer loginTry;

    public static Member createNewMember(SignUpInfoReq dto) {
        return Member.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .receptionMail(dto.getReceptionMail())
                .receptionSMS(dto.getReceptionSMS())
                .point(0)
                .grade(Grade.MEMBER)
                .loginTry(0)
                .build();
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

    public Member updatePrivateInfo(PrivateInfoDTO dto) {
        this.password = dto.getPassword();
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.zipCode = dto.getZipCode();
        this.address = dto.getAddress();
        this.detailAddress = dto.getDetailAddress();
        this.roadZipCode = dto.getRoadZipCode();
        this.roadAddress = dto.getRoadAddress();
        this.detailRoadAddress = dto.getDetailRoadAddress();
        this.birthday = dto.getBirthday();
        this.receptionMail = dto.getReceptionMail();
        this.receptionSMS = dto.getReceptionSMS();

        return this;
    }
}
