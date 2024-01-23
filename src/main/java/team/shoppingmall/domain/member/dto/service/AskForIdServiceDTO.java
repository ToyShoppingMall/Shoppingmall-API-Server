package team.shoppingmall.domain.member.dto.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AskForIdServiceDTO {

    private String name;
    private String phoneNumber;
}
