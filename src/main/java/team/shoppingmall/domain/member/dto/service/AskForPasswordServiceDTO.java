package team.shoppingmall.domain.member.dto.service;

import lombok.Getter;

@Getter
public class AskForPasswordServiceDTO extends AskForIdServiceDTO {

    private String id;

    public AskForPasswordServiceDTO(String id, String name, String phoneNumber) {
        super(name, phoneNumber);
        this.id = id;
    }
}
