package team.shoppingmall.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {
    MEMBER("member"),
    FRIEND("friend"),
    FAMILY("family"),
    VIP("vip");

    private final String name;
}
