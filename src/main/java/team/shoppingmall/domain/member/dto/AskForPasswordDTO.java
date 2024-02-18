package team.shoppingmall.domain.member.dto;

import lombok.Getter;

@Getter
public class AskForPasswordDTO extends AskForIdDTO {

    private String id;

    public AskForPasswordDTO(String id, String name, String phoneNumber) {
        super(name, phoneNumber);
        this.id = id;
    }
}
