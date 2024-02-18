package team.shoppingmall.domain.member.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AskForIdDTO {

    private String name;
    private String phoneNumber;
}
