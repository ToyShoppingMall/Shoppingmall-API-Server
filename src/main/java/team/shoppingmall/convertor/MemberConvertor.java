package team.shoppingmall.convertor;

import team.shoppingmall.domain.member.entity.Member;
import team.shoppingmall.domain.member.dto.service.SingUpInfoServiceDTO;

public class MemberConvertor {

    public static Member convert(SingUpInfoServiceDTO dto) {
        return new Member(
                dto.getId(),
                dto.getPassword(),
                dto.getName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                dto.getReceptionSMS(),
                dto.getReceptionMail(),
                dto.getAccessIp()
        );
    }
}
