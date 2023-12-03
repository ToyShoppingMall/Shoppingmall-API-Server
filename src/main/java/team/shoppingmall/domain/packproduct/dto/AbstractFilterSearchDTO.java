package team.shoppingmall.domain.packproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class AbstractFilterSearchDTO {

    private String name;
    private Integer price;
}
